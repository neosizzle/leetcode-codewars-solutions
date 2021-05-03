//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {
    public int maxProfit(int[] prices) {
       int profit = 0;
        
        //error check
        if(prices.length <2){
            return 0;
        }
        
        //iterate the prices linearly
        for(int i = 1; i < prices.length; ++i){
            //if an incresing peak is detected, which means profit is made
            //append the magnitude of profit to result
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
           
    }
}
