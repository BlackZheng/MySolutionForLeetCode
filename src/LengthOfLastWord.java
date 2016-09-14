
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int length = words.length;
        if(length > 0)
            return words[length - 1].length();
        else
            return 0;
    }
}
