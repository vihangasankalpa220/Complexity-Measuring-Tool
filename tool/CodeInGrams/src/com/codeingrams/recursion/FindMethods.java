/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.recursion;

import java.util.Stack;

/**
 *
 * @author Jananath Banuka
 */
public class FindMethods {

    public static boolean isParenthesisMatch(String str) {
        if (str.charAt(0) == '{') {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
//                System.out.println("Found: " + c + " - at: " + i);
                for (int j = i - 1; j >= 0; j--) {
                    stringBuilder.append(str.charAt(j));
                }
                System.out.println(stringBuilder);
                String inOrder = new StringBuilder(stringBuilder).reverse().toString();
                String[] splited = inOrder.split("\\s+");
                int length = splited.length;
                System.out.print("Method names are:");
                for (int l = 0; l < length; l++) {
                    System.out.println(l + "). " + splited[l]);
                }

            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
//                    System.out.println("Found: " + c + " - at: " + i);
                } else {
                    return false;
                }
            } else {
//                System.out.println("not found");
            }
        }
        return stack.empty();
    }

    public String[] find(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splited = str.split("\\s+");
        
        for(String word : splited){
            stringBuilder.append(word);
        }
        
        return stringBuilder.toString().split(" ");

    }

}
