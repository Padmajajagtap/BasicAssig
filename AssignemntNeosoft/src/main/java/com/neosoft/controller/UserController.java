package com.neosoft.controller;

import com.neosoft.model.User;
import com.neosoft.model.UserCredentials;
import com.neosoft.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/a")
@Slf4j
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp( @RequestBody User user) {

        User user1= new User();
        try {
             user1= userServiceImpl.signUp(user);
        } catch (MessagingException e) {
            log.info(e.getMessage());

        }
        return ResponseEntity.ok(user1);
    }

    @PostMapping("/singin")
    public ResponseEntity<String> signIn(@RequestBody UserCredentials userCredentials) {
        return ResponseEntity.ok(userServiceImpl.signIn(userCredentials));
    }

    @GetMapping("/getalluserdata")
    public ResponseEntity<List<User>> getAllData()
    {
        return ResponseEntity.ok(userServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname")
    public User getdatabyname(@PathVariable String userName ){
        return userServiceImpl.getdataByName(userName);
    }

    @GetMapping("/getdatabyemail/{emailId}")
    public User getDataByEmail(@PathVariable String emailId) {
        return userServiceImpl.getDataByEmailId(emailId);
    }


   @GetMapping("/getdatabycountry/{country}")
    public User getDataBycountry(@PathVariable String country) {

        return userServiceImpl.getDataBycountry(country);
    }

    @GetMapping("/getdatabycontactnumber/{contactnumber}")
    public User getDataByMobileNo(@PathVariable long contactnumber) {
        return userServiceImpl.getDataByContactnumber(contactnumber);
    }

}
