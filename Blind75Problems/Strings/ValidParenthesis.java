import java.util.Stack;

public class ValidParenthesis {

    public boolean areOpposite(char a, char b) {
        switch(a) {
            case '(': return b == ')';
            case '[': return b == ']';
            case '{': return b == '}';
            default:
        }
        return false;
    }

    public boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            }
            else {
                char top = stack.peek();
                if(areOpposite(top, c)) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public void run() {
        // String s = "()[]{}";
        String s = "([]){}";
        System.out.println(isValidParenthesis(s));
    }
    public static void main(String[] args) {
        new ValidParenthesis().run();
    }
}