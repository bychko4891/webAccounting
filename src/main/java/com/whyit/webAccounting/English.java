package com.whyit.webAccounting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class English {
    private static int randomNumber;
    String ukrText;//, engText;

    public English() {
        this.ukrText = test();
//        this.engText = test2();
    }


    public String test() {
        random();
        List<String> arrayStringEnglish = Arrays.asList("Ти бачиш?", "Ти бачив?", "Ти побачиш?", "Ти побачиш.", "Ти бачиш.", "Ти бачив.",
                "Ти не бачив.", "Ти не бачиш.", "Ти не побачишь.");
        return arrayStringEnglish.get(randomNumber);
    }
    public String test2() {
        List<String> arrayStringEnglish = Arrays.asList("Do you see?", "Did you see?", "Will you see?", "You will see.", "You see.", "You saw.",
            "You did not see.","You don`t see.","You will not see.");
        String s = arrayStringEnglish.get(randomNumber);
        return s;
    }

    private static void random(){
        randomNumber = new Random().nextInt(0, 9);
    }

    @Override
    public String toString() {
        return this.ukrText;
    }

//    public String getJson(){
//        ObjectMapper mapper = new ObjectMapper();
//        English one = new English();
//        try {
//            String str = mapper.writeValueAsString(this);
//            return str;
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String getUkrText() {
        return ukrText;
    }

//    public String getEngText() {
//        return engText;
//    }
}
