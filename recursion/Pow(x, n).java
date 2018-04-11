//Pow(x, n)

class Solution {
    public double myPow(double x, int n) {
        long N = n;
       if (N < 0) {
            N = -N;
            x = 1 / x;
       }
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 == 1) {
            return fastPow(x * x, n / 2) * x;
        } else {
            return fastPow(x * x, n / 2);
        }
    }
}