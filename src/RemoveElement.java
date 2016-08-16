
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        int len, newLength, move;
		len = nums.length;
		newLength = 0;
		move = newLength;
		while(move < len){
			while(move < len && nums[move] == val){
				move ++;
			}
			if(move < len)
				nums[newLength] = nums[move];
			else	
				return newLength;
			move ++;
			newLength ++;
		}
		return newLength;
    }
}
