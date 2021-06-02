//https://leetcode.com/problems/minimum-path-sum/
class Solution {
    public int minPathSum(int[][] grid) {
        
        //error checking 
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        
        //create a 2d dp array to store the sum of path to that index of i j
        int[][] dp = new int[grid.length][grid[0].length];
        
        
        //start traversing the dp array to populate it
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                //add the current value at index i j in grid to dp index i j
                dp[i][j] += grid[i][j];
                
                //we also need to add the minumum path sum of the nodes above or to the left 
                //depending on which one is smaller
                if(i > 0 && j > 0){
                    //case 1, i j is in the middle of grid
                    //pick the smallest value above or to the left of the current index
                    dp[i][j] += Math.min(dp[i-1][j] , dp[i][j-1]);
                }
                else if(i > 0){
                    //case 2, first column but not first row
                    //add the value above
                    dp[i][j] += dp[i - 1][j];
                }
                else if( j > 0 ){
                    //case 3, first row but not first col
                    //add the value to the left
                    dp[i][j] += dp[i][j-1];
                }
                
            }
        }
        
        //after the dp array populated, return the value at bottom right corner
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
