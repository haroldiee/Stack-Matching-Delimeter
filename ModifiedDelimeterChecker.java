/* Description: This program checks if a sequence of delimiters ( ), [ ], and { } is properly matched and nested. It uses a stack to push opening delimiters and to peek and pop when a closing delimiter is read.
It displays Valid or Invalid with a reason, and it prints a step-by-step stack trace while running.
Programmed by: <your name> <your course> <your cn> <your subject>
Last Modified: October 23, 2026
Version: 1.0
Acknowledgements: Generative AI (Claude by Anthropic) was used to help understand the stack concept and to write the Java program.
Prompt used: "could you explain this and use basic english" and "can you answer the drafting of code" (with the Stack - Matching Delimiters laboratory exercise uploaded).
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

    static String showStack(Stack<Character> stack) {
        if (stack.isEmpty()) return "empty";
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sequence: ");
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        System.out.println("Input: " + input);
        System.out.println();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isOpening(c)) {
                System.out.println("Read: " + c);
                stack.push(c);
                System.out.println("Operation: PUSH");
                System.out.println("Stack: " + showStack(stack));
                System.out.println();

            } else if (isClosing(c)) {
                System.out.println("Read: " + c);

                if (stack.isEmpty()) {
                    System.out.println("Stack: empty");
                    System.out.println("Result: INVALID");
                    System.out.println("Reason: Closing delimiter " + c
                            + " has no matching opening delimiter.");
                    return;
                }

                char top = stack.peek();
                System.out.println("Operation: PEEK -> " + top);

                if (matches(top, c)) {
                    stack.pop();
                    System.out.println("Operation: POP");
                    System.out.println("Stack: " + showStack(stack));
                    System.out.println();
                } else {
                    System.out.println("Result: INVALID");
                    System.out.println("Reason: Mismatched delimiters. " + c
                            + " does not match " + top + ".");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Result: VALID");
        } else {
            System.out.println("Result: INVALID");
            System.out.println("Reason: Unmatched opening delimiter remains: "
                    + showStack(stack));
        }
    }
}
