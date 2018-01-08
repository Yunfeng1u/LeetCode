import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {

        if (s == null || s.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isMatch(stack.peek(), c)) {
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static boolean isMatch(char charInStack, char charLeft) {
        switch (charInStack) {
            case '(':
                if (charLeft == ')')
                    return true;
                break;
            case ')':
                if (charLeft == '(')
                    return true;
                break;
            case '[':
                if (charLeft == ']')
                    return true;
                break;
            case ']':
                if (charLeft == '[')
                    return true;
                break;
            case '{':
                if (charLeft == '}')
                    return true;
                break;
            case '}':
                if (charLeft == '{')
                    return true;
                break;
        }
        return false;
    }
}
