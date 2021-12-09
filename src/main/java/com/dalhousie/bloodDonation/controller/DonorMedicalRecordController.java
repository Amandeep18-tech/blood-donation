package com.dalhousie.bloodDonation.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.repos.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.service.DonorMedicalRecordImpl;
import com.dalhousie.bloodDonation.service.ManageAppointmentImpl;

public class DonorMedicalRecordController {
    private DonorMedicalRecords donorMedicalRecords = null;
    private DonorMedicalRecordsRepository donorMedicalRecordsRepository = null;
    private ManageAppointmentImpl manageAppointmentImpl = null;
    private DonorMedicalRecordImpl donorMedicalRecordImpl=null;
    private Person person=null;

    public DonorMedicalRecordController()  {
        donorMedicalRecords = new DonorMedicalRecords();
        donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        manageAppointmentImpl = new ManageAppointmentImpl();
        donorMedicalRecordImpl = new DonorMedicalRecordImpl();
        person= new Person();
    }

    public ArrayList<String> confirmTodayMedicalApppointment() throws CustomException{
        System.out.println("Today's Medical Test: ");
        ArrayList<String> todaysId= new ArrayList<String>();
        todaysId=donorMedicalRecordImpl.GetTodayMedicalRecord();
        if(todaysId.size()==0){
            throw new CustomException("No appointment for today");
        }
        return todaysId;
        
    }

    public void addMedicalRecords() throws CustomException {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> donorId= new ArrayList<String>();
        donorId=confirmTodayMedicalApppointment();
        for(int i=0;i<donorId.size();i++){
            
            System.out.println(donorId.get(i));
            
            System.out.println("Enter the whether the patient has hepatitis B ");
            String hepatitis_b_flag = sc.nextLine();
            donorMedicalRecords.setHepatitis_B(Integer.parseInt(hepatitis_b_flag));

            System.out.println("Enter the whether the patient has hepatitis C ");
            String hepatitis_c_flag = sc.nextLine();
            donorMedicalRecords.setHepatitis_C(Integer.parseInt(hepatitis_c_flag));

            System.out.println("Enter the whether the patient has  hemochromatosis");
            String hemochromatosis = sc.nextLine();
            donorMedicalRecords.setHemochromatosis(Integer.parseInt(hemochromatosis));

            System.out.println("Enter the whether the patient has  HIV");
            String hiv_flag = sc.nextLine();
            donorMedicalRecords.setHIV_flag(Integer.parseInt(hiv_flag));

            System.out.println("Enter hemoglobin count");
            String hemoglboin_count = sc.nextLine();
            donorMedicalRecords.setHemoglobin_level(Integer.parseInt(hemoglboin_count));

            System.out.println("Enter RBC count");
            String rbcCount = sc.nextLine();
            donorMedicalRecords.setRbcCount(Integer.parseInt(rbcCount));
            System.out.println("Enter platelet count");
            String plateletCount = sc.nextLine();
            donorMedicalRecords.setPlateletCount(Integer.parseInt(plateletCount));

            Boolean verifyMedicalDetails = donorMedicalRecordsRepository.addNewMedicalRecord(donorMedicalRecords);
            if (verifyMedicalDetails) {
                System.out.println("Details have been added");
            }
        }

        }

        public void editMedicalRecords() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the donor Id you want to edit details for :");
            String donorId = sc.nextLine();
            boolean checkDonorID = manageAppointmentImpl.CheckDonorMedicalID(donorId);
            if (checkDonorID) {
                donorMedicalRecords = manageAppointmentImpl.GetDonorDetails(donorId);
                System.out.println(" HIV :" + donorMedicalRecords.getHIV_flag() + " Hepatitis C: "
                        + donorMedicalRecords.getHepatitis_C() + " Hepatitis B " + donorMedicalRecords.getHepatitis_C()
                        + " Hemoglobin level " + donorMedicalRecords.getHemoglobin_level() + " Hemochromostatis: "
                        + donorMedicalRecords.getHemochromatosis()+" RBC count:"+donorMedicalRecords.getRbcCount()+" Platelet count:"+donorMedicalRecords.getPlateletCount());

                System.out.println("Enter the whether the patient has hepatitis B ");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                String checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String hepatitis_b_flag = sc.nextLine();
                    donorMedicalRecords.setHepatitis_B(Integer.parseInt(hepatitis_b_flag));
                }

                System.out.println("Enter the whether the patient has hepatitis C ");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String hepatitis_c_flag = sc.nextLine();
                    donorMedicalRecords.setHepatitis_C(Integer.parseInt(hepatitis_c_flag));
                }

                System.out.println("Enter the whether the patient has  hemochromatosis");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String hemochromatosis = sc.nextLine();
                    donorMedicalRecords.setHemochromatosis(Integer.parseInt(hemochromatosis));
                }

                System.out.println("Enter the whether the patient has  HIV");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String hiv_flag = sc.nextLine();
                    donorMedicalRecords.setHIV_flag(Integer.parseInt(hiv_flag));
                }

                System.out.println("Enter hemoglobin count");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String hemoglboin_count = sc.nextLine();
                    donorMedicalRecords.setHemoglobin_level(Integer.parseInt(hemoglboin_count));
                }

                System.out.println("Enter RBC count");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String rbc_count = sc.nextLine();
                    donorMedicalRecords.setRbcCount(Integer.parseInt(rbc_count));
                }

                System.out.println("Enter Platelet  count");
                System.out.println("Do you want to change this value");
                System.out.println("Press 1. To change 2. To go to the next value");
                checkChange = sc.nextLine();
                if (checkChange.equals("1")) {
                    String plateletCount = sc.nextLine();
                    donorMedicalRecords.setHemoglobin_level(Integer.parseInt(plateletCount));
                }

                Boolean verifyMedicalDetails = donorMedicalRecordsRepository.updateMedicalRecord(donorMedicalRecords,
                        donorId);

                if (verifyMedicalDetails) {
                    System.out.println("Details have been updated");
                }
            } else {
                System.out.println("This user does not exist...");
            }

    }

}
