package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.DonationType;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.FinancialDonation;
import com.dalhousie.bloodDonation.model.PendingFinancialDonation;
import com.dalhousie.bloodDonation.repos.FinancialDonationRepository;
import com.dalhousie.bloodDonation.repos.PendingFinancialDonationRepository;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FinancialDonationServiceImpl implements FinancialDonationService {

    private static FinancialDonationRepository financialDonationRepository = null;
    private static PendingFinancialDonationRepository pendingFinancialDonationRepository = null;

    public FinancialDonationServiceImpl() {
        financialDonationRepository = new FinancialDonationRepository();
        pendingFinancialDonationRepository = new PendingFinancialDonationRepository();
    }

    @Override
    public void validateCreditCard(String cardNo) throws CustomException {
        if (cardNo.length() != 16) {
            throw new CustomException("Number of digits is " + cardNo.length() + "." +
                    " It must be 16 digits.");
        }
        int checkSum = 0;
        for (int i = 0; i < 16; i++) {
            int cardNumber = Integer.parseInt(String.valueOf(cardNo.charAt(i)));
            if (i % 2 == 0) {
                checkSum = checkSum + ((cardNumber * 2) % 9);
            } else {
                checkSum += cardNumber;
            }
        }
        if (checkSum % 10 != 0) {
            throw new CustomException("Card number is incorrect.");
        }
    }

    @Override
    public void validateExpiryDate(String expiryDate) throws CustomException {
        if (expiryDate.contains("/")) {
            String[] monthYear = expiryDate.split("/");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(20 + monthYear[1]), Integer.valueOf(monthYear[0]), 1);
            if (calendar.compareTo(Calendar.getInstance()) < 0) {
                throw new CustomException("Card Expired");
            }
        } else {
            throw new CustomException("Invalid Expiry date");
        }
    }

    @Override
    public void validateCVV(String expiryDate) throws CustomException {
        if (expiryDate.length() != 3 || !expiryDate.chars().allMatch(Character::isDigit)) {
            throw new CustomException("CVV must be only number");
        }
    }

    @Override
    public boolean makeDonationByCard(Double amount, String cardNo, String expiryDate, String cvv) throws CustomException {
        validateCreditCard(cardNo);
        validateExpiryDate(expiryDate);
        validateCVV(cvv);
        FinancialDonation financialDonation = new FinancialDonation("D001", amount, generateRefNumber(), DonationType.CARD);
        financialDonationRepository.save(financialDonation);
        return true;
    }

    @Override
    public boolean makeDonationByUPI(Double amount, String upi) throws CustomException {
        validateUPI(upi);
        FinancialDonation financialDonation = new FinancialDonation("D001", amount, generateRefNumber(), DonationType.UPI);
        financialDonationRepository.save(financialDonation);
        return true;
    }

    @Override
    public boolean verifyDonation(String transRefNum, DonationType donationType) throws CustomException {
        List<PendingFinancialDonation> pendingFinancialDonations = pendingFinancialDonationRepository.getAllPendingFinancialDonations();
        if (!pendingFinancialDonations.stream().anyMatch(pendingFinancialDonation ->
                pendingFinancialDonation.getTpRefNum().equalsIgnoreCase(transRefNum) && pendingFinancialDonation.getDonationType() == donationType
        )) {
            throw new CustomException("Invalid Transaction Reference Number");
        }
        return true;
    }

    @Override
    public void validateAndSendLink(Double amount, String mobileNumber) throws CustomException {
        if (!Pattern.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", mobileNumber)) {
            throw new CustomException("Invalid mobile number");
        }
    }

    @Override
    public void makeDonation(String refNumber, DonationType donationType) {
        List<PendingFinancialDonation> pendingFinancialDonations = pendingFinancialDonationRepository.getAllPendingFinancialDonations();
        PendingFinancialDonation pendingFinancialDonation = pendingFinancialDonations.stream().filter(x ->
                x.getDonationType() == donationType && x.getTpRefNum().equalsIgnoreCase(refNumber)
        ).collect(Collectors.toList()).get(0);
        FinancialDonation financialDonation = new FinancialDonation("", pendingFinancialDonation.getAmount(), generateRefNumber(), donationType);
        financialDonationRepository.save(financialDonation);
    }

    @Override
    public void validateUPI(String upi) throws CustomException {
        if (!Pattern.matches("[a-zA-Z0-9.\\-_]{2,256}@[a-zA-Z]{2,64}", upi)) {
            throw new CustomException("Invalid UPI format");
        }
    }

    private String generateRefNumber() {
        return "Ref-001";
    }
}
