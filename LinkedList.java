import java.util.*;
public class MyClass {
    public static void main(String args[]) {
    LinkedList circularList = new LinkedList();
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);

    
    circularList.head = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = d;
    
    System.out.println(circularList.findLoopBeginning().data);
    

    

        
    }
    
    //link list sum
        //reversed
       static int reverseSum(LinkedList list1, LinkedList list2){
            int firstNum = 0;
            Node current1 = list1.head;
            
          
            
            
            for(int i = 0; current1 != null; current1 = current1.next,i++){
                firstNum += current1.data * (Math.pow(10,i));
                
            }
            
            int secNum = 0;
            Node current2 = list2.head;
            for(int i = 0; current2 != null; current2 = current2.next,i++){
                secNum += current2.data * (Math.pow(10,i));
                
            }
            
        
            return firstNum + secNum;
        }
        
        
        //forward
        static int forwardSum(LinkedList list1, LinkedList list2){
            float firstNum = 0;
            Node current1 = list1.head;
            
          
            
            
            for(int i = 0; current1 != null; current1 = current1.next,i++){
                firstNum += current1.data * 0.1;
                firstNum *= 10;
                
            }
            
            float secNum = 0;
            Node current2 = list2.head;
            for(int i = 0; current2 != null; current2 = current2.next,i++){
                secNum += current2.data * 0.1;
                secNum *= 10;
                
            }
            
        
            return (int) (firstNum + secNum);
        }
        
        //checks if a linkedlist is a palindrome
        static boolean isPalindrome(LinkedList list){
            //use runner teqnique
            //the fast one goes twice the speed of the slow one. when the fast one ends, which means the slow pointer is at the middle
            Node fast = list.head;
            Node slow = list.head;
            
            //stack for containing nubmers
            Stack<Integer> numbers = new Stack<>();
            while(fast != null && fast.next!=null){
                //add data to stack until the middle of the list
                numbers.push(slow.data);
                slow = slow.next;
                fast = fast.next.next;
            }
            
            //list has odd numbers causing the exact middle to not get added into the stack.
            //skip the slow pointer by 1 space
            if(fast!= null){
                slow = slow.next;
            }
            
            //compare the data 
            while(slow!=null){
                int top = numbers.pop().intValue();
                if(top != slow.data){
                    return false;
                }
                slow = slow.next;
            }
            
            return true;
            
        }
        
        //checks if a linked list is intersecting
        static Node isIntersect(LinkedList list1, LinkedList list2){
            //if its not an intersected linkedlist, the tails would not be the same.
            if(list1.tail != list2.tail){
                System.out.println("Does not intersect");
                return null;
            }
            
            //lists do intersect, compare sizes so we can ignore the rest of the linkedlist that is irrelevant
            int size1 = list1.getSize();
            int size2 = list2.getSize();
            
            LinkedList longList;
            LinkedList shortList;
            
            if(size1 >= size2){

                longList = list1;
                shortList = list2;
            }else{
                longList = list2;
                shortList = list1;
            }
            
            
            
            //difference in lists obtained, now we have to cut the long list into the appropriate size.
            Node currentLong = longList.head;
            Node currentShort = shortList.head;
            for(int diff = Math.max(size1 , size2) - Math.min(size1 , size2); diff > 0; diff--){
                currentLong = currentLong.next;
            }
            
            //look for the intersecting node
            while(currentLong != null && currentShort != null){
                if(currentLong != currentShort){
                    currentLong = currentLong.next;
                    currentShort = currentShort.next;
                    continue;
                }
                return currentLong;
            }
            
            //something goes wrong
            System.out.println("error");
            return null;
            
          
                
            }
        }



//node class and constructor 
class Node{
    int data;
    Node next = null;
    
    public Node(int d){
        data = d;
    }
    
    
}


//linked list class that contains the head and tail node of the list, as well as methods 
class LinkedList{
        Node head = null;
        Node tail = null;
        
        
        //addpend method, adds node to tail
        void append(int d){
            Node node = new Node(d);
            if(head == null){
                head = node;
                tail = node;
                return;
            }
            
            tail.next = node;
            tail = node;
            
            
            
        }
        
        //prepend method, adds node to head
        void prepend(int d){
            Node node = new Node(d);
            if(head == null){
                head = node;
                tail = node;
                return;
            }
            
            node.next = head;
            head = node;
        }
        
        //printlist method, prints the list
        void printList(){
            if(head == null){
                System.out.println("EMpty");
                return;
            }
            
            Node current = head;
            
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
            
        }
        
        //get size method, gets the size of the list
        int getSize(){
            int count = 1;
            if(head == null){
                return 0;
            }
            
            Node current = head;
            while(current.next != null){
                count++;
                current = current.next;
            }
            
            return count;
        }
        
        //delete value at index parameter
        void deleteIndex(int index){
            
            Node current = head;
            if(current == null){
                System.out.println("List is empty");
                return;
            }
            
             if(index <= 0){
                head = current.next;
                return;
            }
            
            //current is the node before the deleted node **
            for(int i = 0; i <index-1; i++){
                current = current.next;
            }
           
            current.next = current.next.next;
        }
        
       /**
        * INTERVIEW QUESIONS
        * */
        
        //RemoveDupes
        void removeDupes(){
            //creates hashset to store existing ints in linked list
            HashSet<Integer> nums = new HashSet<Integer>();
            Node current = head;
            
            //add the head data into the set cuz we use compare next data
            nums.add(current.data);
            while(current.next!= null){
                
                //if next number exists in set, remove next number
                if(nums.contains(current.next.data)){
                    if(current.next == tail){
                        current.next = null;
                        tail = current;
                        continue;
                    }
                     current.next = current.next.next;
                     continue;
                }else{//if not, add next number to set
                    nums.add(current.next.data);
                }
                
                current = current.next;
            }
        }
        
        //kth from last element
        int fromLast(int k){
            Node current = head;
            
            //calculate how many steps forward it needs to take
            int steps = this.getSize()-k;
            for(int i = 0; i<steps; i++){
                current = current.next;
            }
            
            return current.data;
        }
        
        //Delete Middle Node (only works when i hace diret acces to that node)
        //Delets any node that is in the middle of the linked list. (Any node that is not the head or tail)
        boolean deleteMidNode(Node n){
            //checks if its null or last node
            if(n == null || n.next == null){
                System.out.println("Delete fail");
                return false;//failure
            }
            
            //override the current data and pointer with next nodes data and pointer
            Node next = n.next;
            n.data = next.data;
            n.next = next.next;
            
            return true;
        }
        
        //find the beginning of a loop in a circular linked list
        //floyds algorithm says that the distance between the meeting point of a x speed and 2x speed pointer is equals to the distance of the prelooped paer modular the length of the loop
        //thus, when the pointers meet, bring one of them back to the head and traverse them in the same speed. they should meet again at the beginning of the loop
        Node findLoopBeginning(){
            //runner teqnique
            Node slow = this.head;
            Node fast = this.head;
            do{
                slow = slow.next;
                fast = fast.next.next;
            }while(slow != fast);
            
            //pointers meet, move one pointer back to head node
            slow = this.head;
            //traverse the pointers at the same speed
            do{
                slow = slow.next;
                fast = fast.next;
            }while(slow != fast);
            //they once meet again at the beginning of the loop
            return slow;
        }
        
        
        
        
        
}