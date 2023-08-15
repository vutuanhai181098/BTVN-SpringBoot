package com.btvnSpringBoot.btnvnSpringBoot.controller;

import com.btvnSpringBoot.btnvnSpringBoot.exception.ColorException;
import com.btvnSpringBoot.btnvnSpringBoot.service.ColorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ColorController {
    private ColorService colorService;

    public ColorController(){
        colorService = new ColorService();
    }

    @GetMapping("/random-color")
    public ResponseEntity<?> getRandomColor(@RequestParam int type){
        try {
            return new ResponseEntity<String>(colorService.getRandomColor(type), HttpStatus.OK);
        } catch (ColorException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
