// /https://leetcode.com/problems/zigzag-conversion/
class Solution {
    public String convert(String s, int numRows) {
        //check for edge cases
        if (numRows > s.length() || numRows == 1) return s;
        
        //traverse the string in a zig-zag way, e.g. rows = 3:
        //row 1,2,3,2,1,2,3.....
        //for every row will be a new strings
        //concat strings in the end using the strings at our rows
        
        //initialize rows
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; ++i)
        {
            rows.add(new StringBuilder());
        }
        
        //start traversing
        //initialize direction
        boolean goingDown = false;
        
        //initialize current row
        int currRow = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            //change direction if at the first / last row
            if(currRow == 0 || currRow == numRows - 1)
            {
                goingDown = !goingDown;
            }
            
            //append current character to current row
            rows.get(currRow).append(s.charAt(i));
            
            //change the current row based on goingdown
            if (goingDown) currRow++;
            else currRow--;
        }
        
        //we have our rows populated, now we generate result string
        StringBuilder res = new StringBuilder();
        for(StringBuilder currStr : rows)
        {
            res.append(currStr);
        }
        
        return res.toString();
    }
}
