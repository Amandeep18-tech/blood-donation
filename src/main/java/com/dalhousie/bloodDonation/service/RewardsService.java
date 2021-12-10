package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.sql.SQLException;

public interface RewardsService {
    public void rewardCollection(int donorId);
    public void displayCoupon(int donorId) throws CustomException;
    public void displayRewards(int donorId) throws CustomException;
}
