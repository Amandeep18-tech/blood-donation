package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.model.BloodDonationDetail;
import com.dalhousie.bloodDonation.model.BloodRequestOrganisation;

import java.util.ArrayList;
import java.util.List;

public class BloodDonationDetailsRepository {
    public List<BloodDonationDetail> getAllRecords() {
        List<BloodDonationDetail> bloodDonationDetails = new ArrayList<>();
        BloodDonationDetail bloodDonationDetail = new BloodDonationDetail();
        bloodDonationDetail.setBloodGroup(BloodGroup.ABNeg);
        bloodDonationDetail.setDonorID("D001");
        bloodDonationDetail.setDonatedAt("21/05/2021");
        bloodDonationDetail.setOrgId("O001");
        bloodDonationDetail.setStatus(BloodDonationStatus.unused);
        bloodDonationDetails.add(bloodDonationDetail);
        BloodDonationDetail bloodDonationDetail2 = new BloodDonationDetail();
        bloodDonationDetail2.setBloodGroup(BloodGroup.BPos);
        bloodDonationDetail2.setDonorID("D002");
        bloodDonationDetail2.setDonatedAt("21/05/2021");
        bloodDonationDetail2.setOrgId("O001");
        bloodDonationDetail2.setStatus(BloodDonationStatus.unused);
        bloodDonationDetails.add(bloodDonationDetail2);
        return bloodDonationDetails;
    }

    public void update(BloodDonationDetail bloodDonationDetail) {
    }

    public void save(BloodRequestOrganisation bloodRequestOrganisation) {
    }
}
