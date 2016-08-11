import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if(n < 1)
		    return list;
		String str = "(";
		dfs(str, n, n - 1, n - 1, list);
		return list;
    }
	/**
	 * remainL is the number of remaining left parenthesis and remainR likewise*/
	public void dfs(String str, int n, int remainL, int remainR, List<String> list){
		if(str.length() == 2*n - 1){
			str += ')';
			list.add(str);
		}
		if(remainR < remainL - 1) //too much right parenthesis add to the current string
			return;
		if(remainL > 0)
			dfs(str + '(', n, remainL - 1, remainR, list);
		if(remainR > 0)
			dfs(str + ')', n, remainL, remainR - 1, list);

	}
}
