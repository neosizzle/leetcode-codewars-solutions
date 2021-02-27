import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      int[]arr = {1,2,3,4,5,6,7};
      
      Node root = convertArrayToBST(arr);
      
      System.out.println(root.leftChild.rightChild.data);

      
    }
    
    public static Node convertArrayToBST(int[] arr){
        
        //if the array has only 1 element
        if(arr.length < 2){
            
            //create new node with the array data and retrun said node
            Node node = new Node(arr[0]);
            return node;
        }
        
        //split array into 2 parts
        int mid = arr.length/2;
        
        int[]left = new int[mid];
        int[]right = new int[arr.length - mid];
        
        //add elements into new arrays
        for(int i = 0; i < left.length; i++){
            left[i] = arr[i];
        }
        
        for(int i = 0; i < right.length; i++){
            right[i] = arr[mid + i];
        }
        
        
        //recursive call to both left and right arrays until it returns with 1 node
        Node leftChild = convertArrayToBST(left);
        Node rightChild = convertArrayToBST(right);
        
        //after the calls retrun, create new node with the two children
        Node parent = new Node(arr[arr.length/2]);
        parent.leftChild = leftChild;
        parent.rightChild = rightChild;
        
        //return parent node
        return parent;

        
    }
}

class Node {
    int data;
    Node leftChild = null;
    Node rightChild = null;
    
    public Node(int d){
        data = d;
    }
}

