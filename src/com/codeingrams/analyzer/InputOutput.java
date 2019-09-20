/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.analyzer;

/**
 *
 * @author UHEWAAS
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputOutput {

    public static String getText(String wayToFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(wayToFile+".in"));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        return sb.toString();
    }

    public static void setText(String string, String wayToFile) throws IOException {
        File outputFile = new File(wayToFile);
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            StringTokenizer strtok = new StringTokenizer(string, "\n");
            while (strtok.hasMoreTokens()) {
                fileWriter.write(strtok.nextToken() + "\n");
            }
        }
    }
}