/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jananath Banuka
 */
public class Complexity {

    int getCount, getCount2 = 0;
    int countOne = 0;
    int countTwo = 0;
    boolean found = false;

    private static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        int lineNumber = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

            String line;
            // read line by line
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
                lineNumber++;
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        //trimming all additional wite spaces. White spaces greater than 2
        String trimmedAdditionalWhiteSpaces = sb.toString().replaceAll("\\s+", " ");
//        System.out.println("Trimmed: " + trimmedAdditionalWhiteSpaces);

        return trimmedAdditionalWhiteSpaces;

    }

    private ArrayList<String> findMethodNames(String path) {

        //get text file
        String file2 = readFile(path);
        String file = file2.replaceAll("\\s(?=[(,])", "");
//        System.out.println(file);

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
                        || word.trim().startsWith("toString")
                        || word.trim().contains("."))) {
//                    System.out.println("Method is: " + word.trim());
                    arr.add(word.trim());
                }

            }
        }
        return arr;

    }

    public boolean checkRecursion(String path) throws ParseException {

        boolean flag = false;

        //get the trimmed texts from the file read
        String textFile2 = readFile(path);
        String textFile = textFile2.replaceAll("\\s(?=[(,])", "");
//        System.out.println("Hi machan: " + textFile);        

        //check if parenthensis are balanced
        boolean isBalanced = BalancedParanthesis.balancedParenthensies(textFile);

        //get all methods to an ArrayList
        ArrayList<String> allMethods = findMethodNames(path);

        //clear the duplicates from the ArrayList, but will change the order
        Set<String> set = new HashSet<>(allMethods);
        allMethods.clear();
        allMethods.addAll(set);

        if (isBalanced) {
//            System.out.println("777");

            for (String method : allMethods) {
//                System.out.println("999");
                //variable to concatanate the every character read
                String str = "";
                String withInCurlyBrackets;

                //get the method length
                int methodLength = method.length();

                //get the index of the first occurence of the method
                int index = textFile.indexOf(method);

                //get the index at the end of the method where curly braces are next
                int getCharAtThis = index + methodLength;
//                System.out.println("Text File: " + textFile);
                //check if methods are concrete methods
                if ((textFile.charAt(getCharAtThis) == '{') || textFile.charAt(((index + methodLength) + 1)) == '{') {
//                    System.out.println("222");
                    //get the substring starting from the method's curly braces until the end of the file read
                    String snippet = textFile.substring(getCharAtThis, textFile.length());
                    int snippetLength = snippet.length();

                    for (int i = 0; i < snippetLength; i++) {

                        //write each and every character to the str variable until it is balanced
                        str += snippet.charAt(i);

                        boolean isItBalancedStill = BalancedParanthesis.balancedParenthensies(str.trim());

                        if (isItBalancedStill) { //it is balnced, break is added to stop executing
//                            System.out.println("333");
                            //stop returning isItBalancedStill=true even without passing nothing
                            if (str.length() == 0 || str.equals("") || str.equals(" ")) {
//                                System.out.println("444");
                            } else {
//                                System.out.println("555");
                                //content between curly braces
                                withInCurlyBrackets = str;

                                //split the method name found to check for recursions
                                String names[] = method.split("\\(");
                                String onlyMethodName = names[0].concat("(");

                                //check for recursions here
                                if (withInCurlyBrackets.replaceAll("\\s(?=[(,])", "").contains(onlyMethodName)) {

//                                    System.out.println("111");
                                    //starting and ending index of the particular code block 
                                    int startIndex = index;
                                    int endIndex = index + i + methodLength + 1;
//                                    flag = true;

//                                    System.out.println("=== A recursive method found, method signature is: " + method + "===\n");
                                    //START ============
                                    String dataTypes[] = {"byte", "short", "int", "long", "float", "double", "boolean", "char", "String"};
                                    String dataArr[];
                                    String copyDataArr[] = new String[0];
//                                    System.out.println("Method is: " + method);
                                    Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(method);
                                    int count = 0;

                                    //Store found data types in an ArrayList
                                    ArrayList<String> list = new ArrayList<>();

                                    while (m.find()) {
//                                        System.out.println("\nDATA TYPE IS: " + m.group(1) + "\n");

                                        dataArr = m.group(1).split(",");

                                        String regex = "^\\s+";
                                        String dataTypeName;
                                        copyDataArr = new String[dataArr.length];
                                        //array to store the Data type (name)
                                        String foundDataTypes[] = new String[dataArr.length];

                                        for (String keyword : dataArr) {

                                            for (int j = 0; j < dataTypes.length; j++) {

                                                //get the string "double d" and split the white space and get the
                                                //first elemet of the array
                                                dataTypeName = keyword.replaceAll(regex, "").split(" ")[0];

                                                if (keyword.contains(dataTypes[j])) {
//                                                    System.out.println("Found: " + dataTypeName);
                                                    list.add(dataTypeName);
                                                    //store the data types
                                                    foundDataTypes[count] = dataTypeName;
                                                    count++;
                                                }
                                            }
                                        }
//                                        System.out.println("Count is: " + count);

                                        //coppy array
                                        System.arraycopy(foundDataTypes, 0, copyDataArr, 0, foundDataTypes.length);
//                                        System.out.println("No of data types: " + count);

                                    }

                                    //get the method name
                                    String methodNameOnly = method.split("\\(")[0];
//                                    System.out.println("Name: " + methodNameOnly);
                                    //END ============
                                    //method structure
                                    String methodStructure = textFile.substring(startIndex, endIndex);

                                    /*String findStr = methodNameOnly;
                                     int lastIndex = 0;
                                     int count2 = 0;
                                     while (lastIndex != -1) {

                                     lastIndex = methodStructure.indexOf(findStr, lastIndex);

                                     if (lastIndex != -1) {
                                     count2++;
                                     lastIndex += findStr.length();
                                     }
                                     }
                                     */
                                    //occurence of the recursive method within the code block
//                                    System.out.println(count2-1);
                                    //get all the methods with the same method name to check if they satisfy the
                                    //same name different parameter lists concept (method overloading)
                                    //so we can check is it the same method's been recursing within.
                                    boolean ok = checkMethodOverloding(path, methodNameOnly, method, methodStructure, copyDataArr, count, list);

                                    if (ok) {

                                        System.out.println("\n***|Visual Structure of the recursive method snippet is: \n" + methodStructure);
                                        System.out.println();
                                        System.out.println();
                                        flag = true;
                                    }
//                                    System.out.println("***|Visual Structure of the recursive method snippet is: \n" + methodStructure);
//                                    System.out.println();
//                                    System.out.println();
//                                    flag = true;

                                } else {
//                                    System.out.println("666");
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
//            System.out.println("101010");
            return flag;

        } else {
            System.out.println("Whole code is not balanced!");
            return false;
        }
    }

    private boolean checkMethodOverloding(String path, String methodNameOnly, String method, String methodStructure, String foundDataTypes[], int parameterCount, ArrayList<String> list) throws ParseException {

        boolean flag = false;
        boolean flag2 = false;

        //get the pattern from constants
        Pattern p = Pattern.compile(Constants.PATTERN);

        // create matcher for pattern p and given string
        Matcher m = p.matcher(methodStructure);

        //length of the parameter list (how many parameters)
        int foundDataTypesLength = foundDataTypes.length;

        //an array to store the data type names        
        String dataTypesInMethod[] = new String[foundDataTypesLength];

        // if an occurrence if a pattern was found in a given string...
        while (m.find()) {

            getCount = 0;
            getCount2 = 0;
            countOne = 0;
            countTwo = 0;

            //rename m.group(0) for easy use to word
            String word = m.group(0).trim();

//            System.out.println("Word is: " + word);
//            System.out.println("method name only is: " + method);
            //this && !(word.equals(method)) will ignore the method name being printed/getting since we dont need its
            //parenthesis to check overloading, so only recursive methods are printed
            if (word.contains("(") && (word.contains(methodNameOnly))) { //&& !word.equals(method)
//                System.out.println(word.replaceAll("[^\\w\\s]",""));

                if (!(word.trim().startsWith("for")
                        || word.trim().startsWith("while")
                        || word.trim().startsWith("if")
                        || word.trim().startsWith("elseif")
                        || word.trim().startsWith("(")
                        || word.trim().startsWith("main")
                        || word.trim().startsWith("try")
                        || word.trim().startsWith("open")
                        || word.trim().startsWith("eof")
                        || word.trim().startsWith("outfile")
                        || word.trim().startsWith("toString")
                        || word.trim().startsWith("."))) {

                    //additional chracters will be removed before the function name like -> return powerOf10 n-1)*+-/powerOf10("hey");
                    String trimmedWord = word.replaceAll("[/*+-]", "");

                    Matcher mm = Pattern.compile("\\(([^)]+)\\)").matcher(trimmedWord);
                    int cc = 0, ccount = 0, count2 = 0;

                    while (mm.find()) {

                        //get the parameter
                        String param = mm.group(1);

                        //System.out.println("\nDATA TYPE IS: " + param + "\n");
                        if (param.contains(",")) { //if a method contains more than 2 params
                            System.out.println("1");
                            String trimmed = param.replaceAll("\\s+", "");
                            String split[] = trimmed.split(",");
                            int numberOfSplit = split.length;

                            if (parameterCount == numberOfSplit) {
//                                System.out.println("found");
                            } else {

                            }

                            for (String wor : split) {

                                //check both original and recursive methods' parameters counts are equal
                                //then we can neglect all other methods with lesser #.of paramters arguments
                                if (split.length == parameterCount) {
                                    cc++;
                                    ccount++;
                                    if (cc == 1) {
//                                        System.out.println("- " + trimmedWord);
                                        cc = 10;
                                    }

                                    if (ccount <= numberOfSplit) {
//                                        System.out.println("CCount : " + ccount);

                                        flag = isRecursive(path, wor, list, method, trimmedWord);

                                    }

                                }

                            }

                            //check what kind of parameters are within the recursive method/s
                        } else {

                            //check what kind of parameters are within the recursive method/s
                            //and by if condition, let's check if the parameter counts are equal
                            if (parameterCount == 1) {
//                                System.out.println("- " + trimmedWord);
                                flag2 = isRecursive(path, param, list, method, trimmedWord);

                            }

                        }
                    }
                }
            }
        }

        if (flag || flag2) {
            return true;
        } else {
            return false;
        }
    }

    //this will check what kind of parameters are within the recursive method/s
    private boolean isRecursive(String path, String param, ArrayList<String> list, String method, String trimmedWord) {

        boolean flag = false;

        //regex to check if the param is a number o(of any kind) or a character-type data type
        String regex = "(.)*(\\d)(.)*";

        Pattern pattern = Pattern.compile(regex);
        String dataType = param;

        boolean containsNumber = pattern.matcher(dataType).matches();

        //creating an ArrayList to store the data type of the param
        ArrayList<String> al = new ArrayList<>();

        if (containsNumber) { //integer long float double

            if (dataType.contains(".") || dataType.contains("f") || dataType.contains("F") || dataType.contains("d") || dataType.contains("D")) { //a double or a float

                if (dataType.contains("f") || dataType.contains("F")) { //a float
//                    System.out.println("float");
                    al.add("float");
                } else if (dataType.contains("D") || dataType.contains("d")) { //a double
//                    System.out.println("double");
                    al.add("double");
                } else { //also a double
//                    System.out.println("double");
                    al.add("double");
                }
            } else { //an int or a long
//                System.out.println("TYPE: " + dataType);
                try {
                    if ((Integer.parseInt(dataType) >= -2147483648) && (Integer.parseInt(dataType) <= 2147483647)) {
//                        System.out.println("int");
                        al.add("int");
                    } else if ((dataType.contains("l") || dataType.contains("L")) || (Long.parseLong(dataType) >= -9223372036854775808f && (Long.parseLong(dataType) <= 9223372036854775807f))) {
                        al.add("long");
                    } else {
                        System.out.println("error");
                    }

                } catch (Exception e) {
//                    System.out.println("unknown error at: " + 445);
                    e.printStackTrace();
                }

            }

        } else { //can be char or String or a boolean or an object type
            if (dataType.contains("\'")) { //char
//                System.out.println("char");
                al.add("char");
            } else if (dataType.contains("\"")) { //String
//                System.out.println("String");
                al.add("String");
            } else if (dataType.equals("true") || dataType.equals("false")) { //boolean
//                System.out.println("boolean");
                al.add("boolean");
            } else { //an object type
//                System.out.println("object type");
                al.add("Object");
            }
        }

        String arrayOne[] = new String[list.size()];
        arrayOne = list.toArray(arrayOne);

        String arrayTwo[] = new String[al.size()];
        arrayTwo = al.toArray(arrayTwo);

        //printing arg types in original method
        list.stream().forEach((arg) -> {
//                System.out.println("Arg1: " + arg);
        });
        getCount++;

        for (String one : arrayOne) {
//            System.out.println("ORIGINAL: " + one);
        }
//        }

        for (String one : arrayTwo) {
//            System.out.println("FAKE: " + one);
        }

        int c = getCount2;

        try {
            if (arrayOne[c].equals(arrayTwo[0])) {
                countOne++;
                getLineNumbers(path, method);
//            System.out.println("Found");
            } else {
                countTwo++;
//            System.out.println("Not found!");
            }

        } catch (Exception e) {
//            System.out.println("Error at line: " + 502);
            e.printStackTrace();
        }

        getCount2++;
        if (countOne == list.size()) {
//            System.out.println("*********************************************************************");
            System.out.println(trimmedWord + " - satisfies the criteria");
            flag = true;
            found = flag;
        } else {

//            System.out.println("aiyooo..........................");
//            return false;
        }

        if (found) {
            return true;
        } else {
            return false;
        }
    }

    private void getLineNumbers(String path, String method) {
//        System.out.println(methodStrcuture);
        StringBuilder sb = new StringBuilder();
        int lineNumber = 0;
        System.out.println("meeeee: " + method) ;
        
        int start = 0;
        int end = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

            String line;
            // read line by line
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
                lineNumber++;
                String l = line.replaceAll("\\s+", " ");
                
                if(l.contains(method)){
                    start = lineNumber;
                }else{
                    
                    System.out.println(lineNumber + " no found");
                }

            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }

}
