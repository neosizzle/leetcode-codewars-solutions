//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
class Solution {
    
    int g_res;
    
    //shell function, calls helper func and returns result
    public int maxLength(List<String> arr) {
        
        g_res = 0;
        getMaxLen(arr, "", 0);
        return (g_res);
    }
    
    //helper function to change result to the maximum value
    //arr is the array of string that we are tring to concat
    //curr if the current concated string
    //idx is the current idx of arr that we are tring to concat/ not concat
    //result is the result that we will be returning
    //
    //1. checks for outof bounds (basecase)
    //    -if yes, check for current string length and update result if needed
    //    - return
    //2. call the function by stimulating not adding current arr element to curr
    //3. call the function by stimulating adding current arr element to curr
    public void getMaxLen(List<String> arr, String curr, int idx)
    {
        if (idx == arr.size())
        {
            if (getUniqueStrLen(curr) > g_res)
                g_res = curr.length();
            return ;
        }
        if (getUniqueStrLen(curr) == -1)
            return ;
        getMaxLen(arr, curr, idx + 1);
        getMaxLen(arr, curr + arr.get(idx), idx + 1);
    }
    
    //helper function to get the length of the string of unique characters
    //returns -1 if there are same characters
    public int getUniqueStrLen(String str)
    {
        int[] chars;
        int i;
        
        chars = new int[26];
        i = 0;
        while (i < str.length())
        {
            if (chars[str.charAt(i) - 'a']++ > 0)
                return (-1);
            i++;
        }
        return str.length();
    }
}
