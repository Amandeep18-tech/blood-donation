package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.common.NotificationServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class NotificationTest {
    NotificationServiceImpl notificationServiceImpl = new NotificationServiceImpl();
    @Test
    @Disabled
   public void notificationForSingleUser() throws SQLException, ClassNotFoundException, CustomException {
        notificationServiceImpl.sendMailToSingleUser("janhavisonawane33@gmail.com","high","Emergency");
    }

    @Test
    public void notificationForMultipleUser(){
        //notificationServiceImpl.sendMailToMultipleUser();
    }
}
