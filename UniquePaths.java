//https://leetcode.com/problems/unique-paths/
class Solution {
       HashMap<List , Integer> map = new HashMap<List, Integer>();
    public int uniquePaths(int m, int n) {
 
        
        //base case exit condition
        if(n == 1|| m == 1 ){
            return 1;
        }
        
        //create new list of integers to interact with hashmap
        List<Integer> list = new ArrayList<Integer>();
        list.add(m);
        list.add(n);
        Collections.sort(list);
        
        //if the numbers  are not found in hashmap
        if(map.get(list) == null){
            //run recursive relation to calculate the result, add it into the hashmap
            map.put(list , uniquePaths(m-1 , n) + uniquePaths(m, n-1));
            return map.get(list);
        }
        else{
            //else, just simply return the result
            return map.get(list);
        }
        
            }
}
