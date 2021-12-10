package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.repos.donor.RewardsRepository;

public class RewardsServiceImpl implements RewardsService{
    RewardsRepository rewardsRepository = new RewardsRepository();
    @Override
    public void rewardCollection(int donorId) {
     rewardsRepository.rewards(donorId);
    }

    @Override
    public void displayCoupon(int donorId) throws CustomException {
        rewardsRepository.displayCoupon(donorId);
    }

    @Override
    public void displayRewards(int donorId) throws CustomException {
        rewardsRepository.displayRewards(donorId);
    }
}
