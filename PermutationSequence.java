//https://www.youtube.com/watch?v=W9SIlE2jhBQ
//https://leetcode.com/problems/permutation-sequence/
class Solution {
    public String getPermutation(int n, int k) {
        
        //create new arraylist to store result digits
        ArrayList<Integer> result = new ArrayList();
        
        //create array of factorial values so i dont need to calculate them again
        //0!,1!,2!.....9!
        int[] factorials = {
            1,
            1,
            2,
            6,
            24,
            120,
            720,
            5040,
            40320,
            362880
        };
        
        //create an array which stores the most prominent numbers for each block
        ArrayList<Integer> prominentNums = new ArrayList<Integer>(n);
        for(int i = 1; i <= n; ++i){
            prominentNums.add(i);
        }
        
        //helper method
        findResult(n , k , factorials, prominentNums, result);
        
        //convert arraylist of digits into String and return
        StringBuilder resString = new StringBuilder();
        for(int i : result){
            resString.append(Integer.toString(i));
        }
        
        
        return resString.toString();
        
    }
    
    public void findResult(int n, int k, int[]factorials, ArrayList<Integer> prominentNums, ArrayList<Integer> result){
        //base case, return if n == 0
        if(n ==0 ){
            return;
        }
        
        
        //first of all, we calculate the block index
        int index = k / factorials[n - 1];
        
        //we have our index, we should check for the border case for the 0 indexed blocks
        if( k % factorials[n - 1] == 0){
            //the index would be 1 block away if this wasnt done for the border cases
            --index;
        }
        
        //we have our actual index at hand now, we can add the most prominent number of that block into our result
        result.add(prominentNums.get(index));
        
        //after we do so, we have to remove it from prominent number
        //every digit in the permutation is unique
        prominentNums.remove(index);
        
        //recursive call to solve smaller blocks
        findResult( n - 1 , k - index * factorials[n-1] , factorials, prominentNums, result);
        
    }
}
