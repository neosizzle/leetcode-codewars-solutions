//https://leetcode.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>();//hashmap used for mapping sorted strings to groups
        
        //traverse array linearly
        for(String str : strs){
            
            //sort the string by its chars
            char[] current = str.toCharArray();
            Arrays.sort(current);
            String sorted = new String(current);
            
            //if hashmap does not have the sorted string as key,
            // create a key and add current string to value
            if(!map.containsKey(sorted)){
                List<String> temp = new ArrayList();
                temp.add(str);
                map.put(sorted , temp);
            }
            else{
                //hashmap has the key,append current string to its value in hashmap
                List<String> temp = map.get(sorted);
                temp.add(str);
                map.put(sorted , temp);
                
            }
            
            
        }
        
        //loop though hashmap kesy and append result to result list
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            groupAnagrams.add(entry.getValue());
        }
        
        return groupAnagrams;
        
        
    }
}
