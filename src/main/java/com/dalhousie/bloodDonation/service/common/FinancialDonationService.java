package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.constants.DonationType;
import com.dalhousie.bloodDonation.exception.CustomException;

public interface FinancialDonationService {
    void validateCreditCard(String cardNo) throws CustomException;

    void validateExpiryDate(String expiryDate) throws CustomException;

    void validateCVV(String expiryDate) throws CustomException;

    void validateUPI(String upi) throws CustomException;

    boolean makeDonationByCard(Double amount, String cardNo, String expiryDate, String cvv) throws CustomException;

    boolean makeDonationByUPI(Double amount, String upi) throws CustomException;

    boolean verifyDonation(String transRefNum, DonationType bankTransfer) throws CustomException;

    void validateAndSendLink(Double amount, String mobileNumber) throws CustomException;

    void makeDonation(String refNumber, DonationType donationType);
}
