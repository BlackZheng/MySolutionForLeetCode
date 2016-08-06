import java.math.BigInteger;


public class StringToInteger {
	public int myAtoi(String str){
		str = str.trim();
		if(str.isEmpty())
			return 0;
		int length,index;
		StringBuilder result = new StringBuilder();
		length = str.length();
		char sign = str.charAt(0);
		if(sign == '+' || sign == '-'){		// handle sign
			index = 1;
			result.append(str.charAt(0));
			while(index < length && Character.isDigit(str.charAt(index))){ //move nums in str to result
				result.append(str.charAt(index));
				index++;
			}
			if(result.length() == 1)
				return 0;
		}
		else{
			index = 0;
			while(index < length && Character.isDigit(str.charAt(index))){
				result.append(str.charAt(index));
				index++; 
			}
			if(result.length() == 0)
				return 0;
		}
		//handle overflow
		BigInteger resultNum = new BigInteger(result.toString());
		if(resultNum.bitLength() > 31 && resultNum.signum() == 1)
			return Integer.MAX_VALUE;
		else if(resultNum.bitLength() > 31 && resultNum.signum() == -1)
			return Integer.MIN_VALUE;
		else
			return resultNum.intValue();
	}
}
