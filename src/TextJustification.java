import java.util.ArrayList;
import java.util.List;


public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        int idx = 0;
		List<String> result = new ArrayList<String>();
		List<String> curWords;
		while(idx < words.length){
			int rowWidth = words[idx].length();//record length of the current line so far, but note that there is at least one space between two words
			int charLen = words[idx].length(); //record the number of characters in the current line
			curWords = new ArrayList<String>();
			curWords.add(words[idx]);
			while(idx + 1 < words.length && rowWidth + words[idx + 1].length() + 1 <= maxWidth){//get words as many as possible
				curWords.add(words[idx + 1]);
				rowWidth += words[idx + 1].length() + 1;
				charLen += words[idx + 1].length();
				idx++;
			}
			StringBuilder line = new StringBuilder();
			line.append(curWords.get(0));
			if(curWords.size() == 1){ //the last line might contain only one word, it should be left-justified.
				insertSpace(line, maxWidth - curWords.get(0).length());
			}
			else{
				int gapCount = curWords.size() - 1;
				int spaceCount = maxWidth - charLen;
				
				int gapLen = spaceCount / gapCount;//the minimum space which will fill between two words
				int remainSpace = spaceCount - gapLen * gapCount;//If the number of spaces on a line do not divide evenly between words, 
																//the empty slots on the left will be assigned more spaces than the slots on the right.
				
				if(idx == words.length - 1){// the current line is the last line, but it contains more than a word.
					for(int i = 1; i < curWords.size(); i++){
						String word = curWords.get(i);
						line.append(" ");
						line.append(word);
						spaceCount --;
					}
					insertSpace(line, spaceCount);
				}
				else{
					for(int i = 1; i < curWords.size(); i++){
						String word = curWords.get(i);
						insertSpace(line, gapLen);
						if(remainSpace > 0){
							line.append(" ");
							remainSpace--;
						}
						line.append(word);
					}
				}
			}
			result.add(line.toString());
			idx++;
		}
        return result;
    }
    public void insertSpace(StringBuilder sb, int count){
		for(int i = 0; i < count; i++){
			sb.append(" ");
		}
	}
}
