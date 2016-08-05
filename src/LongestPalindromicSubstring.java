
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s){
		int length = s.length();
		Record max = new Record(0, 0, 1);
		if(length <= 1)
			return s;
		for(int i = 0; i < length - 1; i++){
			Record result = longestPalinExtendFromCenter(s, length, i);
			if(result.length > max.length)
				max = result;
		}
		return s.substring(max.start, max.end + 1);
	}
	public Record longestPalinExtendFromCenter(String s, int length, int center){
		int head, tail, maxlen;

		if(s.charAt(center) == s.charAt(center + 1)){
			head = center - 1;
			tail = center + 2;
			//find consecutive chars preceding
			while(head >= 0 && s.charAt(center) == s.charAt(head)){
				head--;
			}
			//find consecutive chars behind
			while(tail < length && s.charAt(center) == s.charAt(tail)){
				tail++;
			}
		}
		else{
			head = center - 1;
			tail = center + 1;
		}
		while(head >= 0 && tail < length){
			if(s.charAt(head) == s.charAt(tail)){
				head--;
				tail++;
			}
			else
				break;
		}
		maxlen = tail - head - 1;
		return new Record(head + 1, tail - 1, maxlen);
	}
}
class Record{
	int start;
	int end;
	int length;
	Record(int s, int e, int len){
		start = s;
		end = e;
		length = len;
	}
}