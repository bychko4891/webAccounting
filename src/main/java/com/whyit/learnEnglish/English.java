package com.whyit.learnEnglish;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class English {
    private String ukrText;
    private String engText;

    public English() {
        this.ukrText = test();
        this.engText = test2();
    }

    private static int randomNumber;
    public String test() {
        random();
        List<String> arrayStringEnglish = Arrays.asList("Ти бачиш?", "Ти бачив?", "Ти побачиш?", "Ти побачиш.", "Ти бачиш.", "Ти бачив.",
                "Ти не бачив.", "Ти не бачиш.", "Ти не побачишь.");
        return arrayStringEnglish.get(randomNumber);
    }
    public String test2() {
        List<String> arrayStringEnglish = Arrays.asList("Do you see?", "Did you see?", "Will you see?", "You will see.", "You see.", "You saw.",
            "You did not see.","You don`t see.","You will not see.");
        return arrayStringEnglish.get(randomNumber);
    }

    private void random(){
        randomNumber = new Random().nextInt(0, 9);
    }

    public String getUkrText() {
        return ukrText;
    }

    public String getEngText() {
        return engText;
    }

    @Override
    public String toString() {
        return ukrText + engText;
    }
}
