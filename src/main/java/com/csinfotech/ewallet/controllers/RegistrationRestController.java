package com.csinfotech.ewallet.controllers;
import com.csinfotech.ewallet.model.RegistrationModel;
import com.csinfotech.ewallet.model.UserPostModel;
import com.csinfotech.ewallet.model.releations.StdPayments;
import com.csinfotech.ewallet.model.releations.StdResults;
import com.csinfotech.ewallet.model.releations.StdSubject;
import com.csinfotech.ewallet.model.releations.Students;
import com.csinfotech.ewallet.service.PostService;
import com.csinfotech.ewallet.service.RegistrationService;
import com.csinfotech.ewallet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationRestController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private PostService postService;

    @Autowired
    private StudentService studentService;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/app-info")
    public String getAppDetails(){
        return "Name: "+appName+"\n"+" Version: "+appVersion;
    }



    @PostMapping("/submit-user")
    public HashMap<String, Object> submitData(

            @RequestParam(value = "password") String password,
            @RequestParam(value = "fullname") String fullname,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "tramsChecked") Boolean tramsChecked

    ){
        registrationService.submitMyData(new RegistrationModel(password,fullname, email,phone, tramsChecked));
        HashMap<String, Object> map=new HashMap<>();
        map.put("code", "1");
        map.put("Status", "Data submit success");
        return map;
    }

    @GetMapping("/get-user")
    public ResponseEntity<HashMap<String, Object>> getUser(){
        HashMap<String, Object> map=new HashMap<>();
        map.put("total-users", registrationService.getUserData().size());
        map.put("users", registrationService.getUserData());
        return new  ResponseEntity<>(map, HttpStatus.OK);
    }

    ///http://localhost:8181/mobile/get-user/12
    @GetMapping("/get-user/{id}")
    public HashMap<String, Object> getUserByID(@PathVariable("id") Long id){
        HashMap<String, Object> map=new HashMap<>();
        map.put("total-users", registrationService.getUserDataById(id).size());
        map.put("requestId", id);
        map.put("users", registrationService.getUserDataById(id));
        return  map;
    }



    ///http://localhost:8181/mobile/get-userbyid?id=4;
    @GetMapping("/get-userbyid")
    public HashMap<String, Object> getUserByIdPram(@RequestParam("id") Long id){
        HashMap<String, Object> map=new HashMap<>();
        map.put("total-users", registrationService.getUserDataById(id).size());
        map.put("requestId", id);
        map.put("users", registrationService.getUserDataById(id));
        return  map;
    }


    ///http://localhost:8181/mobile/get-userbyid?id=4;
    @GetMapping("/get-userbyid-with-token")
    public HashMap<String, Object> getUserByIdPramWithToken(@RequestParam("id") Long id, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("total-users", registrationService.getUserDataById(id).size());
        map.put("requestId", id);
        map.put("token", token);
        map.put("users", registrationService.getUserDataById(id));
        return  map;
    }


    ///http://localhost:8181/mobile/get-userbyid?id=4;
    @DeleteMapping("/delete-user")
    public HashMap<String, Object> deleteUserById(@RequestParam("id") Long id, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("requestId", id);
        map.put("token", token);
        map.put("status", "Deleted success");
        registrationService.deleteUserById(id);
        return  map;
    }



    @PostMapping("/submit-post")
    public HashMap<String, Object> submitUserPost(@RequestParam("userId") Long userId, @RequestParam("title") String title, @RequestParam("body") String body, @RequestParam("date") String date, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("token", token);
        postService.userPostSubmit(new UserPostModel(userId, title, body, date));
        return  map;
    }

    @GetMapping("/get-user-post")
    public HashMap<String, Object> getUserPost(@RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("token", token);
        map.put("post", postService.getPost());
        return  map;
    }

    @PostMapping("/submit-post-with-json")
    public HashMap<String, Object> submitUserPost2(@Valid @RequestBody UserPostModel userPostModel, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("token", token);
        map.put("status", "Post saved successful");
        postService.userPostSubmit(userPostModel);
        return  map;
    }

    @PutMapping("/update-post-with-json")
    public HashMap<String, Object> updatePost(@RequestBody UserPostModel userPostModel, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("token", token);
        map.put("status", "Post updated successful");
        postService.userPostSubmit(userPostModel);
        return  map;
    }


    @DeleteMapping("/delete-post-with-json")
    public HashMap<String, Object> deletePost(@RequestParam("id") Long id, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("token", token);
        map.put("status", "Post deleted successful");
        postService.deletePostById(id);
        return  map;
    }

    @GetMapping("/get-post-by-id")
    public HashMap<String, Object> getPostById(@RequestParam("id") Long id, @RequestHeader("token") String token){
        HashMap<String, Object> map=new HashMap<>();
        map.put("token", token);
        map.put("post", postService.getPostById(id));
        return  map;
    }


    @GetMapping("/get-students")
    public HashMap<String, Object> getStudents(){
        HashMap<String, Object> map=new HashMap<>();
        map.put("students-list", studentService.getStudents());
        return  map;
    }

    @PostMapping("/submit-students")
    public ResponseEntity<String> submitStudents(
            @RequestParam("username") String username,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userPhone") String userPhone,
            @RequestParam("userPass") String userPass,
            @RequestParam("subName") String subName,

            @RequestParam("subCode") int subCode,
            @RequestParam("marks") int marks,
            @RequestParam("semesterName") String semesterName,

            @RequestParam("month") String month,
            @RequestParam("fees") double fees
    ){
        List<StdSubject> subjectList=new ArrayList<>();
        subjectList.add(new StdSubject("Phy", 301));
        subjectList.add(new StdSubject("Che", 302));
        studentService.submitStudent(new Students(username, userEmail, userPhone, userPass, new StdResults(subName, subCode, marks, semesterName), new StdPayments(month, fees), subjectList));
        return  ResponseEntity.ok("saved");
    }








}
