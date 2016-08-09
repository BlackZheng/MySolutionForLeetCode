/**
 *���������ǰ��������ִ���֮ǰʹ�õ�һ�����롣
 *�������ֲ����߸�������ĸ�����֡�����1����X��10����C��100����M��1000����V��5����L��50����D��500����
 *�����ķ�����
 *	��ͬ��������д������ʾ����������Щ������ӵõ��������� ��=3��
 *	С�������ڴ�����ֵ��ұߣ�����ʾ����������Щ������ӵõ��������� ��=8����=12��
 *	С�����֣����� ��X �� C���ڴ�����ֵ���ߣ�����ʾ�������ڴ�����С���õ��������� ��=4����=9�� 
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
