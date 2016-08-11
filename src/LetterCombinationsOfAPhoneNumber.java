import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
		// 按键表对应的字母，例：按键2对应dic[2]("abc")
        String[] dic = {" ","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> resultSet = new ArrayList<String>(); //存放结果
		if(digits.length() < 1) //空字母串返回空列表
		    return resultSet;
		recurCombine(dic, digits, 0, "", resultSet);
		return resultSet;
    }
    public void recurCombine(String[] dic, String digits, int idx, String out, List<String> resultSet){
		if(idx > digits.length() - 1){
			resultSet.add(out); //递归到最后一个按键数字时将结果字符串加入列表
			return;
		}
		int index = Integer.parseInt(digits.substring(idx, idx + 1)); //将输入字符转换为整数
		for(int i = 0; i < dic[index].length(); i++){//遍历一个按钮上对应的字母
			String str = out + dic[index].charAt(i);
			recurCombine(dic, digits, idx + 1, str, resultSet);//递归
		}
	}
}