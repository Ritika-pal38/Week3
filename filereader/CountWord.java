package org.example.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWord {

    public static int countWordOccurrences(String filePath, String targetWord) throws IOException {
        int count = 0;

        try (FileReader fileReader = new FileReader("C:\\Users\\ayush\\OneDrive\\Documents\\HelloWorld.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Remove punctuation and convert to lowercase for case-insensitive counting
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", ""); // Improved regex

                String[] words = line.split("\\s+"); // Split by any whitespace

                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) { // Case-insensitive comparison
                        count++;
                    }
                }
            }
        } // try-with-resources automatically closes the files

        return count;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\ayush\\OneDrive\\Documents\\HelloWorld.txt"; // Replace with the actual file path
        String targetWord = "the"; // Replace with the word to count

        try {
            int occurrences = countWordOccurrences(filePath, targetWord);
            System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
