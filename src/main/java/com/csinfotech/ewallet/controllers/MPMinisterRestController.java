package com.csinfotech.ewallet.controllers;

import com.csinfotech.ewallet.service.MpMinisterService;
import com.csinfotech.ewallet.service.MpMinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class MPMinisterRestController {

    @Autowired
    private MpMinisterService mpMinisterService;



    @GetMapping("/get-mp-comments")
    public ResponseEntity<HashMap<String, Object>> getUser() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("total-comments", mpMinisterService.getMpComments().size());
        map.put("comments", mpMinisterService.getMpComments());


        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}