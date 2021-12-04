package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class NotificationTest {
    NotificationServiceImpl notificationServiceImpl = new NotificationServiceImpl();
    @Test
   public void notificationForSingleUser() throws SQLException, ClassNotFoundException {
        notificationServiceImpl.sendMailToSingleUser("janhavisonawane33@gmail.com","high","Emergency");
    }

    @Test
    public void notificationForMultipleUser(){
        notificationServiceImpl.sendMailToMultipleUser();
    }
}
