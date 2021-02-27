public class MyClass {
    public static void main(String args[]) {
      Queue queue = new Queue();
      queue.add(0);
      queue.add(1);
      queue.add(2);
      queue.add(3);
      
      
      queue.printQueue();
    }
}

class QueueNode{
    int data;
    QueueNode next = null;
    public QueueNode(int d){
        data = d;
    }
}

class Queue{
    QueueNode head = null;
    QueueNode tail = null;
    
    void add(int d){
        QueueNode node = new QueueNode(d);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
        
    }
    
    void remove(){
        if(head == null){
            System.out.println("Empty queue");
            return;
        }
        
        head = head.next;
    }
    
    void printQueue(){
        QueueNode current = head;
        if(head == null){
            System.out.println("EMpty queue");
            return;
        }
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    int peek(){
        return head.data;
    }
    
}