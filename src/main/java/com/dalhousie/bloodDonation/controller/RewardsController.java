package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.RewardsServiceImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class RewardsController {
    private final Scanner sc;

    public RewardsController() {
        sc = IOUtils.getInstance();
    }

    RewardsServiceImpl rewardsServiceImpl = new RewardsServiceImpl();

    public void menu() throws CustomException {
        int choice;
        do {
            System.out.println("1.CollectPoints");
            System.out.println("2.Display coupoun code");
            System.out.println("3.Display Reward Points");
            System.out.println("Enter your choice:-");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    rewardsSystem();
                    break;

                case 2:
                    displayCoupon();
                    break;

                case 3:
                    displayRewards();
                    break;

            }

        } while (choice != 4);
    }

    public void rewardsSystem() {
        System.out.println("Enter your donor ID:- ");
        int donorId = sc.nextInt();
        rewardsServiceImpl.rewardCollection(donorId);
    }

    public void displayCoupon() throws CustomException {
        System.out.println("Enter your donor ID:-");
        int donorId = sc.nextInt();
        rewardsServiceImpl.displayCoupon(donorId);
    }
    public void displayRewards() throws CustomException{
        System.out.println("Enter your donor ID");
        int donorId = sc.nextInt();
        rewardsServiceImpl.displayRewards(donorId);
    }

}
