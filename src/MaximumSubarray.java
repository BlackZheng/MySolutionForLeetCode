
public class MaximumSubarray {
	/**
	 * The key is Dynamic Programming!
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        int start, all;
		start = all = nums[0];
		for(int i = 1; i < nums.length; i++){
			start = Math.max(nums[i], nums[i] + start);
			all = Math.max(all, start);
		}
		return all;
    }
}
