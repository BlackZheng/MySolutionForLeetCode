
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        int start, end, mid, len;
		len = nums.length;
		start = 0;
		end = len - 1;
		while(start <= end){
			mid = (start + end) / 2;
			if(target < nums[mid])
				end = mid - 1;
			else if(target > nums[mid])
				start = mid + 1;
			else{
				while(start < mid && nums[start] != target)
					start++;
				while(end > mid && nums[end] != target)
					end--;
				return new int[]{start, end};
			}
		}
		return new int[]{-1, -1};
    }
}
