package com.neosoft.service;

import com.neosoft.model.EmailModel;
import com.neosoft.model.User;
import com.neosoft.model.UserCredentials;
import com.neosoft.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepoImpl;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    public User signUp(User user) throws MessagingException {


        EmailModel emailModel = new EmailModel();

        emailModel.setToEmail(user.getEmailId());
        emailModel.setSubject("Congratulation...");

        emailModel.setBody("Hello " + user.getUserName() + ", your have been successfully created! " +
                "following are the User Credentials"
                +"UserNmae="+user.getEmailId()+"User Passward is "+user.getPassword());

        emailServiceImpl.sendEmail(emailModel);
        //    notification.sendEmail(user);
        return userRepoImpl.save(user);


    }


    public String signIn(UserCredentials userCredentials) {

        String ss="";
       List<User> users= userRepoImpl.findAll();

       for (   User uu   :users)
       {
           if(uu.getEmailId().equals(userCredentials.getEmailId())  && uu.getPassword().equals(userCredentials.getPassword()))
           {
               ss="Successfully LoggedIn";
               break;
           }
           else
               ss="Invalid Credebtails";

       }
        return ss;
    }

    public List<User> getAllData() {
    return userRepoImpl.findAll();
    }


    public User getdataByName(String userName) {
    return userRepoImpl.findByUserName();
    }

    public User getDataByEmailId(String emailId) {
      return userRepoImpl.findByEmailId();
    }

    public User getDataBycountry(String country) {
        return userRepoImpl.findByCountry();
    }


    public User getDataByContactnumber(long contactnumber) {
        return userRepoImpl.findByContactnumber();
    }

}
