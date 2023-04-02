package com.whyit.learnEnglish.addtobase;


import com.whyit.learnEnglish.responsestatus.Message;
import com.whyit.learnEnglish.responsestatus.ResponseStatus;

import java.io.Serializable;
import java.util.regex.Pattern;


public class TranslationPair implements Serializable{
    private static int id;
    private String ukrText;
    private String engText;

    public TranslationPair(String ukrText, String engText) {
        this.ukrText = ukrText;
        this.engText = engText;
        id++;
    }

    public static ResponseStatus checkingTheValidityOfTheText(String ukrText, String engText) {
        ukrText = ukrText.trim();
        engText = engText.trim();
        ukrText = ukrText.replaceAll("\\s{2,}", "");
        engText = engText.replaceAll("\\s{2,}", "");
        ukrText = ukrText.replaceAll("\\b\\s\\B", "");
        engText = engText.replaceAll("\\b\\s\\B", "");
        if (Pattern.matches("(^\\b[а-яА-Я[іїєІЇЄ]['`][-]]{1,20}\\b\\,?)\\s{1}(\\b[а-яА-Я[іїєІЇЄ]['`][-]]{1,20}\\b[.?!]?$)|" +
                "(^\\b[а-яА-Я[іїєІЇЄ]['`][-]]{1,20}\\b\\,?)\\s{1}(\\b[а-яА-Я [іїєІЇЄ]['`][-]]{1,20}\\b\\,?\\s{1})+(\\b[а-яА-Я [іїєІЇЄ]['`][-]]{1,20}\\b[.?!]?$)", ukrText) &&
                Pattern.matches("(^\\b[a-zA-Z['`]]{1,20}\\b\\,?)\\s{1}(\\b[a-zA-Z ' `]{1,20}\\b[. ! ?]?$)|" +
                        "(^\\b[a-zA-Z['`]]{1,20}\\b\\,?)\\s{1}(\\b[a-zA-Z['`]]{1,20}\\b\\,?\\s{1})+(\\b[a-zA-Z['`]]{1,20}\\b[.!?]?$)", engText)) {

            return AddToBase.writeToFile(new TranslationPair(ukrText, engText));
        }
        return new ResponseStatus(Message.ERRORADDBASE);
    }

    public static int getId() {
        return id;
    }

    public String getUkrText() {
        return ukrText;
    }

    public String getEngText() {
        return engText;
    }

    @Override
    public String toString() {
        return "TranslationPair{" +
                "ukrText='" + ukrText + '\'' +
                ", engText='" + engText + '\'' +
                '}';
    }
}

