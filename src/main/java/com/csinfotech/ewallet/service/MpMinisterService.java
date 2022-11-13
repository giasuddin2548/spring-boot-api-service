package com.csinfotech.ewallet.service;

import com.csinfotech.ewallet.model.MpCommentModel;
import com.csinfotech.ewallet.repos.MPMinisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MpMinisterService {
    @Autowired
    private MPMinisterRepository repository;

    public List<MpCommentModel> getMpComments() {
        new MpCommentModel(1,2,"", "", "", "", "");
        return repository.findAll();

    }

}
