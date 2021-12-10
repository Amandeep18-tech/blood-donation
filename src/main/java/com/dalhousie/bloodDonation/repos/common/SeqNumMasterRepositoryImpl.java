package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.model.common.SeqNumMaster;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeqNumMasterRepositoryImpl implements SeqNumMasterRepository {
    @Override
    public SeqNumMaster getSeqNumMaster(String seqName) {
        SeqNumMaster seqNumMaster = new SeqNumMaster();
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM seq_num_master where seq_name='" + seqName + "'");
            if (resultSet.next()) {
                seqNumMaster.setSeqName(resultSet.getString(1));
                seqNumMaster.setSeqNum(resultSet.getInt(2));
                seqNumMaster.setSeqPattern(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seqNumMaster;
    }

    @Override
    public void incr(String seqName) {
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE seq_num_master SET seq_no=seq_no+1 where seq_name='" + seqName + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
