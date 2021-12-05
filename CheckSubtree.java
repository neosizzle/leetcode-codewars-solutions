//Cracking the coding interview question 4.10

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MyClass {
    
    /*
    ** Recursive function that gets the string representation in a tree with post order traversal
    ** 
    ** @param TreeNode node
    ** @param StringBuilder str()
    ** @return void
    */
    public static void getStrRep(TreeNode node, StringBuilder str)
    {
        //base case, current node is null
        if (node == null)
        {
            // append X into str and return
            str.append('X');
            return ;
        }
        
        //visit current node, recurse left then recurse right
        str.append(node.val);
        getStrRep(node.left, str);
        getStrRep(node.right, str);
    }
    
    public static void main(String args[]) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        
        StringBuilder sb1 = new StringBuilder();
        getStrRep(one, sb1);
        String t1str = sb1.toString();
        
        TreeNode seven = new TreeNode(7);
        three.right = seven;
        StringBuilder sb2 = new StringBuilder();
        getStrRep(one, sb2);
        String t2str = sb2.toString();
        
        
        System.out.println(t1str.indexOf(t2str));
        
    }
}
