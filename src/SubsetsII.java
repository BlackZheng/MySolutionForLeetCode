import java.util.ArrayList;
import java.util.List;


public class SubsetsII {
	//The main thought is similar to the solution of Subset I.
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> cache = new ArrayList<List<Integer>>();
		int lastNum = 0;//last processed number
		if(nums.length > 0)
			lastNum = nums[0];
		int lastCount = 1;//the number of subset that we got at last process
		result.add(new ArrayList<Integer>());
		for(int num : nums){
			int count = 0;
			int start;
			cache.clear();
			if(num == lastNum)
				start = result.size() - lastCount;
			else
				start = 0;
			for(int i = start; i < result.size(); i++ ){
				List<Integer> list = new ArrayList<Integer>(result.get(i));
				list.add(num);
				count++;
				cache.add(list);
			}
			lastNum = num;
			lastCount = count;
			result.addAll(cache);
		}
		return result;
    }
}
