//https://leetcode.com/problems/sort-characters-by-frequency/
class Solution {
    public String frequencySort(String s) {
        //create a hashmap to store all the characters and frequencies
        HashMap<Character , Integer> chars = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            
            chars.put(s.charAt(i) , chars.getOrDefault(s.charAt(i) , 0) + 1);
            
        }
                
        //create a maxheap to store all the frequencies
        PriorityQueue<Character> maxPQ = new PriorityQueue<>((a,b) -> chars.get(b) - chars.get(a));
        maxPQ.addAll(chars.keySet());
       
        StringBuilder res = new StringBuilder();
        
        //while the heap is not empty, do stuff
        while(!maxPQ.isEmpty()){
           //get the most frequent char from the max heap
            char current = maxPQ.poll();
            
            //append it to the string n times where n is the frequency stored in hashmap
            for(int i = 0; i < chars.get(current); ++i){
                res.append(current);
            }
        }
        
         return res.toString();
    }
}
