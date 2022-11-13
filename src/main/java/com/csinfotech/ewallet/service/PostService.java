package com.csinfotech.ewallet.service;

import com.csinfotech.ewallet.model.UserPostModel;
import com.csinfotech.ewallet.repos.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private UserPostRepository userPostRepository;

    public void userPostSubmit(UserPostModel model){
        userPostRepository.save(model);
    }

    public List<UserPostModel> getPost() {

        return userPostRepository.findAll();

    }

    public void deletePostById(Long id) {
        Optional<UserPostModel> postModel=userPostRepository.findById(id);

        if (postModel.isPresent()){
            userPostRepository.deleteById(id);
        }else {
            throw new RuntimeException("User already deleted");
        }
    }

    public UserPostModel getPostById(Long id) {
        Optional<UserPostModel> postModel=userPostRepository.findById(id);

        if (postModel.isPresent()){
           return userPostRepository.getReferenceById(id);
        }else {
            throw new RuntimeException("Post not found");
        }
    }
}
