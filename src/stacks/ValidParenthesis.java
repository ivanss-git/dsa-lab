package stacks;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        } 
        Map<Character, Character> clopen = Map.of(')', '(', ']', '[', '}', '{');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (clopen.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != clopen.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
    public static void main (String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        String s = "([{}])";
        System.out.printf("Output:", vp.isValid(s));
    }
}
