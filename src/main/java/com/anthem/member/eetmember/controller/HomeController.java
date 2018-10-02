package com.anthem.member.eetmember.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("homeControllerV1")
@RequestMapping("/v1/api")
public class HomeController {

    @GetMapping(value = "/home")
    public ResponseEntity<?> home() {
        return new ResponseEntity<>( HttpStatus.OK );
    }

}
