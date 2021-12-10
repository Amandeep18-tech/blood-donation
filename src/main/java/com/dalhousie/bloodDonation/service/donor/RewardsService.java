package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;

public interface RewardsService {
    public void rewardCollection(int donorId);
    public void displayCoupon(int donorId) throws CustomException;
    public void displayRewards(int donorId) throws CustomException;
}
