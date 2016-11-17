import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(s, new ArrayList<String>(), result);
        return result;
    }
	
    public void helper(String s, List<String> partition, List<List<String>> result){
        if(s.length() == 0){
            result.add(partition);
            return;
        }
        for(int i = 1; i <= s.length(); i++){
            if(isPalindrome(s.substring(0, i))){
                List<String> newPartition = new ArrayList<String>(partition);
                newPartition.add(s.substring(0, i));
                helper(s.substring(i), newPartition, result);
            }
        }
    }
    /**
     * judge if s is palindrome
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
        	if(s.charAt(i) != s.charAt(j))
        		return false;
        }
        return true;
    }
}
