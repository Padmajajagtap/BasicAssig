package com.neosoft.service;

import com.neosoft.model.EmailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Component
public class EmailServiceImpl {

    @Autowired
    JavaMailSender javaMailSender;
    //Step use JavaMail Sender API

    public void sendEmail(EmailModel regsiterInfoByMail ) throws MessagingException {
        //step 2 MimeMessage obj
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        //step 3 create MimeMessageHelper obj by passing (1)MimeMessage obj(2)with true

        mimeMessageHelper.setFrom("padmajajagtap1@gmail.com");

        mimeMessageHelper.setTo(regsiterInfoByMail.getToEmail());
        mimeMessage.setSubject(regsiterInfoByMail.getSubject());
        mimeMessageHelper.setText(regsiterInfoByMail.getBody());

        //step 4 send
        javaMailSender.send(mimeMessage);
        log.info("Mail Sent sucessfully");

    }
}

