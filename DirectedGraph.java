import java.util.*;
//undirected and unweighted graph
public class MyClass {
    
     public static void main(String[] args) {
       Graph graph = new Graph();
       Node a = new Node('a',1);
       Node b = new Node('b',2);
       Node c = new Node('c',3);
       Node d = new Node('c',4);
       Node e = new Node('c',5);
       Node f = new Node('c',6);
       Node g = new Node('c',7);
   
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        
        graph.connect(a,b);
        graph.connect(a,c);
        graph.connect(c,b);
        graph.connect(c,e);
        graph.connect(d,b);
        graph.connect(d,c);
        graph.connect(e,d);
     
        
        //graph.printAdjacent(a);
        
        System.out.println(graph.hasPathBfs(e,a));
        
        
    }
    
}

class Node{
    ArrayList<Integer> connectedVerticesIndex = new ArrayList<Integer>();
    char data;
    int id;
    
    public Node(char d, int i){
        data = d;
        id = i;
    }
}

class Graph{
     HashMap<Integer,Node> vertices = new HashMap<Integer,Node>();
     
     //adds node
    public void addNode(char data,int id){
         vertices.put(id , new Node(data,id));
     }
     
     //adds node
     public void addNode(Node current){
         vertices.put(current.id , current);
     }
     
     //connects two nodes together directly
     public void connect(Node a, Node b){
         a.connectedVerticesIndex.add(b.id);
     }
     
     //prints node and all adjacent nodes
     public void printAdjacent(Node current){
         
         System.out.println("Current node : " + current.data);
         StringBuilder sb = new StringBuilder();
        for (Integer index : current.connectedVerticesIndex) {
            sb.append(vertices.get(index).data);
            sb.append(", ");
        }
        
        sb.insert(0 , "Adjacent Nodes : ");
        
        System.out.println(sb.toString());

         
     }
     
     //depth first search to see if there is a path between the current node and the destination
     public boolean hasPathDfs(Node current, Node destination){
         
         //return true if the current node is the destination
         if(current == destination){
             return true;
         }
         
         //return false if the node has no children
         if(current.connectedVerticesIndex.size() == 0 ){
             return false;
         }
         
         //confirmed that node has children and is not destnation
         //create visited hashset
         HashSet<Integer> visited = new HashSet<Integer>();
         
         //recursive call to serch
         return hasPathDfs(current,destination, visited);
     }
     
     public boolean hasPathDfs(Node current, Node destination, HashSet<Integer> visited){
         
         //return false if current node is visited
         if(visited.contains(current.id)){
             return false;
         }
         
         //visit node
         visited.add(current.id);
         
        //return true if the current node is the destination
         if(current == destination){
             return true;
         }
         
        //return false if the node has no children
         if(current.connectedVerticesIndex.size() == 0 ){
             return false;
         }
         
         //recursive call to each adjacent node 
         for(int childIndex : current.connectedVerticesIndex){
             //if the call returns true, returns true for this call
             if(hasPathDfs(vertices.get(childIndex),destination,visited)){
                 return true;
             }
             
         }
         
         //recursive call ends, destination not found
         return false;
     }
     
     //breath first search to see if there is a path between the current node and the destination
     public boolean hasPathBfs(Node current , Node destination){
         
         //creates node queue and visited set
         LinkedList<Integer> nodeQueue  = new LinkedList<Integer>(); 
         HashSet<Integer> visited = new HashSet<Integer>();
         
         //return false if the node has no children
         if(current.connectedVerticesIndex.size() == 0 ){
             return false;
         }
         
         //adds current node to queue
         nodeQueue.addFirst(current.id);
         
         while(!nodeQueue.isEmpty()){
             
             //return true if the current node is the destination
             if(current == destination){
                 return true;
             }
             
             //visit current node
             visited.add(current.id);
             
             //adds all children of current node in the queue
             for(int childIndex : current.connectedVerticesIndex){
                 //if the current child index is visited , ignore the child
                 if(visited.contains(childIndex)){
                     continue;
                 }
                 
                 //adds child to queue
                 nodeQueue.addFirst(childIndex);
                 
                 
             }
             
             //pop the queue to move current node
             current = vertices.get(nodeQueue.getLast());
             nodeQueue.removeLast();
             
             
         }
         
         
         //no results, return false
         return false;
     }
     
}