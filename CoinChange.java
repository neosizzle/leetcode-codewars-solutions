class Solution {
    public int coinChange(int[] coins, int amount) {
        //create dp array
        //to store the number of coins for each amount till amount required
        int[] dp = new int[amount + 1];
        
        //fill the array with something invalid
        Arrays.fill(dp,amount + 1);
        
        //base case
        dp[0] = 0;
        
        //iterate through dp array to populate values
        for(int i = 0 ; i <= amount; ++i){
            
            //for each amount in dp, loop through the coins that we have
            for(int j = 0; j < coins.length; ++j){
                
                //check if the current coin is less than the current amount
                if(coins[j] <= i){
                    //if yes, we will be able to take it
                    dp[i] = Math.min(dp[i] , 1 + dp[i - coins[j]]);
                    
                    //MAth.min() used because we want to take te minimum numbers or coins
                    //1 + is used because we are adding a new coin into our current coin number
                    //i - coins[j] will gve the leftover amount after taking the coins
                    //dp[i - coins[j]] will give the number of coins for that leftover amount
                    
                    
                }
                
            }
         
        }
        
        //check if the last value is populated
        return dp[amount] > amount? -1 : dp[amount];
    }
}
