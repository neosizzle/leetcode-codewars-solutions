//https://leetcode.com/problems/sudoku-solver/
class Solution {
    /*
    Entry point
    
    1. Call solver helper
    @param char[][] board array
    @retrun void
    */
    public void solveSudoku(char[][] board) {
        solver(board);
    }
    
    /*
    Backtracking Algorithm
    
    1. Traverse all the units, while doing so,
        - If the current box is a blank,
            - Traverse 1 to 9 and try attempting to replace the current
            Box with that number
            - Check if the repalcement is valid. If yes, replace char and recurse
            - If child returns true, return true as we have found a solutuion
            - Else, Reset char into . and continue
        - Return false at this point for no valid characters can be put in
    2. Return true in the end after traversed all units (no units)
    
    @param char[][]     board array
    @retrun boolean     true if solvable, false if not
    */
    public boolean solver(char [][] board)
    {
        for(int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                if (board[row][col] == '.')
                {
                    for (char c = '1'; c <= '9'; c++)
                    {
                        if (is_valid(board, row, col, c))
                        {
                            board[row][col] = c;
                            if (solver(board))
                                return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    /*
    Checker that checks for current row, col and box for repeating nums
    
    @param char[][] b   The board
    @param int row      Row num
    @param int col      Col num
    @param char c       The character to be inserted
    @retrurn boolean    True if valid, false if invalid
    */
    private boolean is_valid(char[][] b, int row, int col, char c)
    {
        for (int i = 0; i < 9; i++) {
            if (b[i][col] == c) return false;
            if (b[row][i] == c) return false;
            if (b[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}
