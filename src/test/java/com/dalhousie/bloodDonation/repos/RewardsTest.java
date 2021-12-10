package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.repos.donor.RewardsRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RewardsTest {

    RewardsRepository rewardsRepository = new RewardsRepository();
    @Test
    @Disabled
    void displayCoupon() throws CustomException {
        int donorId = 103;
        rewardsRepository.displayCoupon(donorId);
    }

    @Test
    @Disabled
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
