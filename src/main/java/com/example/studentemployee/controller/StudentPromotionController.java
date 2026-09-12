package com.example.studentemployee.controller;

import com.example.studentemployee.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotions")
public class StudentPromotionController {

    @PostMapping("/check")
    public String checkPromotion(@RequestBody Student student) {

        if (student.getGpa() != null && student.getGpa() > 7) {
            return "ELIGIBLE";
        }

        return "NOT_ELIGIBLE";
    }
}