package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.SeqNumMaster;

public interface SeqNumMasterRepository {
    SeqNumMaster getSeqNumMaster(String seqName);

    void incr(String seqName);
}
