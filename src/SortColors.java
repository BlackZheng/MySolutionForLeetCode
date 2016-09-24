
public class SortColors {
	public void sortColors(int[] nums) {
		int red = 0;
        int blue = nums.length - 1;
        int pointer = 0;
        if(blue < 0) //empty array
        	return;
        else{
        	while(pointer <= blue){
        		switch (nums[pointer]) {
				case 0:// if we encounter 0, put it to the nums[red]
					swap(nums, red, pointer);
					red++;
					pointer++;
					break;
				case 2:// if we encounter 2, put it to the nums[blue]
					swap(nums, blue, pointer);
					blue--;
					break;
				default:
					pointer++;
					break;
				}
        	}
        }
    }
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
