package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.sql.SQLException;
import java.util.List;

public interface NotificationService {
    public boolean sendMailToSingleUser(String userName,String priority,String message_keyword) throws SQLException, ClassNotFoundException, CustomException;
    public boolean sendMailToMultipleUser(List<String> reciptients, String msg) throws CustomException;
}
