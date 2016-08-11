import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
		// �������Ӧ����ĸ����������2��Ӧdic[2]("abc")
        String[] dic = {" ","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> resultSet = new ArrayList<String>(); //��Ž��
		if(digits.length() < 1) //����ĸ�����ؿ��б�
		    return resultSet;
		recurCombine(dic, digits, 0, "", resultSet);
		return resultSet;
    }
    public void recurCombine(String[] dic, String digits, int idx, String out, List<String> resultSet){
		if(idx > digits.length() - 1){
			resultSet.add(out); //�ݹ鵽���һ����������ʱ������ַ��������б�
			return;
		}
		int index = Integer.parseInt(digits.substring(idx, idx + 1)); //�������ַ�ת��Ϊ����
		for(int i = 0; i < dic[index].length(); i++){//����һ����ť�϶�Ӧ����ĸ
			String str = out + dic[index].charAt(i);
			recurCombine(dic, digits, idx + 1, str, resultSet);//�ݹ�
		}
	}
}