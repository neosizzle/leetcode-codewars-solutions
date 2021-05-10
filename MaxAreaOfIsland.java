//https://leetcode.com/problems/max-area-of-island/
class Solution {
    
    int area = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int res = 0;
        
        //traverse the matrix linearly
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                
                if(grid[i][j] == 1){
                    //if an island is found, do a bfs and sink every other land adjacent
                    res = Math.max(res , findArea(grid , i ,j));
                    
                    //reset temp area var
                    area = 0;
                }
                
            }
        }
        
    
        
        //compare sizes and return largest size
        return res;
    }
    
    public int findArea(int [][] grid , int i, int j){
        
        //base case
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0 ){
            return area;
        }
        
        //sink current island and increment area value
        grid[i][j] = 0;
        ++area;
        
        //call this function recursively to all adjacent nodes
        findArea(grid , i + 1 ,j);
        findArea(grid , i - 1 ,j);
        findArea(grid , i ,j + 1);
        findArea(grid , i ,j - 1);
        
        
        return area;
    }
}
