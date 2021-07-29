//https://leetcode.com/problems/coin-change-2/
class Solution {
    public int change(int amount, int[] coins) {
        
        //create dp array
        //to store the number of coins for each amount till amount required
        int[] dp = new int[amount + 1];
        
        
        //base case
        dp[0] = 1;
        
        //iterate through coins
        for(int coin : coins){
            //for every coin we iterate, populate dp
            
            //we want to start populating the dp with the current coin up till the amount
            //for every iteration, we update the curr dp value with the previous calculated value
            //dp[i - coin] gets the calculated value of denominator of remaining coins
            //i is the amount, coin is the current coin value
            //dp[5] += dp[5 - 2] translated to dp with amount[5] will increment the value of dp[5] with the remainder when minus with dp[2] which will give is dp[3]
            for(int i = coin; i <= amount; ++i)
            {
                dp[i] += dp[i - coin];
            }
         
        }
        
        //return the number of ways to populate x amount of coins
        return dp[amount];
        
    }
}
