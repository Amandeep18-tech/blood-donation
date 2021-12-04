package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;

public interface RewardsService {
    public void rewardCollection(int donorId);
    public void displayCoupon(int donorId) throws Exception;
}
