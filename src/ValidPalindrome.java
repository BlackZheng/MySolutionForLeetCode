
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(i < s.length() && !isAlphanumeric(s.charAt(i)))// skip non-alphanumeric characters
                i ++;
            while(j >= 0 && !isAlphanumeric(s.charAt(j)))// skip non-alphanumeric characters
                j --;
            if(i < j){
                if(!s.substring(i, i + 1).equalsIgnoreCase(s.substring(j, j + 1)))
                    return false;
            }
        }
        return true;
    }
	/**
	 * judge if c is alphanumeric characters
	 * @param c
	 * @return
	 */
    public boolean isAlphanumeric(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
