package com.whyit.webAccounting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.whyit.webAccounting.English;

@RestController
public class JsonController {
    @GetMapping
    public English getEnglish() {
        var engl = new English();
        System.out.println(engl);
        return engl;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
