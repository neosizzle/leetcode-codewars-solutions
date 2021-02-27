// 4.6 Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
// binary search tree. You may assume that each node has a link to its parent. 

import java.util.Queue;
import java.util.LinkedList;

public class MyClass {
    public static void main(String args[]) {
      BinaryTree tree = new BinaryTree(); 
      tree.root = new Node(7);
      tree.root.leftChild = new Node(4);
      tree.root.rightChild = new Node(9);
      tree.root.leftChild.leftChild = new Node(1);
      tree.root.leftChild.rightChild = new Node(5);
      tree.root.rightChild.leftChild = new Node(8);
      tree.root.rightChild.rightChild = new Node(10);
      
      Node a = tree.findInOrderSuccessor(tree.root.leftChild.rightChild = new Node(5));
      System.out.println(a.data);
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
    
    public Node findInOrderSuccessor(Node current){
        //find next visited node in in-order traversal of BST (left child -> parent -> right child)
        
        //case 1 : Node has right subtree
        //next visited node should be minimum value at right subtree
        if(current.rightChild != null){
            
            current = current.rightChild;
            
            //moves current pointer to as left as possible, towards the minimum of subtree
            while(current.leftChild != null){
                current = current.leftChild;
            }
            
            return current;
        }
        
        
        //case 2 : Node has no right subtree
        Node successor = null;
        Node ancestor = root;
        
        //walk from the root of the tree towards the destination and gets its first ancestor of left subtree
        while(ancestor != current){
            //walk left if the current data is less than destination data
            if(current.data < ancestor.data){
                
                //move succesor pointer to left
                successor = ancestor;
                ancestor = ancestor.leftChild;
            }else{
                //walk right if the current data is more than destination data
                ancestor = ancestor.rightChild;
                
                //successor stays in place because it needs to point to the first ancestor of left subtree
            }
            
        }
        
        //return successor
        return successor;
        
    }
    
}