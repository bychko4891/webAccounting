package com.whyit.learnEnglish;


import java.util.regex.Pattern;

public class CheckBeforeAdding extends English {

    public CheckBeforeAdding(String ukrText, String engText) {
        super(ukrText, engText);
    }

    public String checkingTextForLength() {
        if (this.getUkrText().length() <= 3 || this.getUkrText().length() > 450 || this.getEngText().length() <= 3 || this.getEngText().length() > 450)
            return "Текст занадто довгий, дозволено речення до 450 символів разом з пропусками!!!";
        String response = this.checkingTheValidityOfTheText();
        return response;
    }

    private String checkingTheValidityOfTheText() {
        String ukrText = this.getUkrText().trim();
        String engText = this.getEngText().trim();
        ukrText = ukrText.replaceAll("\\s{2,}", "");
        engText = engText.replaceAll("\\s{2,}", "");
        ukrText = ukrText.replaceAll("\\b\\s\\B", "");
        engText = engText.replaceAll("\\b\\s\\B", "");
        if (Pattern.matches("(^\\b[а-яА-Я[іїєІЇЄ]['`][-]]{1,20}\\b\\,?)\\s{1}(\\b[а-яА-Я[іїєІЇЄ]['`][-]]{1,20}\\b[.?!]?$)|" +
                "(^\\b[а-яА-Я[іїєІЇЄ]['`][-]]{1,20}\\b\\,?)\\s{1}(\\b[а-яА-Я [іїєІЇЄ]['`][-]]{1,20}\\b\\,?\\s{1})+(\\b[а-яА-Я [іїєІЇЄ]['`][-]]{1,20}\\b[.?!]?$)", ukrText) &&
                Pattern.matches("(^\\b[a-zA-Z['`]]{1,20}\\b\\,?)\\s{1}(\\b[a-zA-Z ' `]{1,20}\\b[. ! ?]?$)|" +
                        "(^\\b[a-zA-Z['`]]{1,20}\\b\\,?)\\s{1}(\\b[a-zA-Z['`]]{1,20}\\b\\,?\\s{1})+(\\b[a-zA-Z['`]]{1,20}\\b[.!?]?$)", engText)) {
            return "Текст добавленний успішно";
        }
        return "Можливо одне із слів в реченні дуже довге та перевищує 20 символів, або десь перед наступним словом забули пропуск після коми";
    }
}
