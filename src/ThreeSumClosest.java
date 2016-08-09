import java.util.Arrays;


public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
		int length = nums.length;
		int sumClosest = nums[0] + nums[1] + nums[2];
		int sum, i, j, k;
		for(i = 0; i < length - 2; i++){
			j = i + 1; 
			k = length - 1;
			while(j < k){
				sum = nums[i] + nums[j] + nums[k];
				if(sum < target)
					j++;
				else if(sum > target)
					k--;
				else
					return sum;
				if(Math.abs(sum - target) - Math.abs(sumClosest - target) < 0)
					sumClosest = sum;
			}
		}
		return sumClosest;
    }
}
