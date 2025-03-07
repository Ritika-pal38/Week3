package org.example.linearsearch;
import java.util.*;

public class WordSearch {
    public static void main(String[] args) {

        String[] sentence = new String[4];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = input.nextLine();
        }
        String word = findWord(sentence);
        System.out.println(word);
    }

    public static String findWord(String[] search) {

        for (int i = 0; i < search.length; i++) {
            if (search[i].contains("is")) {
                return search[i];
            }
            else{
                return "not found";
            }
        }

        return "end of function";
    }
}
