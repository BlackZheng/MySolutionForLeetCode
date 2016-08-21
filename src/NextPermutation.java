import java.util.Arrays;


public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int len = nums.length;
		int max;//find the larest number in nums[toSwap~len - 1]
		int toSwap;
		
		if(len < 2)
			return;
		toSwap = len - 2;
		
		//find index of the number need to be swapped 
		while(toSwap >= 0){
			max = max(nums, toSwap, len);
			if(nums[toSwap] < max)
				break;
			else
				toSwap--;
		}
		if(toSwap < 0){ //It means the order of nums is descending
			Arrays.sort(nums);
			return;
		}
		//find index of target to be swapped with toSwap
		int target = toSwap + 1;
		while(target < len && nums[target] > nums[toSwap])
			target++;
		
		//swap
		swap(nums, toSwap, target - 1);
		//after swapping, the order of permutation next to "toSwap" need to be reversed , beaucause it's descending
		reverse(nums, toSwap + 1, len);
    }
    private int max(int[] nums, int start, int len){
		int max;
		max = start;
		for(int i = start + 1; i < len; i++)
			if(nums[i] > nums[max])
				max = i;
		return nums[max];
	}
	private void reverse(int[] nums, int start, int len){
		while(start < len - 1){
			swap(nums, start, len -1);
			start++;
			len--;
		}
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
}
