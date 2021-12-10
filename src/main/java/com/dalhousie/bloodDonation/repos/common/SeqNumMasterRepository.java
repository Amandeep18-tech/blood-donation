package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.model.common.SeqNumMaster;

public interface SeqNumMasterRepository {
    SeqNumMaster getSeqNumMaster(String seqName);

    void increment(String seqName);
}
