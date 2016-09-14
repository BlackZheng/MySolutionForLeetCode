import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
		List<Integer> combination = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(target, candidates, 0, candidates.length, combination, result);
		return result;
    }
	/**
	 * Note: The code below have two place(mark ¢Ù and ¢Ú) different from the CombinationSum
	 * @param target
	 * @param c
	 * @param start
	 * @param end
	 * @param combination
	 * @param result
	 */
    public void dfs(int target, int[] c, int start, int end, List<Integer> combination, List<List<Integer>> result){
		int nextTarget;
		for(int i = start; i < end; i ++){
			List<Integer> list = new ArrayList<Integer>(combination);
			nextTarget = target - c[i];
			list.add(c[i]);
//			¢ÙHere we need to ensure the solution set 
//			must not contain duplicate combinations
			if(nextTarget == 0 && !result.contains(list))  
				result.add(list);
			else if(nextTarget < 0)
				return;
//			¢Ù We put i+1 instead because each number in C may 
//			only be used once in the combination
			else
				dfs(nextTarget, c, i + 1, end, list, result);
		}
	}
}
