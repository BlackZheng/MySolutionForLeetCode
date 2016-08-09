/**
 *罗马数字是阿拉伯数字传入之前使用的一种数码。
 *罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。
 *记数的方法：
 *	相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
 *	小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
 *	小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9； 
 *
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
		String [] symbol = {"I", "V", "X", "L", "C", "D", "M"};
		int remain;
		int symIdx = 0;
		String temp;
		do{
			remain = num % 10;
			num = num / 10;
			temp = "";
			if(remain != 4 && remain != 9){
				if(remain > 4){
					temp += symbol[symIdx + 1];
					remain = remain % 5;
				}
				for(int i = 0; i < remain; i ++)
					temp += symbol[symIdx];
				
			}
			else{
				temp += remain == 4 ? symbol[symIdx] + symbol[symIdx + 1] : symbol[symIdx] + symbol[symIdx + 2];
			}
			symIdx += 2;
			result.insert(0, temp);
		}while(num > 0);
		
		return result.toString();
    }
}
