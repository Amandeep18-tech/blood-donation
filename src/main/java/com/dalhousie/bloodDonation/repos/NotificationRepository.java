package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.Notification;
import com.dalhousie.bloodDonation.model.SessionManagement;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.*;

public class NotificationRepository {
    public Notification fetchData(String priority1) throws ClassNotFoundException, SQLException {
        SessionManagement session = new SessionManagement();
        Connection con= DBUtils.getInstance().getConnection();
        String sql = "select * from notification_template ";
        PreparedStatement stmt = con.prepareStatement(sql);
        int notification_id = 0;
        String userName = null;
        String message = null;
        String sendTo = null;
        String messsage_priority = null;
        String notification_type = null;
        ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                message = rs.getString(3);
                if(message.contains("Emergency")) {
                    notification_id = rs.getInt(1);
                    userName = rs.getString(2);

                    sendTo = rs.getString(4);
                    messsage_priority = rs.getString(5);
                    notification_type = rs.getString(6);
                }
            }
        Notification notification = new Notification();
        notification.setNotification_id(notification_id);
        notification.setUserName(userName);
        notification.setMessage(message);
        notification.setSendTo(sendTo);
        notification.setPriority(messsage_priority);
        notification.setNotification_type(notification_type);
        return notification;

    }
}
