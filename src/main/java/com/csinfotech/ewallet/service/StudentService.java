package com.csinfotech.ewallet.service;

import com.csinfotech.ewallet.model.releations.Students;
import com.csinfotech.ewallet.repos.releations.StudentRepository;
import com.csinfotech.ewallet.repos.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserPostRepository userPostRepository;

//    public void submitMyData(RegistrationModel registrationModel) {
//        registrationRepo.save(registrationModel);
//    }


    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    public void submitStudent(Students students) {
        studentRepository.save(students);
    }

//    public List<RegistrationModel> getUserDataById(Long id) {
//        return registrationRepo.findAllById(Collections.singleton(id));
//    }
//
//    public void deleteUserById(Long id) {
//        registrationRepo.deleteById(id);
//    }
//
//    public void userPostSubmit(UserPostModel model){
//        userPostRepository.save(model);
//    }




}
