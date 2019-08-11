package com.codeingrams.recursion;

import java.util.Stack;

public class BalancedParanthesis {

    public boolean isBalanced(String expression) {
        char[] c = expression.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
                stack.push(c[i]);
            }
            if (c[i] == '}' || c[i] == ']' || c[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.isEmpty()) {
                    if (!matchElements(stack.pop(), c[i]))
                    return false;
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        else
            return true;
    }

    private boolean matchElements(Character pop, char c) {
        if (pop == '{' && c == '}')
            return true;
        else if (pop == '[' && c == ']')
            return true;
        else if (pop == '(' && c == ')')
            return true;
        return false;
    }
    

	public static boolean balancedParenthensies(String textFile) {
		BalancedParanthesis balancedParanthesis=new BalancedParanthesis();
		return balancedParanthesis.isBalanced("{[harsh]}");
	}
    
}
