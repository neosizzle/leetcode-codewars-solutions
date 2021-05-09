//https://leetcode.com/problems/assign-cookies/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        //edge case
        if(s.length == 0){
            return 0;
        }
        
        //sorrt both the greed and the size arrays
        Arrays.sort(g);
        Arrays.sort(s);
        
        //declare number of childred sastified
        int res = 0;

        //declare pointer
        int gPoint = 0;
        int sPoint = 0;
        
        while(gPoint < g.length && sPoint < s.length){
            
            
            //if the size is greater than the current greed factor
            //increment both greed pointer ans size pointer and result
            if(s[sPoint] >= g[gPoint]){
                ++gPoint;
                ++sPoint;
                ++res;
            }
            else{//else increment s Point
                ++sPoint;
            }
            

        }
        
        return res;
        
    }
}
