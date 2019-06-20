package com.epam.streams;
import java.io. *;
public class Main {
       public static void main(String[] args) {
           MorseTranslator translator = new MorseTranslator();
           MorseTranslator.dictinaryToEnglish();
           MorseTranslator.dictinaryToMorse();

           File morseFile = new File("out.txt");
           File englishFile = new File("in.txt");
           String english = "";
           String morse = "";

           try  {
               String result = "";
               BufferedReader bfEnglish = new BufferedReader(new FileReader(englishFile));
               while ((english=bfEnglish.readLine())!=null)
               {
                   result+=english+" ";
               }
               translator.translatorEnglish(result.toLowerCase());
               bfEnglish.close();

               BufferedReader bfMorse = new BufferedReader(new FileReader(morseFile));
               while ((morse=bfMorse.readLine())!=null)
               {
                   translator.translatorMorse(morse);
               }
               bfMorse.close();
           }
           catch(IOException e){
               System.err.println("Ошибка файла"+e);}
       }

}
