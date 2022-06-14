import java.util.Stack;

public class MathRemove {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(String.valueOf(s.charAt(i)));
            else {
                String lastVal = stack.peek();
                String currVal = String.valueOf(s.charAt(i));
                if (lastVal.equals(currVal))
                    stack.pop();
                else
                    stack.push(currVal);

            }
        }
        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        MathRemove mathRemove = new MathRemove();
        mathRemove.solution("baabaa");
    }
}
