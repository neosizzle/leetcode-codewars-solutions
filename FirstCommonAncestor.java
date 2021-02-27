// 4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor
// of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
// necessarily a binary search tree

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
      
      Node p = tree.root.leftChild.rightChild;
      Node q = tree.root.rightChild.leftChild;
      
      
      Node hmm = tree.findAncestor(tree.root,p,q);
      System.out.println(hmm.data);
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
    
    //helper method that returns true if child exist in subtree
    public boolean cover(Node current ,Node p, Node q){
        
        
        //destination node found
        if(current == p || current == q){
            return true;
        }
        
        
        //leaf node reached, exit case
        if(current == null){
            return false;
        }
        
        //recursive call to left and right subtree
        boolean leftRes = cover(current.leftChild , p ,q);
        boolean rightRes = cover(current.rightChild , p ,q);
        
        
        //return the or for both results
        return(leftRes || rightRes);
        
    }
    
    public Node findAncestor(Node current, Node p, Node q){
        
        
        //return null if current node is p, q or null. No common parent.
        if(current == null){
            return null;
        }
        
        //start determining which subtree the destination nodes are
        boolean isAtLeft = cover(current.leftChild , p, q);
        boolean isAtRight = cover(current.rightChild , p, q);
        
        
        //case 1 : if both of them are true, the current node is the common ancestor.
        if(isAtLeft && isAtRight){
            return current;
        }
        
        //case 2 : if both return false, return null because there is no such child
        if(!isAtLeft && !isAtRight){
            return null;
        }
        
        //case 3 : you child is p or q but ther are on the same side. Current node is common ancestor
        
        //determine which child to look at
        Node nextChild = isAtLeft? current.leftChild : current.rightChild;
        
        //if the next child is p or q, current node is common ancestor
        if(nextChild == p || nextChild == q){
            return current;
        }
        
        
        //the child is deeper within the tree, recurse with nextChild and return the result
        return findAncestor(nextChild, p, q);
    }
}