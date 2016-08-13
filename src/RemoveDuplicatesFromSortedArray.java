
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int lastVal, current, find, len;
		len = nums.length;
		if(len < 2)
			return len;
		lastVal = nums[0];
		current = 1;
		find = current + 1;
		while(current < len && find < len + 1){
			if(nums[current] <= lastVal){
				while(find < len && nums[find] <= lastVal)
					find++;
				if(find < len)
					nums[current] = nums[find];
				else break;
			}
			lastVal = nums[current];
			find++;
			current++;
		}
		return current;
    }
}
