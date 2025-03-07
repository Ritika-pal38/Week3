package org.example. inputstreamreader;


    import java.io.*;

    public class ReadUserInput {

        public static void main(String[] args) throws IOException {
            String filePath = "C:\\Users\\ayush\\OneDrive\\Documents\\HelloWorld.txt\\";

            try (InputStreamReader isr = new InputStreamReader(System.in);
                 BufferedReader br = new BufferedReader(isr);
                 FileWriter fw = new FileWriter(filePath);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                String input;
                System.out.println("Enter text (type 'exit' to finish):");
                while (!(input = br.readLine()).equals("exit")) {
                    bw.write(input);
                    bw.newLine();
                }
            }
        }
    }

