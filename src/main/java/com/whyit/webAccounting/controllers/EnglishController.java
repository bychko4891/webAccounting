package com.whyit.webAccounting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.whyit.webAccounting.English;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class EnglishController {
  English engl1 = new English();
  English engl2 = new English();
    @GetMapping("/english")
    public String greeting(Model model) {
        String str1 = engl1.test();
        String str2 = engl2.test2();
        model.addAttribute("title", "English");
        model.addAttribute("Ukrainian_text", str1);
        model.addAttribute("English_text", str2);
        return "english";
    }



}
