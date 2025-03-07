package org.example.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderLineByLine {
    public static void main(String[] args) {
        String filePath = "C:\\Capgemini\\Week_2\\Day1\\Level1\\Junit.txt\\";
        try (FileReader F = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(F)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file : " + e.getMessage());
        }
    }

    }