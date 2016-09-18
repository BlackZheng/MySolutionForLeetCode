
public class AddBinary {
	public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < lenA; i++){
            int digitA = a.charAt(lenA - i - 1) - '0';
            int digitB = 0;
            if(i < lenB)
                digitB = b.charAt(lenB - i - 1) - '0';
            int add = (digitA + digitB + carry) % 2;
            carry = (digitA + digitB + carry) / 2;
            result.insert(0, add);
        }
        if(carry == 1)
            result.insert(0, carry);
        return result.toString();
    }
}
