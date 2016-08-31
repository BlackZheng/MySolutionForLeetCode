
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        int start, end, mid, len;
		len = nums.length;
		start = 0;
		end = len - 1;
		mid = 0;
		while(start <= end){
			mid = (start + end) / 2;
			if(target < nums[mid])
				end = mid - 1;
			else if(target > nums[mid])
				start = mid + 1;
			else{	// find out target
				return mid;
			}
		}
		return target > nums[mid] ? mid + 1 : mid; //Couldn't find target, return the index of insert position
    }
}
