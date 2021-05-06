//https://leetcode.com/problems/keys-and-rooms/
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //create hashset to store all the visited rooms
        HashSet<Integer> visited = new HashSet<Integer>();
        
        
        //stack to store accessible rooms for dfs
        Stack<Integer> roomsStk = new Stack<>();  
        //add room 0 to visited and stack because we have access to it 
        roomsStk.add(0);
        visited.add(0);
        
        //while we still have rooms to access / stack is not empty
        while(!roomsStk.empty()){
            //we want to get the keys in that room
            List<Integer> keys = rooms.get(roomsStk.pop());
            
            //since we have the ksys in that room, those rooms will be accessible
            //and should be added into our hashset
            for(int key : keys){
                //add non visited rooms into our accessible stack and visit said room
                if(!visited.contains(key)){
                    visited.add(key);
                    roomsStk.add(key);
                }
            }
            
            
        }
        
        
    
        
        return  visited.size() == rooms.size();
        
    }
}
