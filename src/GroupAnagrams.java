import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
		HashMap<List<Character>, List<String>> map = new HashMap();
		int len = strs.length;
		for(int i = 0; i < len; i++){
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			List<Character> key = new ArrayList<Character>();
			for(char c : chars)
				key.add(c);
			List<String> value = map.get(key);
			if(value != null){
				value.add(strs[i]);
			}
			else{
				value = new ArrayList<String>();
				value.add(strs[i]);
				map.put(key, value);
				result.add(value);
			}
		}
        return result;
    }
}
