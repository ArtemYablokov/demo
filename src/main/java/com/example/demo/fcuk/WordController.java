package com.example.demo.fcuk;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordController {

    @GetMapping("/health")
    public String healthCheck() {
//        return new ResponseEntity<>("TEST", HttpStatus.OK);
        return "TEST";
    }

//    @GetMapping("/health")
//    public ResponseEntity<HttpStatus> healthCheck() {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
