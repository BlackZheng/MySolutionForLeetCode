
public class RomanToInteger {
	public int romanToInt(String s) {
        String symbol = "IVXLCDM";
		int[] value = {1, 5, 10, 50, 100, 500, 1000};
		int strIdx = 0;
		int len = s.length();
		int curIdx;
		int result = 0;
		while(strIdx < len){
			curIdx = symbol.indexOf(s.charAt(strIdx));
			if(strIdx + 1 < len && value[curIdx] < value[symbol.indexOf(s.charAt(strIdx + 1))]){
				result += value[symbol.indexOf(s.charAt(strIdx + 1))] - value[curIdx];
				strIdx++;
			}
			else{
				result += value[curIdx];
			}
			strIdx++;
		}
		return result;
    }
}
