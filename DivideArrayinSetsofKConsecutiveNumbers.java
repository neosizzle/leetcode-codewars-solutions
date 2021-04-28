//https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        //edge cases and error checking 
        if(nums.length % k != 0){
            return false;
        }
        
        //create min heap and yeet all the elements into min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a , b) -> a - b);
        for(int i : nums){
            minHeap.add(i);
        }
   
        Integer currentNum = null;
       // while the minheap still has elements
        while(!minHeap.isEmpty()){
            
            //remove the top element from the heap and set it to a var
            int current = minHeap.poll();
            
            //remove k elements from the min heap
            for(int i = 1; i < k; ++ i) {
                //if the minheap does not have its consecutuve element, return false
                if(!minHeap.remove(current + i)){
                    return false;
                }
            }          
            
        }
  
   
        return true;
    }
    
}
