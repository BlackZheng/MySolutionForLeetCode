
public class JumpGame {
	public boolean canJump(int[] nums) {
		int maxReach = 0;
        int len = nums.length;
        int reach;
        if(len <= 1)
            return true;
        for(int i = 0; i < len; i++){
            if(maxReach < i) //we can not reach the current position, so can't jump
                return false;
            if(maxReach >= len - 1)//we reach the last position, can jump!
                return true;
            reach = nums[i] + i;
            maxReach = reach > maxReach ? reach : maxReach;
        }
        return true;
    }
}
