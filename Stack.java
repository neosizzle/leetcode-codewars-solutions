public class MyClass {
    public static void main(String args[]) {
      Stack stack = new Stack();
      stack.push(1);
      stack.push(2);
      stack.push(3);
 
      System.out.println(stack.getMin().data);
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

