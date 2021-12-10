package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.SeqNumMaster;
import com.dalhousie.bloodDonation.repos.SeqNumMasterRepository;
import com.dalhousie.bloodDonation.repos.SeqNumMasterRepositoryImpl;

public class SequenceGeneratorServiceImpl implements SequenceGeneratorService{

    private SeqNumMasterRepository seqNumMasterRepository;

    public SequenceGeneratorServiceImpl(){
        seqNumMasterRepository = new SeqNumMasterRepositoryImpl();
    }

    @Override
    public String getSequenceNumber(String seqName) {
        SeqNumMaster seqNumMaster = seqNumMasterRepository.getSeqNumMaster(seqName);
        seqNumMasterRepository.incr(seqName);
        int start = seqNumMaster.getSeqPattern().indexOf("{");
        int end = seqNumMaster.getSeqPattern().indexOf("}");
        int length = end - start - 1;
        String num = String.format("%0"+length+"d",seqNumMaster.getSeqNum());

        return new StringBuffer(seqNumMaster.getSeqPattern()).replace(start,end+1,num).toString();
    }
}
