/* Description: This program checks if a sequence of delimiters ( ), [ ], and { } is properly matched and nested. It uses a stack to push every opening delimiter. When a closing delimiter is read, it checks if the stack is empty, peeks at the top, and pops it if it matches. 
It then displays Valid or Invalid, with a short reason if the sequence is invalid.
Programmed by: <Harold Niño R. Jangad> <BSIT> <48079> <Data Structure and Algorithm>
Last Modified: October 23, 2026
Version: 1.0
Acknowledgements: Generative AI (Claude by Anthropic) was used to help understand the stack concept and to write the Java program.
Prompt used: "could you explain this and use basic english" and "can you answer the task that are needed" (with the Stack - Matching Delimiters laboratory exercise uploaded).
*/

import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {

    static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sequence: ");
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isOpening(c)) {
                stack.push(c);

            } else if (isClosing(c)) {
                if (stack.isEmpty()) {
                    System.out.println("Invalid");
                    System.out.println("Reason: Closing delimiter " + c
                            + " has no matching opening delimiter.");
                    return;
                }

                char top = stack.peek();

                if (matches(top, c)) {
                    stack.pop();
                } else {
                    System.out.println("Invalid");
                    System.out.println("Reason: Mismatched delimiters. " + c
                            + " does not match " + top + ".");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
            System.out.println("Reason: Unmatched opening delimiter remains.");
        }
    }
}
