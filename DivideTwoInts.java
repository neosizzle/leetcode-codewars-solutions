//https://leetcode.com/problems/divide-two-integers/
class Solution {
    public int divide(int dividend, int divisor) {
        //overflow check
        if(dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
        
        if(dividend == Integer.MIN_VALUE && divisor == 1) 
            return Integer.MIN_VALUE;
        
        boolean isNeg = false;
        //negative check
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0 ))
            isNeg = true;
            
        long res;
        
        res = 0L;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int shift = 31;
        while(a >= b)
        {
            //find the higest multiple for a which is a power of 2
            //start from 2^31 , 2^30 ....
            //we will reach a point where 2^shift < a
            //that will be our highest multiple in the power of 2
            while (a < b << shift)
            {
                --shift;
            }
            
            //a will then deduct the highest multiple in the power of 2
            //res will add the value of the multiple 
            a -= b << shift;
            res += 1 << shift;
        }
        
        return isNeg ? (int)-res : (int)res;
    }
}
