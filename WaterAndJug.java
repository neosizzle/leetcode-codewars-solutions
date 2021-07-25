//https://leetcode.com/problems/water-and-jug-problem/
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        //check for impossible solutions
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        
        //imagine two jugs, every operation is either:
        //add jug1Capacity or
        //minus jug1Capacity or 
        //add jug2Capacity or 
        //minus jug2Capacity for the total capacity in both jugs
        //
        //as long as the total capacity of both the jugs are == target, we have a solution
        //we can generate all possibilities of targetCapacity by the operations above, and
        //return true if the capacity matches target
        
        //since we will generate more possibilites using the previous possiblities, we 
        //will have a tree like data structure.
        //we traverse this tree using bfs as well as processing
        //0 is out initial value
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        //said operations
        int[] operations = {jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity};
        
        //hashet to prevent loops and double calculations
        HashSet<Integer> generated = new HashSet<Integer>();
        generated.add(0);
        
        int curr;
        int evaluated;
        //while our queue is not empty, do sth
        while (!q.isEmpty())
        {
            curr = q.remove();
            if (curr == targetCapacity) return true;
            
            //try to do all the operations and add to tree if they are valid
            for(int i : operations)
            {
                evaluated = curr + i;
                if (evaluated == targetCapacity) return true;
                if(evaluated < 0 || evaluated > jug1Capacity + jug2Capacity) continue;
                if(!generated.contains(evaluated))
                {
                    q.add(evaluated);
                    generated.add(evaluated);
                }
            }
            
        }
        
        //return false if no target found
        return false;
    }
}
