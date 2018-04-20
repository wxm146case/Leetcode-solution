//Multiply Strings

class Solution {
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        
        int[] num3 = new int[length1 + length2];
        int i, j, product, carry;
        
        
        for (i = length1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = length2 - 1; j >= 0; j--) {
                product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + num3[i + j + 1] + carry;
                num3[i + j + 1] = product % 10;
                carry = product / 10;       
            }
            num3[i + j + 1] = carry;
        }
        
        int start = 0;
        while (start < num3.length - 1 && num3[start] == 0) {
            start++;
        }
        StringBuffer res = new StringBuffer();
        for (i = start; i < num3.length; i++) {
            res.append(num3[i]);
        }
        return res.toString();
    }
}