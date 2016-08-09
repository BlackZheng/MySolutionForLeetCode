
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int minLen;
		if(strs.length <1)
			return "";
		minLen = strs[0].length();
		String minStr = strs[0];
		boolean isFind;
		//找到最小长度的字符串
		for(String str:strs){   
			if(str.length() < minLen){
				minLen = str.length();
				minStr = str;
			}
				
		}
		//以最小长度字符串为key,遍历字符串数组， 如果不是共有前缀，则去掉最小长度字符串的最后一个字符重复前面过程
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
