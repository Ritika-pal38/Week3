package org.example.stringbuilder;
import java.util.LinkedHashSet; // Use LinkedHashSet

public class RemoveDuplicate {

    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Character> seen = new LinkedHashSet<>(); // Use LinkedHashSet

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (seen.add(c)) { // LinkedHashSet's add() returns true if the element is new
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String inputString = "programming";
        String result = removeDuplicates(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("String without duplicates: " + result);  // Output: progamin

        inputString = "aabbccddeeff";
        result = removeDuplicates(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("String without duplicates: " + result); // Output: abcdef

        inputString = "arammika";
        result = removeDuplicates(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("String without duplicates: " + result); // Output: aramika

        inputString = "";
        result = removeDuplicates(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("String without duplicates: " + result);

        inputString = null;
        result = removeDuplicates(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("String without duplicates: " + result);
    }
}