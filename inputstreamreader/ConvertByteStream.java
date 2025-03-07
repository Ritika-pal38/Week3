
package org.example.inputstreamreader;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertByteStream {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\ayush\\OneDrive\\Documents\\HelloWorld.txt\\"; // Replace with your file path
        String charset = StandardCharsets.UTF_8.name(); // Or your charset

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported encoding: " + e.getMessage());
        }
    }
}