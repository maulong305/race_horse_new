package com.bluebottle.racehorse.controller;

import com.bluebottle.racehorse.model.email.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/email")
public class EmailController {
    @PostMapping()
    public ResponseEntity<Email> sendEmail(){
        final String uri = "api.postmarkapp.com/email";
        RestTemplate restTemplate = new RestTemplate();

        Email newEmail = new Email();

        Email result = restTemplate.postForObject( uri, newEmail, Email.class);

        System.out.println(result);
        return new ResponseEntity<>(newEmail, HttpStatus.OK);
    }

}
