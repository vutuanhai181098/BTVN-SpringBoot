package com.btvnSpringBoot.btnvnSpringBoot.controller;

import com.btvnSpringBoot.btnvnSpringBoot.entities.BMI;
import com.btvnSpringBoot.btnvnSpringBoot.exception.BMIException;
import com.btvnSpringBoot.btnvnSpringBoot.service.BMIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bmi")
public class BMIController {
    private BMIService bmiService;
    public BMIController(){
        bmiService = new BMIService();
    }
    @GetMapping("")
    public ResponseEntity<?> getBMI(@RequestParam Float height, @RequestParam Float weight){
        try {
            return new ResponseEntity<Float>(bmiService.indexBMI(height, weight), HttpStatus.OK);
        } catch (BMIException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> postBMI(@RequestBody BMI bmi){
        try {
            return new ResponseEntity<Float>(bmiService.indexBMI(bmi.getHeight(), bmi.getWeight()), HttpStatus.OK);
        } catch (BMIException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
