package com.epam.streams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Atomzh on 10.06.2019.
 */
public class MorseTranslator {
    private final static String[] english = new String[]{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?", " "};
    private final static String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--..", "/"};
    private final static HashMap<String,String> hashEnglishToMorse = new HashMap<String,String>();
    private final static HashMap<String,String> hashMorseToEnglish = new HashMap<String,String>();

    public static void dictinaryToEnglish(){
        for (int i = 0; i < english.length; i++) {
            hashMorseToEnglish.put(morse[i],english[i]);
        }
    }
    public static void dictinaryToMorse(){
        for (int i = 0; i < english.length; i++) {
            hashEnglishToMorse.put(english[i],morse[i]);
        }
    }

    public void translatorEnglish(String inEnglish) throws IOException{
        File file = new File ("out.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String result = new String();
        for (int i = 0; i < inEnglish.length(); i++) {
            result=hashEnglishToMorse.get(Character.toString(inEnglish.charAt(i)));
            bw.write(result+" ");
        }
        bw.close();
    }
    public void translatorMorse(String inMorse) throws IOException {
        StringTokenizer morse = new StringTokenizer(inMorse);

        File ob = new File("outen.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(ob));
        String mors = "";

        while (morse.hasMoreTokens()) {
            mors=hashMorseToEnglish.get(morse.nextToken());
            System.out.print(mors);
            bw.append(mors);
        }
        System.out.println("\n");
        bw.close();
    }
}
