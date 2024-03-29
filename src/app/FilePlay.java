package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

/**
 * This class demonstrates file copying functionality.
 */
public class FilePlay {
    
    /**
     * The main method that calls the copyFile() method and handles error codes.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Call copyFile() with input and output filenames
        int errorCode = copyFile("InUsers2.txt", "OutFile2.txt");
        
        // Display appropriate message based on the error code
        switch (errorCode) {
            case 0:
                System.out.println("File copied successfully.");
                break;
            case -1:
                System.out.println("File Not Found.");
                break;
            case -2:
                System.out.println("I/O Error.");
                break;
        }
    }

    /**
     * Copies the contents of one file to another.
     * @param inputFilename The input file to read from.
     * @param outputFilename The output file to write to.
     * @return 0 if successful, -1 if File Not Found, -2 if I/O Error.
     */
    private static int copyFile(String inputFilename, String outputFilename) {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            // Create FileReader and FileWriter instances
            in = new BufferedReader(new FileReader(inputFilename));
            out = new BufferedWriter(new FileWriter(outputFilename));

            int c;
            // Copy file character by character
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            return 0; // Success
        } catch (FileNotFoundException e) {
            return -1; // File Not Found
        } catch (IOException e) {
            return -2; // I/O Error
        } finally {
            // Close FileReader and FileWriter in the finally block
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                // Handle closing file error if needed
            }
        }
    }
}
