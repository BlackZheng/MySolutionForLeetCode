
public class ReverseInteger {
	public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
		String s = sb.reverse().toString();
		if(!Character.isDigit(s.charAt(s.length()-1))){
        	s = s.charAt(s.length()-1)+s.substring(0, s.length()-1);
        }
		long reverse = Long.valueOf(s);
		if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
			return 0;
		else
			return (int) reverse;
    }
}
