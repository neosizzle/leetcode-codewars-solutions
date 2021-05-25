//https://leetcode.com/problems/partition-labels/
class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> res = new ArrayList<>();
        
        //record the last occurence of every character
        int[] lastIndex = new int[26];
        
        for(int i = 0; i < s.length(); ++ i){
            lastIndex[s.charAt(i) - 'a'] = i; //s.charAt(i) - 'a' will give is 0 indexed position based on lowercase letters
        }
        
        //traverse through the string to create partitions
        int i = 0;
        while(i < s.length()){
            //get the last occurence of that letter
            int end = lastIndex[s.charAt(i) - 'a'];
            
            //declare second pointer to start checking for subsequence characters
            int j = i;
            
            //while the second pointer is not at the end of partition
            while( j < end ){
                
                //update the end value with the last occurence of character j or stay
                end = Math.max(end , lastIndex[s.charAt(j) - 'a']);
                
                //increment j
                ++j;
                
                
            }
            
            //after the partition loop ends, we can add the difference of the pointers to result
            res.add( j - i + 1);
            
            //move i to j;
            i = j + 1;
        }
        
        return res;
    }
}
