import java.util.Stack;

public class BalancedBrackets {
    public boolean areOpposite(char a, char b) {
        switch(a) {
            case '(': return b==')';
            case '{': return b=='}';
            case '[': return b==']';
        }
        return false;
    }

    public String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                char curr = stack.peek();
                if(areOpposite(curr, s.charAt(i))) {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if(stack.isEmpty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

    public void run() {
        System.out.println(isBalanced("[{}]"));
    }
    public static void main(String[] args) {
        new BalancedBrackets().run();
    }
}
