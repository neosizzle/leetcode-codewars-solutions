//https://leetcode.com/problems/advantage-shuffle/
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //use map to keep track of nums2 values and their original indexes
        Map<Integer, Queue<Integer>> ogIndexes = new HashMap<>();
        for(int i = 0; i < nums2.length; ++i){
            ogIndexes.putIfAbsent(nums2[i] , new LinkedList<>());
            ogIndexes.get(nums2[i]).add(i);
        }
        
        //sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //declare pointers for both arrays 
        int i = 0;
        int j = 0;
        
        //declare queue to store unused numbers
        Queue<Integer> unused = new LinkedList<>();
        
        //declare result array and fill it with -1
        int[]res = new int[nums1.length];
        Arrays.fill(res , -1);
        
        //traverse while both pointers are still in bounds
        while(i < nums1.length && j < nums2.length){
             //if nums[i] > nums2[j], we found a permutation
            if(nums1[i] > nums2[j]){
                //add the number into result array with index from map
                res[ogIndexes.get(nums2[j]).poll()] = nums1[i];
                
                ++j;
            }else{
                //number will bhe unusued
                unused.add(nums1[i]);
            }
            
            ++i;
            
        }
        
        //loop exited, check for unused numbers and add them into -1 slots
        for(int x = 0 ; x < res.length; ++ x){
            if(res[x] == -1){
                res[x] = unused.poll();
            }
        }
        
        return res;
    }
}
