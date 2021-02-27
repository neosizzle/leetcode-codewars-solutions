//3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. 

public class MyClass {
    public static void main(String args[]) {
    MyQueue queue = new MyQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    
    queue.dequeue();
    
    queue.printQueue();
    }
}

 class StackNode{
        int data;
        StackNode next = null;
        public StackNode(int d){
            data = d;
        }
    }

class Stack{
    StackNode top = null;
    StackNode min = null;

    void printStack(){
            StackNode current = top;
            if(current == null){
                System.out.println("Empty stack");
                return;
            }
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }
        
    void push(int data){
            StackNode current = new StackNode(data);
            if(top == null){
                top = current;
                min = current;
                return;
            }
            current.next = top;
            top = current;
            
            //check for min
            if(min == null || current.data <= min.data){
                min = current;
            }
    
        }
        
    void pop(){
        top = top.next;
    }
    
    int peek(){
        return top.data;
    }
    
    boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }
    
    
    /**
     * CODING INTERVIEW QUESTIONS
     * 
     *
     * */
    
    
    //A method that returns the smallest value of the stack. Should be O(1) time
    //instead of going for a search approach,simply keep track of the minimum node
    StackNode getMin(){
        return min;
    }
    
    
}

class MyQueue{
    Stack original = new Stack();
    Stack process = new Stack();
    
    //enqueue method remains the same as push with a stack(add elements to the top)
    void enqueue(int data){
        original.push(data);
    }
    
    //dequeue however, need to remove from the bottom of the stac
    void dequeue(){
        //no nodes
        if(original.top == null){
            System.out.println("Empty MyQueue");
            return;
        }
        
        
        //reverse the stack and pop from the reversed stack
        StackNode current = original.top;
        while(current != null){
            //push the first elemement into the bottom of the revered stack
            process.push(original.peek());
            original.pop();
            
            //traverse stack
            current = current.next;
        }
        
        //pop from the revered stack
        process.pop();
        
        //revert the stack back to its orignial form
        current = process.top;
        while(current != null){
            original.push(process.peek());
            process.pop();
            
            //traverse stack
            current = current.next;
        }
    }
    
    //print myQueue
    void printQueue(){
        original.printStack();
    }
}
