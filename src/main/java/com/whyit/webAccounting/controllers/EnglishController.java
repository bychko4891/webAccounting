package com.whyit.webAccounting.controllers;

import ch.qos.logback.core.model.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.whyit.webAccounting.English;

import java.util.Arrays;
import java.util.List;

@Controller
public class EnglishController {

    // Повне володіння GET запросом
//    @GetMapping("/english")
//    public String englishPage(HttpServletRequest request, Model model) {
//        String parameter = request.getParameter("name");
//        English one = new English();
////        System.out.println(one.getJson());
//        model.addAttribute("title", "English");
////        if(parameter != null && parameter.equals("reload")){
////            String str1 = new English().test();
////            String str2 = new English().test2();
////            model.addAttribute("Ukrainian_text", str1);
////            model.addAttribute("English_text", str2);
////        } else {
//
//        model.addAttribute("Ukrainian_text", "str1");
//        model.addAttribute("English_text", "str2");
////        }
//        return "english";
//    }

    // другий спосіб отримання GET запросу з анотацією @RequestParam, якщо потрібні тільки самі параметри запросу
    @GetMapping("/eng")
    public String englishPage(@RequestParam(value = "name", required = false) String name, Model model) { //required = false щоб не було помилки, якщо не прийшли параметри в запрос
//        English one = new English();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonString = mapper.writeValueAsString(one);
//            System.out.println(jsonString);
//        } catch (Exception e) {
//            System.out.println("Json Error");
//        }
        model.addAttribute("English_text", "str2");
        return "eng";
    }
//    @RequestMapping("/english")
//    public String englishPage2(@RequestParam(value = "name", required = false)String name) {
//        String str = name;
//        English one = new English();
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = " ";
//        try {
//            jsonString = mapper.writeValueAsString(one);
//            System.out.println(jsonString);
//        } catch (Exception e) {
//            System.out.println("Json Error");
//        }
//
////        model.addAttribute("Ukrainian_text", jsonString);
////        model.addAttribute("English_text", "str2");
////        }
////        return "english";
//        return jsonString;
//    }
    @GetMapping("/eng2")
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    List<String> Response2(){

        return Arrays.asList("Do you see?", "Did you see?");
    }
}
