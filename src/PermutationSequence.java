import java.util.LinkedList;
import java.util.List;


public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		k --;
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < n; i++)
			list.add(i + 1);
		while(n > 1){
			int group = fac(n - 1);
			int i = k / group;
			sb.append(list.get(i));
			list.remove(list.get(i));
			n --;
			k %= group;
		}

			sb.append(list.get(0));
        return sb.toString();
    }
	public int fac(int n){
		int result = 1;
		for(int i = 0; i < n ; result *= (i + 1), i++);
		return result;
	}
}
