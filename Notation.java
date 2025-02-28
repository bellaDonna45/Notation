package notationpackage;

public class Notation {
    public static String infixToPostfix(String infix) throws InvalidNotationFormatException {
        MyStack<Character> stack = new MyStack<Character>();
        MyQueue<Character> queue = new MyQueue<Character>();
        
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                queue.enqueue(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
                    queue.enqueue(stack.pop());
                }
                if (stack.isEmpty()) {
                    throw new InvalidNotationFormatException();
                }
                stack.pop();
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.top()) >= precedence(c)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        
        return queue.toString();
    }
    
    public static String postfixToInfix(String postfix) throws InvalidNotationFormatException {
        MyStack<String> stack = new MyStack<String>();
        
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.toString(c));
            } else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
                String b = stack.pop();
                String a = stack.pop();
                stack.push("(" + a + c + b + ")");
            }
        }
        
        if (stack.size() != 1) {
            throw new InvalidNotationFormatException();
        }
        
        return stack.pop();
    }
    
    public static double evaluatePostfix(String postfix) throws InvalidNotationFormatException {
        MyStack<Double> stack = new MyStack<Double>();
        
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperation(a, b, c));
            }
        }
        
        if (stack.size() != 1) {
            throw new InvalidNotationFormatException();
        }
        
        return stack.pop();
    }
    
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }
    
    private static double applyOperation(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
































































































//:)
