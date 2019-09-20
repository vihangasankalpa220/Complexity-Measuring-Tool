/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.analyzer;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author UHEWAAS
 */
public class RunClean {
    public static void getFile(String name) {
        try {
            String s = InputOutput.getText(name);
            CleanFileImpl delCom = new CleanFileImpl(s);
            String newS = delCom.deleteComment();
            System.out.println("Clean code...........");
            InputOutput.setText(newS,name);
        } catch (FileNotFoundException e) {
            System.out.println("File don't exist");
        } catch (Exception e) {
            System.out.println("File don't exist");
        }
    }
}
