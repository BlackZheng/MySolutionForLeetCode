
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int minLen;
		if(strs.length <1)
			return "";
		minLen = strs[0].length();
		String minStr = strs[0];
		boolean isFind;
		//�ҵ���С���ȵ��ַ���
		for(String str:strs){   
			if(str.length() < minLen){
				minLen = str.length();
				minStr = str;
			}
				
		}
		//����С�����ַ���Ϊkey,�����ַ������飬 ������ǹ���ǰ׺����ȥ����С�����ַ��������һ���ַ��ظ�ǰ�����
		while(minLen > 0){
			isFind = true;
			for(String str:strs){
				if(!str.startsWith(minStr)){
					isFind = false;
					break;
				}
			}
			if(isFind)
				break;
			minLen--;
			minStr = minStr.substring(0, minLen);
		}
		return minStr;
    }
}
