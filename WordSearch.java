//https://leetcode.com/problems/word-search/
class Solution {
    public boolean exist(char[][] board, String word) {
        //tracerse the entire board
        for(int i = 0; i < board.length; ++i){
            
            for(int j = 0; j < board[0].length; ++j){
                //start search if the current character is the first character of string
                if(board[i][j] == word.charAt(0)){
                    //helper method 
                    if(dfs(board,i,j,0,word)){
                        return true;
                    }
                    
                }
                
            }
            
        }
        
        //return false if no words are found
        return false;
        
    }
    
    //helper method
    public boolean dfs(char[][] board , int i , int j, int index, String word){
        
        //the current element is the letter that we are searching for, check if its the last letter
        if(index == word.length()){
            return true;
        }
        
        //base case, out of bounds and character does not match count
        if(i < 0 ||
           i >= board.length ||
           j < 0 ||
           j >= board[0].length||
           board[i][j] != word.charAt(index)
          )
        {
            return false;
        }
        
        char temp = board[i][j];
        

        
        //if its not, we sink the character keep searching in all directions
        board[i][j] = '0';
        
        boolean isWordFound =  
        dfs(board,i + 1,j,index + 1,word) ||
        dfs(board,i - 1,j,index + 1,word) ||
        dfs(board,i,j + 1,index + 1,word) ||
        dfs(board,i,j - 1,index + 1,word) ;
        
        
        //unsink character
        board[i][j] = temp;
        
        return isWordFound;
        
       
        
        

        
    
        
    }
}
