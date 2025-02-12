package org.example.stringbuilder;


import java.util.Scanner;

public class ConcatenateStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] fruits = new String[n];
        for(int i = 0;i< fruits.length;i++){
            fruits[i] = sc.next();
        }

        System.out.println(ConcatenateStrings.Concatenate(fruits));
    }

    public  static String Concatenate(String[] str ){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<str.length;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

}
