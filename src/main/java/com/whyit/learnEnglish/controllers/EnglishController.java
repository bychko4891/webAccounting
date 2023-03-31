package com.whyit.learnEnglish.controllers;

import com.whyit.learnEnglish.CheckBeforeAdding;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whyit.learnEnglish.English;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class EnglishController {


    @GetMapping("/english")
    public String greeting(Model model) {
//        English english = new English();
//        model.addAttribute(english.getUkrText());
        model.addAttribute("title", "English");
//        model.addAttribute("Ukrainian_text", english.getUkrText());
//        model.addAttribute("English_text", english.getEngText());
        return "english";
    }

    @GetMapping(path = "/englishJSON")
    public void response2(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.println(new ObjectMapper().writeValueAsString(new English()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            printWriter.close();
        }
    }

    @GetMapping(path = "/englishADD")
    public void textADD(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            CheckBeforeAdding check = new CheckBeforeAdding(request.getParameter("ukrText"), request.getParameter("engText"));
            printWriter.print(check.checkingTextForLength());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            printWriter.close();
        }
//            System.out.println("It is OK!!! " + ukrText + " " + engText);
    }
    //    @GetMapping(value ="/eng", params = "name")
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ResponseBody
//    public String response2(@RequestParam(value = "name", required = false)String name){
//        String jsonString = "";
//        English english = new English();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            jsonString = mapper.writeValueAsString(english);
//            System.out.println(jsonString);
//            return jsonString;
//        } catch (Exception e) {
//            jsonString = "Json Error";
//        }
//        return jsonString;
//    }
//    @GetMapping(value ="/english2", params = "name")
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ResponseBody
//    public void response2(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        PrintWriter printWriter = response.getWriter();
//
//        String jsonString = "";
//        English english = new English();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            jsonString = mapper.writeValueAsString(english);
//            System.out.println(jsonString);
////            return jsonString;
//        } catch (Exception e) {
//            jsonString = "Json Error";
//        }
//        printWriter.print(jsonString);
//        printWriter.close();
////        return "english";
//    }

    //    @RequestMapping(path = "/englishGSON", method = RequestMethod.GET)
//    public String resp(@RequestParam(value = "name", required = false) String name) {
////        PrintWriter printWriter = response.getWriter();
////        response.setContentType("text/html");
////        String jsonString = "";
////        English english = new English();
////        ObjectMapper mapper = new ObjectMapper();
////        try {
////            jsonString = mapper.writeValueAsString(english);
//////            System.out.println(jsonString);
//////            return jsonString;
////        } catch (Exception e) {
////            jsonString = "Json Error";
////        }
////        printWriter.println(jsonString);
////        System.out.println(jsonString);
////        printWriter.close();
//        return "english222";
//    }


}
