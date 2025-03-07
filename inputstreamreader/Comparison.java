package org.example.inputstreamreader;


    public class Comparison {

        public static void main(String[] args) {
            String str = "hello";
            int iterations = 1000000;

            // StringBuilder
            long startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iterations; i++) {
                sb.append(str);
            }
            long endTime = System.nanoTime();
            System.out.println("StringBuilder time: " + (endTime - startTime) / 1000000 + " ms");

            // StringBuffer
            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < iterations; i++) {
                sbf.append(str);
            }
            endTime = System.nanoTime();
            System.out.println("StringBuffer time: " + (endTime - startTime) / 1000000 + " ms");
        }
    }

