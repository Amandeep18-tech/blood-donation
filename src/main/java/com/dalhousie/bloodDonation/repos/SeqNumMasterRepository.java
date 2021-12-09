package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.constants.DonationType;
import com.dalhousie.bloodDonation.model.PendingFinancialDonation;
import com.dalhousie.bloodDonation.model.SeqNumMaster;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeqNumMasterRepository {
    private final DBUtils dbUtils;

    public SeqNumMasterRepository() {
        dbUtils = new DBUtils();
    }

    public SeqNumMaster getSeqNumMaster(String seqName) {
        SeqNumMaster seqNumMaster = new SeqNumMaster();
        try {
            Connection conn = dbUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM seq_num_master where seq_name='"+seqName+"'");
            if (resultSet.next()){
                seqNumMaster.setSeqName(resultSet.getString(1));
                seqNumMaster.setSeqNum(resultSet.getInt(2));
                seqNumMaster.setSeqPattern(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seqNumMaster;
    }

    public void incr(String seqName) {
        try {
            Connection conn = dbUtils.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE seq_num_master SET seq_no=seq_no+1 where seq_name='"+seqName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
