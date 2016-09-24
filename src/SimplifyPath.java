import java.util.LinkedList;


public class SimplifyPath {
	public String simplifyPath(String path) {
        String[] dirs = path.split("/+");
		LinkedList<String> stk = new LinkedList<String>();
		StringBuilder result = new StringBuilder();
		for(String dir : dirs){
			switch (dir) {
				case "":
				case ".":
					break;
				case "..":
					if(!stk.isEmpty())
						stk.pop();
					break;
				default:
					stk.push(dir);
					break;
			}
		}
		if(stk.isEmpty())//corner case
			result.append("/");
		else{
			for(String dir : stk){
				result.append("/");
				result.append(dir);
			}
		}	
        return result.toString();
    }
}
