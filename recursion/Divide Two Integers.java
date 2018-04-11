//Divide Two Integers

class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (dividend == 0 || ldivisor > ldividend) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        long res = divideHelper(ldividend, ldivisor);
        int ans;
        if (res > Integer.MAX_VALUE) {
            ans = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * res);
        }
        return ans;
        
    }
    
    private long divideHelper(long dividend, long divisor) {
        if (divisor > dividend) {
            return 0;
        }
        long sum = divisor;
        long res = 1;
        while (2 * sum < dividend) {
            sum += sum;
            res += res;
        }
        
        return res + divideHelper(dividend - sum, divisor);
    }
}