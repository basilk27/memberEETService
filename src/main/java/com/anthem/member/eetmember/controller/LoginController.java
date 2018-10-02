package com.anthem.member.eetmember.controller;

import com.anthem.member.eetmember.domain.Login;
import com.anthem.member.eetmember.domain.LoginStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("loginControllerV1")
@RequestMapping("/v1/api")
public class LoginController {

    @PostMapping(value = "/login")
    public ResponseEntity<?> login( @RequestBody Login login ) {
        //bmk for now just return this.
        System.out.println( "bmk for now just return this to test out" );
        LoginStatus loginStatus = new LoginStatus(true, "Valid login");

        return new ResponseEntity<>( loginStatus, HttpStatus.OK );
    }
}
