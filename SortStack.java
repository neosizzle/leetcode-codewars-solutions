// 3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
// an additional temporary stack, but you may not copy the elements into any other data structure
// (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty. 


import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        Stack<Integer> sortedStack = sortStack(stack);
        sortedStack.forEach(System.out::println);
      
        
    }
    
    public static Stack sortStack(Stack unsorted){
    Stack<Integer> sorted = new Stack<>();
    int temp = 0;
    
    //returns original stack of stack is empty
    if(unsorted.empty()){
        return unsorted;
    }
    
    //while the unsorted array still has elements
    while(!unsorted.empty()){
        //pop the top element at the unsorted array and assigns it to temp variable
        temp = (int)unsorted.pop();
        
        
        //compares temp with the top of sorted element
        //if temp is larger than the top of sorted elemt or sorted is empty, push it in sorted stack
        if(sorted.empty()){
            sorted.push(temp);
            
            //continue recursion
            continue;
        }
        
        
        if(temp >= sorted.peek()){
            sorted.push(temp);
            
            //continue recursion
            continue;
            
        }else{
            //temp is smaller then top element, move bigger elements back to unsorted so we can place the element at the right place
            while(temp < sorted.peek()){
                unsorted.push(sorted.pop());
                
                //if sorted array is empty, break the while loop to prevent nullpointer
                if(sorted.empty()){
                    break;
                }
                
            }
            
            //push the temp into sorted once moving has finished
            sorted.push(temp);
            continue;
        }
        
    }
    
    //return sorted stack
    return sorted;
    
}
}

