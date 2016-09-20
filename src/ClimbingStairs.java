
public class ClimbingStairs {
	//The main thought is dynamic programming!
	public int climbStairs(int n) {
        if(n < 2)
            return 1;
        //The are n + 1 stairs when it takes n steps to reach to the top.
        int[] stairs = new int[n + 1];
        stairs[0] = stairs[1] = 1;
        for(int i = 2; i < n + 1; i++){
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n];
    }
}
