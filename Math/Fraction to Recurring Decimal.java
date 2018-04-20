//Fraction to Recurring Decimal

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        StringBuffer res = new StringBuffer();
        
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            res.append("-");
        }
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        long pre = num / den;
        long remain = num % den;
        
        res.append(pre);
        
        if (remain == 0) {
            return res.toString();
        }
        
        res.append('.');
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(remain, res.length());
        
        while (remain != 0) {
            remain *= 10;
            long insert = remain / den;
            res.append(insert);
            remain %= den;
            if (map.containsKey(remain)) {
                int index = map.get(remain);
                res.insert(index, "(");
                res.append(")");
                return res.toString();
            }
            map.put(remain, res.length());
            
        }
        return res.toString();
        
    }
}