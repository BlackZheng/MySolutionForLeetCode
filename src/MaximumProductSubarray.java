
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
        int[] maxProducts = new int[nums.length];
        int[] minProducts = new int[nums.length];
        maxProducts[0] = minProducts[0] = nums[0];
        int max = Math.max(Integer.MIN_VALUE, nums[0]);
        for(int i = 1; i < nums.length; i++){
            maxProducts[i] = Math.max(nums[i], maxProducts[i - 1] * nums[i]);
            maxProducts[i] = Math.max(maxProducts[i], minProducts[i - 1] * nums[i]);
            minProducts[i] = Math.min(nums[i], maxProducts[i - 1] * nums[i]);
            minProducts[i] = Math.min(minProducts[i], minProducts[i - 1] * nums[i]);
            max = Math.max(max, maxProducts[i]);
        }
        return max;
    }
}
