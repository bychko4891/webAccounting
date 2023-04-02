package com.whyit.learnEnglish.addtobase;

import com.whyit.learnEnglish.responsestatus.ResponseStatus;
import com.whyit.learnEnglish.responsestatus.Message;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddToBase {
    private static List<TranslationPair> translationPairList = new ArrayList<>();

    public static ResponseStatus writeToFile(TranslationPair translationPair){
        translationPairList.add(translationPair);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("translation_pair.bin"))){
            oos.writeObject(translationPairList);
            return new ResponseStatus(Message.SUCCESSADDBASE);
        } catch (FileNotFoundException e) {
            System.out.println("File translation_pair.bin not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseStatus(Message.ERRORADDBASE);
    }
}
