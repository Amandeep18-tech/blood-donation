package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;

public interface RewardsService {
    void rewardCollection(int donorId);
    void displayCoupon(int donorId) throws CustomException;
    void displayRewards(int donorId) throws CustomException;
}
