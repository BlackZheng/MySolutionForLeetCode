
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        int lastNum = Integer.MIN_VALUE;
        int lastCount = 0;
        int slowRunner = 0;
        int fastRunner = 0;
        while(fastRunner < nums.length){
        	//the last number duplicate twice, so we need to swap 
        	//numbers in index of slowRunner and fastRunner, move the slowRunner and update lastNum
            if(nums[fastRunner] != lastNum){
                lastNum = nums[fastRunner];
                swap(nums, slowRunner, fastRunner);
                lastCount = 1;
                slowRunner++;
            }
            else{
                if(lastCount < 2){
                    swap(nums, slowRunner, fastRunner);
                    lastCount++;
                    slowRunner++;
                }
            }
            fastRunner++;
        }
        return slowRunner;
    }
    public void swap(int[] nums, int a, int b){
        if(a == b)
            return;
        else{
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
