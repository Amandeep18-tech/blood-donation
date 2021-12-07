package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.repos.RewardsRepository;

import java.sql.SQLException;

public class RewardsServiceImpl implements RewardsService{
    RewardsRepository rewardsRepository = new RewardsRepository();
    @Override
    public void rewardCollection(int donorId) {
     rewardsRepository.rewards(donorId);
    }

    @Override
    public void displayCoupon(int donorId) throws Exception {
        rewardsRepository.displayCoupon(donorId);
    }
}
