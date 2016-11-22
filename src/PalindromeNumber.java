
public class PalindromeNumber {
//	1.Scan the x to get the number of digits,digitCount.
//	2.Compare digitCount/2 digits scanning from left to right and those from right to left one by one.
	public boolean isPalindrome(int x) {
		//negative integers can't be palindromes
        if(x < 0)
            return false;
//       single digit is palindrome
        if(x == 0 || x < 10)
            return true;
        int digitCount = 2;
//    	1.Scan the x to get the number of digits--digitCount
        for(int i = 10; x / i >= 10; i *= 10, digitCount++);
        int x1 = x;
        int divisor = (int)Math.pow(10, digitCount - 1);
//    	2.Compare digitCount/2 digits scanning from left to right and those from right to left one by one
        for(int i = 0; i < digitCount / 2; i++, divisor /= 10){
            int digit1 = x / divisor;//get digits from left to right
            x = x - digit1 * divisor;
            int digit2 = x1 % 10;//get digits from right to left
            x1 /= 10;
            if(digit1 != digit2)
                return false;
        }
        return true;
    }
}
