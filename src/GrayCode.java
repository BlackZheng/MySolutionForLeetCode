import java.util.ArrayList;
import java.util.List;


public class GrayCode {
	
//	My thought is same with a leetcode user, journey0408.
//	The explanation below is quoted from https://discuss.leetcode.com/topic/60220/1ms-java-solution  
//	One bit gray code 0,1
//	Two bits gray code 00,01,11,10
//	Three bits gray code 000,001,011,010,110,111,101,100
//	See the three bits gray code, the first half numbers are the say of two bits numbers; 
//	if you add "1" to the front of the two bits numbers and reverse, you can the last half of numbers.
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> cache = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; i++){
        	cache.clear();
        	for(int j = result.size() - 1; j >= 0; j--){
        		cache.add(result.get(j) ^ 1 << i);
        	}
        	result.addAll(cache);
        }
        return result;
    }
}
