package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;

public interface NotificationService {
    public boolean sendMailToSingleUser(String userName,String priority,String message_keyword) throws SQLException, ClassNotFoundException;
    public boolean sendMailToMultipleUser();
}
