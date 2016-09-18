
//It's goddamn complicated!
public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		if(s.length() > 0){
			if(s.contains("e")){
				if(s.endsWith("e"))
					return false;
				String[] portions = s.split("e");
				if(portions.length != 2)
					return false;
				else {
					String base = portions[0];
					String exp = portions[1];
					if(base.startsWith("-") || base.startsWith("+"))
						base = base.substring(1);
					if(exp.startsWith("-") || exp.startsWith("+"))
						exp = exp.substring(1);
					if(base.length() < 1 || exp.length() < 1)
						return false;
					return checkBase(base) && check(exp);
				}
			}
			else{
				return checkBase(s);
			}
			
		}
        return false;
    }
	
	private boolean checkBase(String base){
		if(base.endsWith(".")){
			int count = 0;
			for(int i = base.length() - 1; i >= 0; i--){
				if(base.charAt(i) == '.')
					count++;
				if(count > 1)
					return false;
			}
		}
		if(base.startsWith("-") || base.startsWith("+"))
			base = base.substring(1);
		String[] portions = base.split("\\.");
		if(portions.length > 2 || portions.length < 1)
			return false;
		else{

			if(portions.length == 2)
				return check(portions[0]) && check(portions[1]);
			return check(portions[0]);
		}
	}
	private boolean check(String str){
		for(int i = 0; i < str.length(); i++){
			int digit = str.charAt(i) - '0';
			if(digit > 9 || digit < 0)
				return false;
		}
		return true;
	}
}
