package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// ПСП - правильная скобочная последовательность
// () [] {}
public class Brackets {

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sequence = reader.readLine();
        boolean wrong = false;

        for (char bracket: sequence.toCharArray()) {
            if (bracket == '{' || bracket == '(' || bracket == '[') {
                stack.add(bracket);
            } else if (!stack.isEmpty()){
                if (bracket == ')' && stack.peek() != '(') {
                    wrong = true;
                    break;
                }
                if (bracket == ']' && stack.peek() != '[') {
                    wrong = true;
                    break;
                }
                if (bracket == '}' && stack.peek() != '{') {
                    wrong = true;
                    break;
                }
                stack.pop();
            } else {
                wrong = true;
                break;
            }
        }
        System.out.println(wrong || !stack.isEmpty()? "INCORRECT" : "CORRECT");
    }
}
