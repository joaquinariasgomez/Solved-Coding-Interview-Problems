import java.util.Stack;

public class ValidParenthesis {

    public boolean areOpposite(char a, char b) {
        switch(a) {
            case '{': return b=='}';
            case '(': return b==')';
            case '[': return b==']';
        }
        return false;
    }

    public boolean valid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(char c:array) {
            if(stack.isEmpty()) {
                stack.push(c);
            }
            else {
                char topChar = stack.peek();
                if(areOpposite(topChar, c)) {
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
        String s = "{[]}[]";
        System.out.println(valid(s));
    }
    public static void main(String[] args) {
        new ValidParenthesis().run();
    }
}
