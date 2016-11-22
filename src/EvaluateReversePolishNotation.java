import java.util.LinkedList;


public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        LinkedList<Integer> stk = new LinkedList<>();
        for(int i = 0; i < tokens.length; i++){
            int operand;
            switch(tokens[i]){
                case "+":
                    stk.push(stk.pop() + stk.pop());
                    break;
                case "*":
                    stk.push(stk.pop() * stk.pop());
                    break;
                case "-":
                    operand = stk.pop();
                    stk.push(stk.pop() - operand);
                    break;
                case "/":
                    operand = stk.pop();
                    stk.push(stk.pop() / operand);
                    break;
                default:
                    stk.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stk.pop();
	}
}
