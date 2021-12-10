package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.model.common.SeqNumMaster;
import com.dalhousie.bloodDonation.repos.common.SeqNumMasterRepository;
import com.dalhousie.bloodDonation.repos.common.SeqNumMasterRepositoryImpl;

public class SequenceGeneratorServiceImpl implements SequenceGeneratorService{

    private final SeqNumMasterRepository seqNumMasterRepository;

    public SequenceGeneratorServiceImpl(){
        seqNumMasterRepository = new SeqNumMasterRepositoryImpl();
    }

    @Override
    public String getSequenceNumber(String seqName) {
        SeqNumMaster seqNumMaster = seqNumMasterRepository.getSeqNumMaster(seqName);
        seqNumMasterRepository.increment(seqName);
        int start = seqNumMaster.getSeqPattern().indexOf("{");
        int end = seqNumMaster.getSeqPattern().indexOf("}");
        int length = end - start - 1;
        String num = String.format("%0"+length+"d",seqNumMaster.getSeqNum());

        return new StringBuffer(seqNumMaster.getSeqPattern()).replace(start,end+1,num).toString();
    }
}
