package com.whyit.webAccounting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class English {
    private static int randomNumber;
    public String test() {
        random();
        List<String> arrayStringEnglish = Arrays.asList("Ти бачиш?", "Ти бачив?", "Ти побачиш?", "Ти побачиш.", "Ти бачиш.", "Ти бачив.",
                "Ти не бачив.", "Ти не бачиш.", "Ти не побачишь.");
        String s = arrayStringEnglish.get(randomNumber);
        return s;
    }
    public String test2() {
        List<String> arrayStringEnglish = Arrays.asList("Do you see?", "Did you see?", "Will you see?", "You will see.", "You see.", "You saw.",
            "You did not see.","You don`t see.","You will not see.");
        String s = arrayStringEnglish.get(randomNumber);
        return s;
    }

    private void random(){
        randomNumber = new Random().nextInt(0, 9);
    }
}
