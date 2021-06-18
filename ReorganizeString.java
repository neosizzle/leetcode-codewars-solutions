//https://leetcode.com/problems/reorganize-string/submissions/
class Solution {
    public String reorganizeString(String s) {
        
        StringBuilder res = new StringBuilder();
        
        //use a hashmap to record each occurence of a character
        HashMap<Character, Integer> occurences = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            occurences.put(s.charAt(i) , occurences.getOrDefault(s.charAt(i) , 0) + 1);
        }
        
        //use a max heap to keep track of the character with most occurences
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a , b) -> occurences.get(b) - occurences.get(a));
        
        // Iterating over keys only
        for (Character key : occurences.keySet()) {
            maxHeap.add(key);
        }

        //while the max heap still has at least one character
        while(maxHeap.size() > 1){
            //get the most freq character and append to string
            Character mostFreq = maxHeap.poll();
            
            //get the 2nd most freq character and append. if cant get, return empty string
            Character secFreq = maxHeap.poll();
            
            res.append(mostFreq);
            res.append(secFreq);
                        
            //decrement the occurence of thaose characters in hashmap
            occurences.put(mostFreq , occurences.get(mostFreq) - 1);
            occurences.put(secFreq , occurences.get(secFreq) - 1);
            
            //add the characters back to the heap when done if they still have occurences
            if(occurences.get(mostFreq) > 0){
                maxHeap.add(mostFreq);
            }
            
            if(occurences.get(secFreq) > 0){
                maxHeap.add(secFreq);
            }
            
        }
        
        //after the loop is done, checkif there are still any remaining characters
        if(!maxHeap.isEmpty()){
            Character last = maxHeap.poll();
            
            //if the remaining characters has still more than 1 occurence
            if(occurences.get(last) > 1){
                //we cant organize, return empty string
                return "";
            }else{
                //else, add to res
                res.append(last);
            }
        }
        
        
        
        return res.toString();
        
    }
}
