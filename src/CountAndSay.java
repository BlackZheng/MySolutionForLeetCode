//Runtime:3ms beats 76.67%
public class CountAndSay {
	public String countAndSay(int n) {
        if(n < 1)
			return "";
		int idx, countIdx, count, len;
		StringBuilder holder = new StringBuilder("1");//initializing sequence
		String target; 
		char curNum;
		for(int i = 1; i < n; i ++){
			idx = 0;
			target = holder.toString();
			len = target.length();
			holder.delete(0, len);//empty holder
			while(idx < len){ //one saying
				count = 1;
				countIdx = idx + 1;
				curNum = target.charAt(idx);
				while(countIdx < len && target.charAt(countIdx) == curNum){ //count the repeated current number
					count++;
					countIdx++;
				}
				holder.append(count);
				holder.append(curNum);
				idx = countIdx;
			}
		}
        return holder.toString();
    }
}
