package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class NotificationTest {
    NotificationServiceImpl notificationServiceImpl = new NotificationServiceImpl();
    @Test
   public void notificationForSingleUser() throws SQLException, ClassNotFoundException, CustomException {
        notificationServiceImpl.sendMailToSingleUser("janhavisonawane33@gmail.com","high","Emergency");
    }

    @Test
    public void notificationForMultipleUser(){
        //notificationServiceImpl.sendMailToMultipleUser();
    }
}
