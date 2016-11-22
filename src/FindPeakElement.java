
public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if(right == 0)
            return 0;
        while(true){
            mid = (left + right)/2;
            if(right - left == 1)
                return nums[left] > nums[right] ? left : right;
            else if(nums[mid] < nums[mid + 1])//the middle element is on the left of peak
                left = mid;
            else if(nums[mid] < nums[mid - 1])//the middle element is on the right of peak
                right = mid;
            else//this is the peak
                return mid;
        }
    }
}
