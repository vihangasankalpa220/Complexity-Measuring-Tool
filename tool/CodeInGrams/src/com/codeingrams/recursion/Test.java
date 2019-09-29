/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.recursion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jananath Banuka
 */
public class Test {

    private static final Pattern p = Pattern.compile("[^\\s(]+\\([^)]*\\)|\\S+");

    public static void main(String[] args) {
        String text = "\n"
                + "compute_hw_participation(infile) infile >> name; \n"
                + "while(!infile.eof())\n"
                + "{\n"
                + "infile >> Id;\n"
                + "cout << name << \" \" << Id << endl;\n"
                + "hwp = compute_hw_participation(infile);\n"
                + "tests = compute_tests(tests, infile);\n"
                + "totalscore = compute_totalscore(totalscore, infile);\n"
                + "// grade\n"
                + "printRecord(name, Id, hwp, tests, totalscore, outfile);\n"
                + "infile >> name; \n"
                + "}\n"
                + "\n"
                + "return $ 0;\n"
                + "}\n"
                + "";

        // create matcher for pattern p and given string
        Matcher m = p.matcher(text);
        // if an occurrence if a pattern was found in a given string...
        while (m.find()) {

            if (m.group(0).contains("(")) {

                if (!(m.group(0).trim().startsWith("for")
                        || m.group(0).trim().startsWith("while")
                        || m.group(0).trim().startsWith("if")
                        || m.group(0).trim().startsWith("elseif")
                        || m.group(0).trim().startsWith("(")
                        || m.group(0).trim().startsWith("main")
                        || m.group(0).trim().startsWith("try")
                        || m.group(0).trim().startsWith("\"")
                        || m.group(0).trim().startsWith("\'")
                        || m.group(0).trim().startsWith("+")
                        || m.group(0).trim().startsWith("-")
                        || m.group(0).trim().startsWith("*")
                        || m.group(0).trim().startsWith("open")
                        || m.group(0).trim().startsWith("eof")
                        || m.group(0).trim().startsWith("outfile")
                        || m.group(0).trim().startsWith("infile"))) {
//                    System.out.println("Method is: " + m.group(0).trim());
                }

            }
        }

        int i = text.lastIndexOf("$");
        String method = "sum(int n, double ok, Student student)";
        String words[] = method.split(" ");
        for (String word : words) {
//            System.out.println(word);
        }

        String str = "abc ok,cde pl,def o,fgh kj";        
        String remainder = str.substring(str.indexOf(",") + 1, str.length());
//        System.out.println(kept);

        String[] dataTypes = {"byte", "short", "int", "long", "float", "double", "char", "boolean", "String"};

    }
}
