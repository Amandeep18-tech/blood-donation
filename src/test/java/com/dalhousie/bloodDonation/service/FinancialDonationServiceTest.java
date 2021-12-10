package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.DonationType;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.common.FinancialDonationService;
import com.dalhousie.bloodDonation.service.common.FinancialDonationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FinancialDonationServiceTest {

    private static FinancialDonationService financialDonationService;
    @BeforeAll
    static void setUp(){
        financialDonationService = new FinancialDonationServiceImpl();
    }

    @Test
    void validateCreditCard() throws CustomException {
        //Success
        try {
            financialDonationService.validateCreditCard("4012888888881881");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateCreditCard("4582"));
        Assertions.assertEquals("Number of digits is 4. It must be 16 digits.", customException.getMessage());

        CustomException customException2 = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateCreditCard("5181590102130441"));
        Assertions.assertEquals("Card number is incorrect.", customException2.getMessage());
    }

    @Test
    void validateExpiryDate() {
        //Success
        try {
            financialDonationService.validateExpiryDate("08/27");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateExpiryDate("01/21"));
        Assertions.assertEquals("Card Expired", customException.getMessage());

        CustomException customException2 = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateExpiryDate("5181590102130441"));
        Assertions.assertEquals("Invalid Expiry date", customException2.getMessage());
    }

    @Test
    void validateCVV() {
        //Success
        try {
            financialDonationService.validateCVV("467");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateCVV("4Ad"));
        Assertions.assertEquals("CVV must be only number", customException.getMessage());
    }

    @Test
    void validateUPI() {
        //Success
        try {
            financialDonationService.validateUPI("karkan@ybl");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateUPI("test.123"));
        Assertions.assertEquals("Invalid UPI format", customException.getMessage());
    }

    @Test
    void makeDonationByCard() {
        //Success
        try {
            financialDonationService.makeDonationByCard(400.00,"4012888888881881","05/26","456");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.makeDonationByCard(400.00,"4012","05/26","456"));
        Assertions.assertEquals("Number of digits is 4. It must be 16 digits.", customException.getMessage());

        CustomException customException2 = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.makeDonationByCard(400.00,"5181590102130441","05/26","456"));
        Assertions.assertEquals("Card number is incorrect.", customException2.getMessage());
    }

    @Test
    void makeDonationByUPI() {
        //Success
        try {
            financialDonationService.makeDonationByUPI(400.00,"karkan@ybl");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.makeDonationByUPI(400.00,"test.123"));
        Assertions.assertEquals("Invalid UPI format", customException.getMessage());
    }

    @Test
    @Disabled
    void verifyDonation() {
        //Success
        try {
            financialDonationService.verifyDonation("Ref-001", DonationType.CASH);
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.verifyDonation("Ref-001", DonationType.CARD));
        Assertions.assertEquals("Invalid Transaction Reference Number", customException.getMessage());
        CustomException customException2 = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.verifyDonation("Ref-002", DonationType.CASH));
        Assertions.assertEquals("Invalid Transaction Reference Number", customException2.getMessage());
    }

    @Test
    void validateAndSendLink() {
        //Success
        try {
            financialDonationService.validateAndSendLink(400.00,"8870021788");
        }catch(CustomException ce){
            Assertions.fail();
        }

        //Failure
        CustomException customException = Assertions.assertThrows(CustomException.class,
                () -> financialDonationService.validateAndSendLink(400.00,"873516468"));
        Assertions.assertEquals("Invalid mobile number", customException.getMessage());
    }
}