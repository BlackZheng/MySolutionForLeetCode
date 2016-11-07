
public class DecodeWays {
	//Not a easy-understanding solution
	public int numDecodings(String s) {
        int len = s.length();
        int result = 1;
        int canMerge = 0;
        int cantMerge = 1;
        if(len == 0 || s.charAt(0) == '0')
            return 0;
        else if(len == 1)
            return 1;
        for(int i = 0; i < len - 1; i++){
            result = s.charAt(i) == '0'? canMerge : 2 * canMerge + cantMerge;
            if(Integer.parseInt(s.substring(i, i + 2)) <= 26){
                cantMerge = canMerge;
            }else{
                cantMerge = result;
            }
            canMerge = result - cantMerge;
        }
        return  s.charAt(len - 1) == '0'? canMerge : 2 * canMerge + cantMerge;
    }
}
