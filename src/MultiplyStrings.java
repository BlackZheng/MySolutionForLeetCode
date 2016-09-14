
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        String zero = "0";
		if(num1.equals(zero) || num2.equals(zero))
			return zero;
        int len1, len2;
		if(num1.length() < num2.length()){
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		len1 = num1.length();
		len2 = num2.length();
		StringBuilder result = new StringBuilder();
		int extra = 0;
		int pSum;
		int mul1, mul2;
		String insert;
		int max = len1 + len2;
		for(int i = 1; i < max; i++){
			pSum = 0;
			for(int j = 1; j < Math.min(i + 1, len2 + 1); j++){
				if(len1 - 1 -i + j >= 0){
					mul1 = Integer.parseInt(String.valueOf(num1.charAt(len1 - 1 -i + j)));
					mul2 = Integer.parseInt(String.valueOf(num2.charAt(len2-j)));
					pSum += mul1 * mul2;
				}
			}
			pSum += extra;
			insert = String.valueOf(pSum % 10);
			extra = pSum / 10;
			result.insert(0, insert);
		}
		if(extra > 0)
			result.insert(0, extra);
        return result.toString();
    }
}
