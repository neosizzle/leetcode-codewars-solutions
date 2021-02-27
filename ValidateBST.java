import java.util.Queue;
import java.util.LinkedList;

public class MyClass {
    public static void main(String args[]) {
      BinaryTree tree = new BinaryTree(); 
      tree.root = new Node(7);
      tree.root.leftChild = new Node(4);
      tree.root.rightChild = new Node(9);
      tree.root.leftChild.leftChild = new Node(1);
      tree.root.leftChild.rightChild = new Node(3);
      tree.root.rightChild.leftChild = new Node(5);
      tree.root.rightChild.rightChild = new Node(7);
      
      boolean a = tree.validateBST(tree.root);
      System.out.println(a);
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
    
    public boolean validateBST(Node current){
        //returns if current node is null
        if(current == null){
            return false;
        }
        
        //create list for storing visited nodes data
        LinkedList<Integer> nums = new LinkedList<Integer>();
  
        
        //start in-order traversing with nums
        return validateBST(current, nums);
        

        
        
    }
    
    public boolean validateBST(Node current, LinkedList<Integer> nums){
        
        //exit condition
        if(current == null){
            return true;
        }
        
        //traverse left child and visit current node and returns false of there is a false return
        if(!validateBST(current.leftChild, nums)){
            return false;
        }
        
        
        //add itself to nums if first leaf
        if(nums.size() == 0){
            nums.add(current.data);
            return true;
        }
        
        
        //if the comparison fails, return false
        if(current.data < nums.getLast()){
            return false;
        }
        

        //add current data into nums
        nums.addLast(current.data);
        
        //traverse right child 
        if(!validateBST(current.rightChild,nums)){
            return false;
        }
        
        //return true if no false returns
        return true;
        
        
    }
    
}