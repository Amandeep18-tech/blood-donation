package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientPersonalInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientPersonalInformationRepositoryImpl implements PatientPersonalInformationRepository {

    @Override
    public int addPatient(PatientPersonalInformation patientInfo) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "INSERT INTO patient_personal_information (patient_name, " + "date_of_birth, " + "age, " + "address, " + "contact_number, " + "email_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patientInfo.getPatientName());
            ps.setString(2, patientInfo.getDOB());
            ps.setInt(3, patientInfo.getAge());
            ps.setString(4, patientInfo.getAddress());
            ps.setString(5, patientInfo.getContactNumber());
            ps.setString(6, patientInfo.getEmailId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int patientId = 0;
            while (rs.next()) {
                patientId = rs.getInt(1);
            }
            System.out.println("Patient ID: " + patientId);
            return patientId;
        }catch (SQLException e){
            throw new CustomException("Error: ");
        }
    }

    @Override
    public List<PatientPersonalInformation> getAllPatients() throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "SELECT * FROM patient_personal_information";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<PatientPersonalInformation> patientList = new ArrayList<>();

            while (rs.next()) {
                PatientPersonalInformation patientPersonalInfo = new PatientPersonalInformation();
                patientPersonalInfo.setId(rs.getInt("id"));
                patientPersonalInfo.setPatientName(rs.getString("patient_name"));
                patientPersonalInfo.setDOB(rs.getString("date_of_birth"));
                patientPersonalInfo.setAge(rs.getInt("age"));
                patientPersonalInfo.setAddress(rs.getString("address"));
                patientPersonalInfo.setContactNumber(rs.getString("contact_number"));
                patientPersonalInfo.setEmailId(rs.getString("email_id"));
                patientList.add(patientPersonalInfo);
            }
            return patientList;
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

    @Override
    public void delete(int id) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "DELETE FROM patient_personal_information WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

    @Override
    public PatientPersonalInformation getPatient(int id) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "SELECT * FROM  patient_personal_information WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            PatientPersonalInformation patientPersonalInfo = new PatientPersonalInformation();
            ResultSet rs = ps.executeQuery();
            boolean check = false;
            while (rs.next()) {
                check = true;
                patientPersonalInfo.setId(rs.getInt("id"));
                patientPersonalInfo.setPatientName(rs.getString("patient_name"));
                patientPersonalInfo.setDOB(rs.getString("date_of_birth"));
                patientPersonalInfo.setAge(rs.getInt("age"));
                patientPersonalInfo.setAddress(rs.getString("address"));
                patientPersonalInfo.setContactNumber(rs.getString("contact_number"));
                patientPersonalInfo.setEmailId(rs.getString("email_id"));
            }

            if (check) {
                return patientPersonalInfo;
            } else {
                return null;
            }
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

    @Override
    public void update(PatientPersonalInformation patientPersonalInfo) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "UPDATE patient_personal_information SET patient_name= ?, " + "date_of_birth= ?, " + "age= ?, " + "address= ?, " + "contact_number= ?, " + "email_id= ?" + "WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, patientPersonalInfo.getPatientName());
            ps.setString(2, patientPersonalInfo.getDOB());
            ps.setInt(3, patientPersonalInfo.getAge());
            ps.setString(4, patientPersonalInfo.getAddress());
            ps.setString(5, patientPersonalInfo.getContactNumber());
            ps.setString(6, patientPersonalInfo.getEmailId());
            ps.setInt(7, patientPersonalInfo.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

}
