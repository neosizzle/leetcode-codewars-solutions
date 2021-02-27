// 3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
// Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
// threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
// composed of several stacks and should create a new stack once the previous one exceeds capacity.
// SetOfStacks. push () and SetOfStacks. pop() should behave identically to a single stack
// (that is, pop ( ) should return the same values as it would if there were just a single stack). 

import java.util.ArrayList;

public class MyClass {
    public static void main(String args[]) {
      SetOfStacks stack = new SetOfStacks();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(1);
      stack.push(2);
      stack.push(3);
    
  

 
      stack.set.get(2).printStack();
      //System.out.println(stack.set.size());
    }
}

 class StackNode{
        int data;
        StackNode next = null;
        public StackNode(int d){
            data = d;
        }
    }


class SetOfStacks{
    
    ArrayList<Stack> set = new ArrayList<>();
    Stack currentStack = null;    
    int limit = 3;
    int count = 0;
    
    void push(int data){
        
        count++;
        
        //first node
        if(currentStack == null){
            
            //create new stack and append node
            currentStack = new Stack();
            currentStack.push(data);
            
            //add stack to set
            set.add(currentStack);
            
            
            return;
            
        }
        
        //count reached limit
        if(count > limit){
        //create new stack 
        currentStack = new Stack();
        
        //add stack to set
        set.add(currentStack);
        
        //push data to new stack
        currentStack.push(data);
        
        //reset count
        count = 1;
        return;
        }
        
        
        
        //still in limit
        currentStack.push(data);
        
        return;

        
        
    }
    
    
    void pop(){
        
        //change currentList if the currentlist is empty
        if(currentStack.top == null){
            currentStack = set.get(set.size()-2);
            count = limit;
        }
    
            //pop currentlist
            currentStack.pop();
            count --;
    }
    
}

class Stack{
    StackNode top = null;
    
    //declairing seperation limit
    int limit = 2;

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
                return;
            }
            current.next = top;
            top = current;
            
       
    
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
    
    
    
}

