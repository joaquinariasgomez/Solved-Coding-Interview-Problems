import java.util.Stack;

public class Brackets {

    private boolean areOpposite(Character a, Character b) {
        switch(a) {
            case '(': return b == ')';
            case '{': return b == '}';
            case '[': return b == ']';
        }
        return false;
    }

    private boolean properlyNested(String brackets) {
        if(brackets.isEmpty()) return true;

        char[] elements = brackets.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<elements.length; ++i) {
            if(stack.empty()) {
                stack.push(elements[i]);
            }
            else {
                Character top = stack.peek();
                if(areOpposite(top, elements[i])) {
                    stack.pop();
                }
                else {
                    stack.push(elements[i]);
                }
            }
        }

        return stack.empty();
    }

    private void run() {
        String brackets = ")(";
        System.out.println(properlyNested(brackets));
    }

    public static void main(String[] args) {
        new Brackets().run();
    }
}
