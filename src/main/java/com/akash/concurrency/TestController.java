package com.akash.MultiThreading.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
class TestController{

@GetMapping("/status")
public ResponseEntity<String> checkStatus(){
    return ResponseEntity.ok("Service is running fine"); 
}

}
