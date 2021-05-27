//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
class Solution {
    public boolean check(int[] nums) {
        //declare a new array and make it a copy of the sorted array of nums
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        //declare a temp array which has concat of  2 nums
        int[] temp = new int[nums.length * 2];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        System.arraycopy(nums, 0, temp, nums.length, nums.length);
           
        //abab contains ba
        //inside the temp array, look for the sorted array and return true if found
        for(int i = 0 ; i < temp.length; ++i){
            if(temp[i] == sorted[0] && contains(temp , i , sorted)){
                return true;
            }
        }
        
        return false;
    }
    
    //helper
    public boolean contains(int[] temp , int index, int[] sorted){
        int sortedIndex = 0;

        
        //iterate through sorted
        while(sortedIndex < sorted.length){
            
            //constraint checking
            if(index == temp.length){
                return false;
            }
            
            //if the current index in temp is not equals to current index in sorted, returh false
            if(temp[index] != sorted[sortedIndex]){
                return false;
            }
            
            ++sortedIndex;
            ++index;
        }
        
        return true;
        
    }
}
