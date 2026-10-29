# Stack - Matching Delimiters

A Java program that checks if a sequence of delimiters `( )`, `[ ]`, and `{ }` is correctly matched and nested. It uses a **stack** to keep track of the opening delimiters that are still open.

## How It Works

The stack follows the **LIFO** rule (Last-In, First-Out). The program reads the input from left to right:

1. **Opening delimiter** `(`, `[`, or `{`: push it onto the stack.
2. **Closing delimiter** `)`, `]`, or `}`:
   - If the stack is empty, the sequence is **invalid** (nothing to match with).
   - Otherwise, **peek** at the top of the stack.
   - If the top matches the closing delimiter, **pop** it.
   - If it does not match, the sequence is **invalid**.
3. After reading everything, if the stack is **empty**, the sequence is **valid**. If it is not empty, some opening delimiters were never closed, so it is **invalid**.

## Features

- Supports three types of delimiters: `()`, `[]`, `{}`
- Checks the **order and nesting**, not just the count
- Shows a clear reason when the sequence is invalid
- Includes a version that prints a **step-by-step stack trace**

## Requirements

- Java Development Kit (JDK) 8 or higher

## How to Run

1. Clone this repository:
   ```bash
   git clone <your-repository-url>
   cd <your-repository-folder>
   ```
2. Compile the program:
   ```bash
   javac DelimiterChecker.java
   ```
3. Run it:
   ```bash
   java DelimiterChecker
   ```
4. Type a sequence of delimiters when asked, for example `{[()]}`.

## Example Runs

**Valid sequence**
```
Enter a sequence: {[()]}
Valid
```

**Mismatched delimiters**
```
Enter a sequence: {[(])}
Invalid
Reason: Mismatched delimiters. ] does not match (.
```

**Unmatched opening delimiter**
```
Enter a sequence: (()
Invalid
Reason: Unmatched opening delimiter remains.
```

**Closing delimiter with no opening delimiter**
```
Enter a sequence: ())
Invalid
Reason: Closing delimiter ) has no matching opening delimiter.
```

## Stack Trace Version

The trace version prints each step while the program runs: the character read, the stack operation (PUSH, PEEK, or POP), and the contents of the stack.

```
Input: {[()]}

Read: {
Operation: PUSH
Stack: {

Read: [
Operation: PUSH
Stack: { [

Read: (
Operation: PUSH
Stack: { [ (

Read: )
Operation: PEEK -> (
Operation: POP
Stack: { [

Read: ]
Operation: PEEK -> [
Operation: POP
Stack: {

Read: }
Operation: PEEK -> {
Operation: POP
Stack: empty

Result: VALID
```

## Test Cases

| Input | Expected Result | Reason |
| --- | --- | --- |
| `{[()]}` | Valid | Properly nested |
| `([{}])` | Valid | Properly nested |
| `()[]{}` | Valid | Pairs side by side |
| `{[(])}` | Invalid | `]` does not match `(` |
| `(()` | Invalid | Opening delimiter `(` never closed |
| `())` | Invalid | Extra `)` has no opening delimiter |
| `{[}` | Invalid | `}` does not match `[` |

## Project Structure

```
.
├── DelimiterChecker.java   # Main program
└── README.md
```

## Author

- **Name:** <Harold Niño R. Jangad>
- **Course:** <BSIT>
- **Subject:** <Data Structure and Algorithm>

## AI Disclosure

Parts of this project were drafted with the help of Claude Sonnet 5.5 (Anthropic). See the AI Disclosure Statement submitted with this activity for details.
