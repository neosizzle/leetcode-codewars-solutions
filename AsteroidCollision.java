//https://leetcode.com/problems/asteroid-collision/
class Solution {
    //loop through the entire array
    //if we see a positive asteroid, add it to stack
    //else, we stimulate the collisions
    //check for empty stack or negative elements
    public int[] asteroidCollision(int[] asteroids) {
        int i;
        Stack<Integer> stack = new Stack<>();
        
        i = 0;
        while (i < asteroids.length)
        {
            if (asteroids[i] > 0)
                stack.push(asteroids[i]);
            else
            {
                while (!stack.empty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek())
                {
                    stack.pop();
                }
                if (stack.empty() || stack.peek() < 0)
                    stack.push(asteroids[i]);
                else if (stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();
            }
            i++;
        }
        
        int[] res = new int[stack.size()];
        for(int j = stack.size() - 1; j >=0; --j)
        {
            res[j] = stack.pop();
        }
        return res;
    }
}
