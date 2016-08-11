import java.util.LinkedList;


public class ValidParentheses {
	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<Character>();
		int len = s.length();
		for(int i = 0; i < len; i++){
			switch (s.charAt(i)) {
			case '[':
			case '(':
			case '{':
				stack.push(s.charAt(i));
				break;
			case ')':
			    if(stack.isEmpty() || stack.peek() != '(')
			        return false;
			    stack.pop();
			    break;
			case '}':
			    if(stack.isEmpty() || stack.peek() != '{')
			        return false;
			    stack.pop();
			    break;
			case ']':
			    if(stack.isEmpty() || stack.peek() != '[')
			        return false;
				stack.pop();
				break;
			}
		}
		return stack.isEmpty();
    }
}
