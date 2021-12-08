package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.constants.DonationType;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.FinancialDonationService;
import com.dalhousie.bloodDonation.service.FinancialDonationServiceImpl;

import java.util.Scanner;

public class FinancialDonationController {

    private FinancialDonationService financialDonationService;
    private Scanner scanner;

    public FinancialDonationController() {
        financialDonationService = new FinancialDonationServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void selectModeOfPayment() {
        System.out.println("*********Donation*******");
        int modeOfPayment;
        do {
            System.out.println("Mode of Payment");
            System.out.println("1. Cheque");
            System.out.println("2. Electronic Bank Transfers");
            System.out.println("3. Cash");
            System.out.println("4. UPI");
            System.out.println("5. Credit/Debit Card");
            System.out.println("6. Mobile Banking");
            System.out.println("9. Go Back");
            modeOfPayment = scanner.nextInt();
            try {
                switch (modeOfPayment) {
                    case 1:
                        getChequeDetails();
                        break;
                    case 2:
                        getBankTransferDetails();
                        break;
                    case 3:
                        getCashDetails();
                        break;
                    case 4:
                        getUPIDetails();
                        break;
                    case 5:
                        getCardDetails();
                        break;
                    case 6:
                        getMobileBankingDetails();
                        break;
                    default:
                        System.out.println("Invalid option. Retry.");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (modeOfPayment != 9);
        System.out.println("Transaction is complete. Thank you for your donation.");
    }

    private void getBankTransferDetails() throws CustomException {
        System.out.println("Enter transaction reference number:");
        String transRefNum = scanner.next();
        try {
            financialDonationService.verifyDonation(transRefNum, DonationType.BANK_TRANSFER);
            financialDonationService.makeDonation(transRefNum, DonationType.BANK_TRANSFER);
        } catch (CustomException e) {
            System.out.println("Invalid Details: " + e.getMessage());
        }
    }

    private void getChequeDetails() throws CustomException {
        System.out.println("Enter Cheque number:");
        String chequeNumber = scanner.next();
        try {
            financialDonationService.verifyDonation(chequeNumber, DonationType.CHEQUE);
            financialDonationService.makeDonation(chequeNumber, DonationType.CHEQUE);
        } catch (CustomException e) {
            System.out.println("Invalid Details: " + e.getMessage());
        }
    }

    private void getCashDetails() throws CustomException {
        System.out.println("Enter receipt number:");
        String transRefNum = scanner.next();
        try {
            financialDonationService.verifyDonation(transRefNum, DonationType.CASH);
            financialDonationService.makeDonation(transRefNum, DonationType.CASH);
        } catch (CustomException e) {
            System.out.println("Invalid Details: " + e.getMessage());
        }
    }

    private void getUPIDetails() throws CustomException {
        boolean transactionCompleted = false;
        System.out.println("Enter the amount to be donated:");
        Double amount = scanner.nextDouble();
        while (!transactionCompleted) {
            System.out.println("Enter UPI:");
            String upi = scanner.next();
            try {
                transactionCompleted = financialDonationService.makeDonationByUPI(amount, upi);
            } catch (CustomException e) {
                System.out.println("Invalid Card Details: " + e.getMessage());
            }
        }
    }

    private void getCardDetails() throws CustomException {
        boolean transactionCompleted = false;
        System.out.println("Enter the amount to be donated:");
        Double amount = scanner.nextDouble();
        while (!transactionCompleted) {
            System.out.println("Enter Credit/Debit Card No:");
            String cardNo = scanner.next();
            System.out.println("Enter the Expiry date(MM/YY):");
            String expiryDate = scanner.next();
            System.out.println("Enter the CVV:");
            String cvv = scanner.next();
            try {
                transactionCompleted = financialDonationService.makeDonationByCard(amount, cardNo, expiryDate, cvv);
            } catch (CustomException e) {
                System.out.println("Invalid Card Details: " + e.getMessage());
            }
        }
    }

    private void getMobileBankingDetails() throws CustomException {
        boolean transactionCompleted = false;
        System.out.println("Enter the amount to be donated:");
        Double amount = scanner.nextDouble();
        while (!transactionCompleted) {
            System.out.println("Enter Mobile No:");
            String mobileNumber = scanner.next();
            financialDonationService.validateAndSendLink(amount, mobileNumber);
            System.out.println("Follow the link in the SMS you have received and complete the transaction.");
            System.out.println("Enter the transaction reference number:");
            String transRefNumber = scanner.next();
            try {
                transactionCompleted = financialDonationService.verifyDonation(transRefNumber, DonationType.MOBILE_BANKING);
                financialDonationService.makeDonation(transRefNumber, DonationType.MOBILE_BANKING);
            } catch (CustomException e) {
                System.out.println("Invalid Card Details: " + e.getMessage());
            }
        }
    }
}
