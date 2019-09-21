/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.recursion;

import com.codeingrams.conf.ConfImpl;
import com.codeingrams.conf.IConf;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Jananath Banuka
 */
public class CProgramComplexity extends ComplexityByRecursion {

    String filteredCode;

    //Load configurations
    IConf conf = new ConfImpl("./config.properties");
    
    //load input file
    String inputFilePath  = conf.loadConfig("INPUTFILE");

    @Override
    String readFileString(String path) {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        
        String n = sb.toString().trim().replaceAll("\\s{10,}", " ");
//        String n = System.out.format("[%s]%n",
//            sb.toString().replaceAll("^ +| +$|( )+", "$1")
//        ).toString();
        
        filteredCode = n;
        return filteredCode;
    }

    @Override
    String[] findMethods() {
        String code = readFileString(inputFilePath);    
        
        FindMethods findMethods = new FindMethods();
        String[] words = findMethods.find(code);
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        int count = 0;
        for(String aWord : words){
            count++;
            System.out.println(count + ": " + aWord);
        }
        
        return new String[]{"a", "b", "c", "d"}; //added [];
    }

    @Override
    int findComplexity() {
        return 0;
    }

}
