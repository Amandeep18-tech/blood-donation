package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import org.junit.jupiter.api.Test;

public class RewardsTest {

    RewardsRepository rewardsRepository = new RewardsRepository();
    @Test
    void displayCoupon() throws CustomException {
        int donorId = 103;
        rewardsRepository.displayCoupon(donorId);
    }

    @Test
    void displayRewards() throws CustomException{
        int donorId = 104;
        rewardsRepository.displayRewards(donorId);
    }

    @Test
    void getRewards() throws CustomException{
        int donorId = 104;
        rewardsRepository.rewards(donorId);
    }
}
