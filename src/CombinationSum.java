import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
		List<Integer> combination = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(target, candidates, 0, candidates.length, combination, result);
		return result;
    }
   
    public void dfs(int target, int[] c, int start, int end, List<Integer> combination, List<List<Integer>> result){
		int nextTarget;
		for(int i = start; i < end; i ++){
			List<Integer> list = new ArrayList<Integer>(combination);
			nextTarget = target - c[i];
			list.add(c[i]);
			if(nextTarget == 0)
				result.add(list);
			else if(nextTarget < 0)
				return;
			else
				dfs(nextTarget, c, i, end, list, result);
		}
	}
}
