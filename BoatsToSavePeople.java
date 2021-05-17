//https://leetcode.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //we can carry atmost 2 people at the same time, we sohuld always try to carry 2 each iteration
        //sort the array so we can easily get the heaviest and lightest person
        Arrays.sort(people);

        int numBoats = 0;
        
        //start with 2 pointers
        int lightPointer = 0;
        int heavyPointer = people.length - 1;
        
        //while the pointers dont meet
        while(lightPointer <= heavyPointer){
            
            //if the heaviest person can be paried with the lightest person
            if(people[heavyPointer] + people[lightPointer] <= limit){
                //we pair them and we move the pointers
                ++numBoats;
                
                --heavyPointer;
                 ++lightPointer;
                
            }
            else{
                //else, we will just take the heavier person
                ++numBoats;
                
                --heavyPointer;
            }
            
            
        }
        
        
        return numBoats;
    }

}
