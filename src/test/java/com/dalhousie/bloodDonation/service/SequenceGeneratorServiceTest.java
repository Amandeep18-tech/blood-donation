package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceGeneratorServiceTest {

    private static SequenceGeneratorService sequenceGeneratorService;
    @BeforeAll
    static void setUp(){
        sequenceGeneratorService = new SequenceGeneratorServiceImpl();
    }

    @Test
    @Disabled
    void getSequenceNumber() {
        Assertions.assertEquals("Ref-00000",sequenceGeneratorService.getSequenceNumber("FIN_DON"));
    }
}
