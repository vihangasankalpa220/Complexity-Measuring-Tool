package com.codeingrams.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.*;

/**
 *
 * @author Jananath Banuka
 */
public class Complexity {

    private static String readFile(String path) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

            String line;
            // read line by line
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");

            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        String trimmedAdditionalWhiteSpaces = sb.toString().replaceAll("\\s+", " ");

        return trimmedAdditionalWhiteSpaces;

    }

    private ArrayList<String> findMethodNames(String path) {

        //get txext file
        String file = readFile(path);

        //array list to store method names
        ArrayList<String> arr = new ArrayList<String>();

        //get the pattern from constants
        Pattern p = Pattern.compile(Constants.PATTERN);

        // create matcher for pattern p and given string
        Matcher m = p.matcher(file);

        // if an occurrence if a pattern was found in a given string...
        while (m.find()) {

            //rename m.group(0) for easy use to word
            String word = m.group(0).trim();

            //check if the word iterating is a method by checking if it has a starting parenthesis
            if (word.contains("(")) {

                //ignore these methods with following starting words since they are language specific
                if (!(word.trim().startsWith("for")
                        || word.trim().startsWith("while")
                        || word.trim().startsWith("if")
                        || word.trim().startsWith("elseif")
                        || word.trim().startsWith("(")
                        || word.trim().startsWith("main")
                        || word.trim().startsWith("try")
                        || word.trim().startsWith("\"")
                        || word.trim().startsWith("\'")
                        || word.trim().startsWith("+")
                        || word.trim().startsWith("-")
                        || word.trim().startsWith("*")
                        || word.trim().startsWith("open")
                        || word.trim().startsWith("eof")
                        || word.trim().startsWith("outfile")
                        || word.trim().startsWith("infile")
                        || word.trim().startsWith("toString")
                        || word.trim().contains("."))) {
//                    System.out.println("Method is: " + word.trim());
                    arr.add(word.trim());
                }

            }
        }
        return arr;

    }

    
    public boolean checkRecursion(String path) {

        //get the trimmed texts from the file read
        String textFile = readFile(path);

        //check if parenthensis are balanced
        boolean isBalanced = BalancedParanthesis.balancedParenthensies(textFile);

        //get all methods to an ArrayList
        ArrayList<String> allMethods = findMethodNames(path);

        //clear the duplicates from the ArrayList, but will change the order
        Set<String> set = new HashSet<>(allMethods);
        allMethods.clear();
        allMethods.addAll(set);
        
        if (isBalanced) {
            boolean flag = false;

            for (String method : allMethods) {

                //variable to concatanate the every character read
                String str = "";
                String withInCurlyBrackets;

                //get the method length
                int methodLength = method.length();

                //get the index of the first occurence of the method
                int index = textFile.indexOf(method);

                //get the index at the end of the method where curly braces are next
                int getCharAtThis = index + methodLength;

                //check if methods are concrete methods
                if ((textFile.charAt(getCharAtThis) == '{') || textFile.charAt(((index + methodLength) + 1)) == '{') {

                    //get the substring starting from the method's curly braces until the end of the file read
                    String snippet = textFile.substring(getCharAtThis, textFile.length());
                    int snippetLength = snippet.length();

                    for (int i = 0; i < snippetLength; i++) {

                        //write each and every character to the str variable until it is balanced
                        str += snippet.charAt(i);

                        boolean isItBalancedStill = BalancedParanthesis.balancedParenthensies(str.trim());

                        if (isItBalancedStill) { //it is balnced, break is added to stop executing

                            //stop returning isItBalancedStill=true even without passing nothing
                            if (str.length() == 0 || str.equals("") || str.equals(" ")) {

                            } else {

                                //content between curly braces
                                withInCurlyBrackets = str;

                                //split the method name found to check for recursions
                                String names[] = method.split("\\(");
                                String onlyMethodName = names[0].concat("(");
                                
                                //check for recursions here
                                if (withInCurlyBrackets.contains(onlyMethodName)) {
                                    
                                    //starting and ending index of the particular code block 
                                    int startIndex = index;
                                    int endIndex = index + i + methodLength + 1;
                                    flag = true;
                                  
                                    System.out.println("=== A recursive method found, method is: " + method + "===\n");
                                    System.out.println("***|Visual Structure of the recursive method snippet is: \n" + textFile.substring(startIndex, endIndex));
                                    System.out.println();
                                    System.out.println();
                                }
                                break;
//                                
                            }

                        }

                    }
                } else {
//                    System.out.println("no");
                }

            }
            return flag;

        } else {
            System.out.println("Whole code is not balanced!");
            return false;
        }
    }   
}
