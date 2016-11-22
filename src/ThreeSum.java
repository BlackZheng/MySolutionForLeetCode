import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ){
            int twoSum = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                if(nums[j] + nums[k] == twoSum){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while(++j < k && nums[j] ==nums[j-1]);
                    while(--k > j && nums[k] == nums[k+1]);
                }else if(nums[j] + nums[k] > twoSum)
                    k--;
                else j++;
            }
            while(++i < nums.length && nums[i] == nums[i-1]);
        }
        return result;
    }
}
