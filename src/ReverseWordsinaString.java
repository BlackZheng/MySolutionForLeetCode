
public class ReverseWordsinaString {
	public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0;){
            if(s.charAt(i) != ' '){
                int j = i - 1;
                //locate the starting index of the word
                while(j >= 0 && s.charAt(j) != ' ')
                    j--;
                sb.append(s.substring(j + 1, i + 1));
                sb.append(" ");
                i = j - 1;
            }else
                i--;
                
        }
        //delete the last space
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
