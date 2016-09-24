import java.util.ArrayList;
import java.util.List;

/**
 * You can see my graph explanation in https://discuss.leetcode.com/topic/60230/easy-java-solution-with-graph-explanation
 * @author BlackZheng
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		int resultSize = 1;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());//Initially, there must be a empty set
		for(int i = 0; i < nums.length; i ++){
			for(int j = 0; j < resultSize; j++){
				List<Integer> subSet = new ArrayList<Integer>(result.get(j));
				subSet.add(nums[i]);
				result.add(subSet);
			}
			resultSize *= 2;
		}
        return result;
    }
}
