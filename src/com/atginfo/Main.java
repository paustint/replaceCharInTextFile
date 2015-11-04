package com.atginfo;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Read File
        String fileName = "input_file.csv";

        String line = null;

        int  currLine = 0;
        int printInterval = 100;



        try {

            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            System.out.println("Creating new file named " + fileName + "_output");
            PrintWriter writer = new PrintWriter("output_" + fileName, "UTF-8");

            System.out.println("Beginning to loop existing file to replace lines.");
            while((line = bufferedReader.readLine()) != null) {
                writer.println(line.replace('|', ','));
                currLine += 1;
                if(currLine % printInterval == 0) {
                    System.out.println("curr line: " + currLine);
                }
            }

            // Always close files.
            System.out.println("Done reading.  Total lines: " + currLine + "\n saving file......");
            bufferedReader.close();
            writer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

    }
}
