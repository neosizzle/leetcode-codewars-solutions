// 4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
// this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
// node never differ by more than one. 

import java.util.Queue;
import java.util.LinkedList;

public class MyClass {
    public static void main(String args[]) {
      BinaryTree tree = new BinaryTree(); 
      tree.root = new Node(1);
      tree.root.leftChild = new Node(2);
      tree.root.leftChild.leftChild = new Node(4);
      tree.root.leftChild.rightChild = new Node(5);
      tree.root.rightChild = new Node(3);
      tree.root.rightChild.leftChild = new Node(6);
      tree.root.rightChild.rightChild = new Node(6);
      tree.root.rightChild.rightChild.rightChild = new Node(6);
      tree.root.rightChild.rightChild.rightChild.rightChild = new Node(6);
      
      int leftSubDepth = tree.maxDepth(tree.root.leftChild);
      int rightSubDepth = tree.maxDepth(tree.root.rightChild);
      
     if(Math.max(leftSubDepth,rightSubDepth) - Math.min(leftSubDepth,rightSubDepth) >= 2){
         System.out.println("Unbalanced");
     }else{
         System.out.println("balanced");
     }
    }
}

class Node{
    public int data;
    public Node leftChild;
    public Node rightChild;
    
    public Node(int d){
        data = d;
        leftChild = rightChild = null;
    }
    
}

class BinaryTree{
    public Node root;
    
    public void depthFirstTraversal(Node current){
        //return if current node is null
        if(current == null){
            return;
        }
        
        //recursive call to traverse the left node
        depthFirstTraversal(current.leftChild);
        
        
        //recursive call to traverse the right node
        depthFirstTraversal(current.rightChild);
        
        //visit node before ending execution
        visit(current);
    };
    
    public void breathFirstTraversal(Node current){
        Queue<Node> queue = new LinkedList<>();
        
        if(current == null){
            return;
        }
        
        //current is not a null node
        while(current!=null){
            //visit the current node
            visit(current);
            
            //enqueue its children
            if(current.leftChild != null){
                queue.add(current.leftChild);
            }
            if(current.rightChild != null){
                queue.add(current.rightChild);
            }
            
            //sets current node to queue dequeue
            current = queue.remove();
        }
        
        
        
    }
    
    public void visit(Node n){
        System.out.println(n.data);
        return;
    }
    
    public int maxDepth(Node current){
        // System.out.println("cur length : "+currentLength);
        // System.out.println("max length : "+maxLength + "\n");
        
        
        
        //depth first traversal
        //return if current node is null
        if(current == null){
            return 0;
        }
        
        //traverse both left and right subtrees and get their depth as integer
        int leftDepth = maxDepth(current.leftChild);
        int rightDepth = maxDepth(current.rightChild);

        //after getting both depths, return the larger depth + 1 to parent 
        if(leftDepth > rightDepth){
            return(leftDepth + 1);
        }else{
            return (rightDepth + 1);
        }
        
        
    }
}