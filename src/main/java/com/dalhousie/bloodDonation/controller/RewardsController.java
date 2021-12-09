package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.RewardsServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class RewardsController {
Scanner sc = new Scanner(System.in);
RewardsServiceImpl rewardsServiceImpl = new RewardsServiceImpl();
    public void menu() throws CustomException {
        int choice;
        do{
            System.out.println("Enter 1 if you have donated blood");
            System.out.println("Enter 2 if you have not donated blood");
            System.out.println("3.Display coupoun code");
            System.out.println("Enter your choice:-");
            choice = sc.nextInt();
            switch(choice){
                case 1: rewardsSystem();
                    break;

                case 2:
                    System.out.println("Donate blood!");
                    break;

                case 3:
                    displayCoupon();
                    break;

            }

        }while(choice!=4);
    }

    public void rewardsSystem(){
        System.out.println("Enter your donor ID:- ");
        int donorId = sc.nextInt();
        rewardsServiceImpl.rewardCollection(donorId);
    }

    public void displayCoupon() throws CustomException {
        System.out.println("Enter your donor ID:-");
        int donorId = sc.nextInt();
        rewardsServiceImpl.displayCoupon(donorId);
    }

}
