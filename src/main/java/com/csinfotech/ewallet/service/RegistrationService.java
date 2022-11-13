package com.csinfotech.ewallet.service;

import com.csinfotech.ewallet.model.RegistrationModel;
import com.csinfotech.ewallet.model.UserPostModel;
import com.csinfotech.ewallet.repos.RegistrationRepo;
import com.csinfotech.ewallet.repos.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepo registrationRepo;

    @Autowired
    private UserPostRepository userPostRepository;

    public void submitMyData(RegistrationModel registrationModel) {
        registrationRepo.save(registrationModel);
    }


    public List<RegistrationModel> getUserData() {
        return registrationRepo.findAll();
    }

    public List<RegistrationModel> getUserDataById(Long id) {
        return registrationRepo.findAllById(Collections.singleton(id));
    }

    public void deleteUserById(Long id) {
        registrationRepo.deleteById(id);
    }

    public void userPostSubmit(UserPostModel model){
        userPostRepository.save(model);
    }




}
