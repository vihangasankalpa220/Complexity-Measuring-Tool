/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.recursion;

/**
 *
 * @author Jananath Banuka
 */
public abstract class ComplexityByRecursion {

    abstract String readFileString(String path);

    abstract String[] findMethods();

    abstract int findComplexity();

    public final void execute(String path) {

        findMethods();
        findComplexity();
    }

}
