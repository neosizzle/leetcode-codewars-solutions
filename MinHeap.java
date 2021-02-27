//mean / max heap
//a complete binary tree except every child node must be smaller/bigger than parent node
//we can implement using poitners but its easier to use arrays
/**
 * Leftchild = 2 * parent index + 1 to get left child index in array
 * rightchild = 2 * parent index + 2 to get left child index in array
 * 
 * parent = (childIndex - 1)/2
 * 
 * */
 
     import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        
        MinHeap heap = new MinHeap();
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.insert(4);
        heap.insert(1);
        heap.extractRoot();
        heap.printHeap();
    }
}

class MinHeap {

    
    //declare heap as arraylist
    ArrayList<Integer> heap = new ArrayList<Integer>();
    
    //basic methods to operate with
    
    //gets left child index
    public int getLeftChildIndex(int parentIndex){
        return 2* parentIndex + 1;
    }
    
    //gets right child index
    public int getRightChildIndex(int parentIndex){
        return 2* parentIndex + 2;
    }
    
    //get parent index
    public int getParentIndex(int childIndex){
        return (childIndex - 1)/2;
    }
    
    //insert
    public void insert(int data){
        
        //adds new node to the end of the tree
        heap.add(data);
        
        //heaps up to the correct position
        heapUp(data , heap.size() - 1);
    }
    
    //extract from the root of heap
    public void extractRoot(){
        
        //overrides root node with last node 
        heap.set(0,heap.get(heap.size() - 1));
        
        //removes last node
        heap.remove(heap.size() - 1);
        
        //adds leaf node to root and heaps down to the correct position
        heapDown();
    }
    
    //print heap
    public void printHeap(){
        
        System.out.println(heap.toString());
    }
    
    //heapUp
    public void heapUp(int data, int childIndex){
        
        //System.out.println("Data = " + data + "\n Parent = " + heap.get(getParentIndex(childIndex)));
        
        while(data < heap.get(getParentIndex(childIndex))){
 
            
            //while the data is still smaller than its parent, switch places
            int temp = heap.get(getParentIndex(childIndex));
            heap.set(getParentIndex(childIndex) , data);
            heap.set(childIndex , temp);
            
            //change child index to childs parent
            childIndex = getParentIndex(childIndex);
        }
    }
    
    //heap down
    public void heapDown(){
        
        int parentIndex = 0;
        int data = heap.get(0);
        
        //while the data is bigger than its children
        while(getLeftChildIndex(parentIndex) < heap.size()){
            
            
            //switch with the smaller child
            if(heap.get(getLeftChildIndex(parentIndex)) < heap.get(getRightChildIndex(parentIndex)) && data > heap.get(getLeftChildIndex(parentIndex)) ){
                int temp = heap.get(getLeftChildIndex(parentIndex));
                
                //switch places
                heap.set(heap.get(getLeftChildIndex(parentIndex)) , data);
                
                heap.set(parentIndex, temp);
                
                //change indexes
                parentIndex = getLeftChildIndex(parentIndex);
                
            }else{
                int temp = heap.get(getRightChildIndex(parentIndex));
                
                //switch places
                heap.set(heap.get(getRightChildIndex(parentIndex)) , data);
                
                heap.set(parentIndex, temp);
                
                //change indexes
                parentIndex = getRightChildIndex(parentIndex);
            }
        }
    }
}