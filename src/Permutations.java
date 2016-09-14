import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();//first permutation
		List<List<Integer>> temp; //store the result temporarily
		for(int i = 0; i < nums.length; i++)
			list.add(nums[i]);
		result.add(list);
		for(int i = 1; i < nums.length; i++){
			temp = new ArrayList<List<Integer>>();
			for(List<Integer> list1 : result){
				for(int j = 0; j < i; j++){
					List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(new Integer[list1.size()]));
					Collections.copy(list2, list1);
					Collections.swap(list2, i, j);
					temp.add(list2);
				}
			}
			result.addAll(temp);
		}
		return result;
    }
}
