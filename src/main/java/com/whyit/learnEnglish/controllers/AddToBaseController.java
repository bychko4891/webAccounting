package com.whyit.learnEnglish.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whyit.learnEnglish.addtobase.TranslationPair;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class AddToBaseController {
    @GetMapping(path = "/englishADD")
    public void textADD(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter printWriter = null;
        try {
//            TranslationPair.checkingTheValidityOfTheText(request.getParameter("ukrText"), request.getParameter("engText"));
            printWriter = response.getWriter();
            printWriter.println(new ObjectMapper().writeValueAsString(TranslationPair.checkingTheValidityOfTheText(request.getParameter("ukrText"), request.getParameter("engText"))));
//            System.out.println(TranslationPair.checkingTheValidityOfTheText(request.getParameter("ukrText"), request.getParameter("engText")).toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            printWriter.close();
        }
//            System.out.println("It is OK!!! " + ukrText + " " + engText);
    }
}
