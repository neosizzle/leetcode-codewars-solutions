//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        //check if the string is even length
        if(s.length() % 2 != 0){
            return false;
        }
        
        //create a hashmap to store the closing paretheses
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(' , ')');
        map.put('[' , ']');
        map.put('{' , '}');
        
        //create a stack to store open brackets
        Stack<Character> charStack = new Stack<>();
        
        //traverse through every character in the string
        for(int i = 0; i < s.length(); ++i){
            
            char currentChar = s.charAt(i);
            
            //if the current char is an open bracket
            if(map.containsKey(currentChar)){
                //add the current char into the stack
                charStack.push(currentChar);
                continue;
            }
            //else , compare the current char with the top of the parenthesis stack
            
            //check if stack is empty. if yes, return false
            if(charStack.isEmpty()){
                return false;
            }
            
            if(currentChar != map.get(charStack.pop())){
                //if they dont match, return false
                return false;
            }
            
        }
        
        
        return charStack.isEmpty();
    }
}
