
public class ZigZagConversion {
	public String convert(String s, int numRows) {
        int gap1, gap2, length;
		StringBuilder result;
		if(numRows <= 1)
			gap1 = 1;
		else
			gap1 = numRows + numRows - 2;
		gap2 = 0;
		length = s.length();
		result = new StringBuilder();
		if(length <= numRows)
			return s;
		for(int i = 0; i < numRows; i++){
			int col_index = i; 
			while(col_index < length){
				if(gap1 > 0){
					result.append(s.charAt(col_index));
					col_index += gap1;
				}
				if(gap2 > 0 && col_index < length){
					result.append(s.charAt(col_index));
					col_index += gap2;
				}
			}
			gap1 -= 2;
			gap2 += 2;
		}
		return result.toString();
    }
}
