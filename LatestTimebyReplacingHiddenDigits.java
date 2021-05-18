//https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
class Solution {
    public String maximumTime(String time) {
        //iterate through each character of time
        for(int i =0; i < time.length(); ++i){
            
            //call helper function if the characters is a missing character
            if(time.charAt(i) == '?'){
                time = replaceChar(i , time);
            }
            
        }
        
        return time;
    }
    
    public String replaceChar(int index , String time){
        StringBuilder newTime = new StringBuilder(time);
        
        //check for each possible case
        if(index == 0){
            //index == 0, check if next value is more than 3
            if(Character.getNumericValue(time.charAt(index + 1)) > 3){
                //if yes, repalce by 1
                newTime.setCharAt(index, '1');
            }
            else{
                            
                //else, replace by 2
                newTime.setCharAt(index, '2');
                
            }
            
            //return new time
            return newTime.toString();
        }
        
        if(index == 1){
            //if index == 1, check for prev value
            if(Character.getNumericValue(time.charAt(index - 1)) < 2){
                //if yes, repalce by 9
                newTime.setCharAt(index, '9');
            }
            else{
                            
                //else, replace by 3
                newTime.setCharAt(index, '3');
               
            
        }
            
            //return new time
            return newTime.toString();
        
    }
        
        if(index == 3){
            newTime.setCharAt(index, '5');
            
            //return new time
            return newTime.toString();
        }
        
        if(index == 4){
            newTime.setCharAt(index, '9');

            //return new time
            return newTime.toString();
        }
        
        //return new time
        return newTime.toString();
}
    
}
