
public class PlusOne {
	public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >=0; i-- ){
            digits[i] = ++digits[i] % 10;
            if(digits[i] != 0) //The digit is less than 9
                break;
        }
        if(digits[0] == 0){//the number overflow, create a bigger array
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int i = 0, j = 1; i < digits.length; i++, j++){
                newDigits[j] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}
