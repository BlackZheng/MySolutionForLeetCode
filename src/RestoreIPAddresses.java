import java.util.ArrayList;
import java.util.List;


public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() <= 12){
            dfs(0, result, new ArrayList<Integer>(), s);
        }
        return result;
    }
    public void dfs(int start, List<String> result, List<Integer> barricade, String s){
        if(start >= s.length())
            return;
        if(barricade.size() == 3 && s.length() - start <= 3 ){
            String lastByte = s.substring(barricade.get(2), s.length());
            if(lastByte.charAt(0) == '0' && lastByte.length() > 1 || Integer.valueOf(lastByte) > 255)
                return;
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, barricade.get(0)));
            sb.append(".");
            sb.append(s.substring(barricade.get(0), barricade.get(1)));
            sb.append(".");
            sb.append(s.substring(barricade.get(1), barricade.get(2)));
            sb.append(".");
            sb.append(lastByte);
            result.add(sb.toString());
        }
        
        for(int i = 1; i <= 3; i++){
            if(s.charAt(start) == '0' && i > 1)
                return;
            if(i == 3 && start + 3 < s.length() && Integer.valueOf(s.substring(start, start + 3)) > 255)
                return;
            List<Integer> newBarr = new ArrayList<>(barricade);
            newBarr.add(start + i);
            dfs(start + i, result, newBarr, s);
        }
    }
}
