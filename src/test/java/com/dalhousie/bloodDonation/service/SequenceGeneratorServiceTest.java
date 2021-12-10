package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.service.common.SequenceGeneratorService;
import com.dalhousie.bloodDonation.service.common.SequenceGeneratorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
