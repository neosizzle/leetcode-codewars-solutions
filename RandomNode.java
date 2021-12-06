//cracking the coding interview question 4.11
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    int sizesubtree;
    
    public TreeNode(int value)
    {
        val = value;
        left = null;
        right = null;
        sizesubtree = 1;
    }
    
    /*
    ** Function that creates a new node and inserts in BST in order
    ** 
    ** @param int valNew the nodes value
    ** @return void
    */
    public void insert(int valNew)
    {
        if (valNew <= val)
        {
            if (left == null)
            {
                left = new TreeNode(valNew);
            }
            else
                left.insert(valNew);
        }
        else
        {
            if (right == null)
            {
                right = new TreeNode(valNew);
            }
            else
                right.insert(valNew); 
        }
        
        sizesubtree++;
    }
    
    /*
    ** Function that returns a random node in the BST
    ** 
    ** 1. the probability of traversing left = leftsubtree size * 1/currnetsubtreesize
    ** 2. the probability of traversing right = rightsubtree size * 1/currnetsubtreesize
    ** 3. probability of picking current node is 1/ currentsubtreesize
    ** @param void
    ** @return TreeNode result
    */
    public TreeNode getRandomNode()
    {
        int leftsize;
        int randIdx;
        Random rand;
        
        leftsize = left == null ? 0 : left.sizesubtree;
        rand = new Random();
        randIdx = rand.nextInt(sizesubtree);
        if (randIdx < leftsize)
            return left.getRandomNode();
        else if (randIdx == leftsize)
            return this;
        else
            return right.getRandomNode();
    }
}


public class MyClass {
    static int getRandomValue(int min, int max)
    {
        return (int)Math.floor(max * (Math.random()) + min);
    }
    
    public static void main(String args[]) {
    
        TreeNode top = new TreeNode(5);
        top.insert(1);
        top.insert(0);
        top.insert(9);
        System.out.println(top.getRandomNode().val);
    }
}
