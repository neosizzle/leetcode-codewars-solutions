// 4.7 Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
// projects, where the second project is dependent on the first project). All of a project's dependencies
// must be built before the project is. Find a build order that will allow the projects to be built. If there
// is no valid build order, return an error.
// EXAMPLE
// Input:
// projects: a, b, c, d, e, f
// dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// Output: f, e, a, b, d, c 

import java.util.*;

//topological sort
public class MyClass {
    public static void main(String args[]) {
    Graph graph = new Graph();
    
    char[] arr = {'a' , 'b', 'c', 'd', 'e', 'f','g'};
    
    ProjectNode[] projects = graph.createProjects(arr);
    ProjectNode[][] dependencies = {{projects[5], projects[0]},{projects[5],projects[1]},{projects[5],projects[2]},{projects[2],projects[0]},{projects[1],projects[4]}};
    graph.connectDependencies(dependencies);
    
    
    Stack<ProjectNode> stack = graph.buildOrder(projects);
    for(ProjectNode n : stack){
        System.out.print(n.data + ", ");
    }
    
    
    }
}

class ProjectNode{
    //declare state variables 
    //complete - visited, processing - traversed but not visited, blank - not traversed and not visited
    public enum State {COMPLETE, PROCESSING,BLANK};
    
    //sets default state to blank
    public State state = State.BLANK;
    
    //get state
    public State getState() { return state; }
    
    //set state
    public void setState(State s){state = s;}
    
    int id;
    char data;
    ArrayList<Integer> children = new ArrayList<Integer>();
    
    //constructor
    public ProjectNode(char d,int i){
        id = i;
        data = d;
    }
    
}

class Graph{
     HashMap<Integer,ProjectNode> vertices = new HashMap<Integer,ProjectNode>();
     //ArrayList<ProjectNode> vertices = new ArrayList<ProjectNode>();
     
     //adds node
    public void addProjectNode(char data,int id){
        vertices.put(id , new ProjectNode(data , id));
     }
     
     //adds node
     public void addProjectNode(ProjectNode current){
         vertices.put(current.id , current);
     }
     
     //connects two nodes together directly
     public void connect(ProjectNode a, ProjectNode b){
         a.children.add(b.id);
     }
     
     //prints node and all adjacent nodes
     public void printAdjacent(ProjectNode current){
         
         System.out.println("Current node : " + current.data);
         StringBuilder sb = new StringBuilder();
        for (Integer index : current.children) {
            sb.append(vertices.get(index).data);
            sb.append(", ");
        }
        
        sb.insert(0 , "Adjacent Nodes : ");
        
        System.out.println(sb.toString());

         
     }
     
     //builds graph given dependencies array
     public void connectDependencies(ProjectNode[][] dependencies){
        for(ProjectNode[] project : dependencies){
            connect(project[0],project[1]);
        }
     }
     
     //creates project nodes and add them into vertices given a char array and return a projectNode array
     public ProjectNode[] createProjects(char[]projects){
         
         ProjectNode[] arr = new ProjectNode[projects.length];
         int j = 0;
         
         for(char d : projects){
             
             //creates node
             ProjectNode n = new ProjectNode(d,j);
             //adds node in vertices list
             addProjectNode(n);
             //adds node is array
             arr[j] = n;
             //increment
             j++;
         }
         
         j = 0;
         return arr;
         
         
     }
     
     //build order method. returns a stack of corrent build order
     public Stack<ProjectNode> buildOrder(ProjectNode[] projects){
         //creates stack
        Stack<ProjectNode> stack = new  Stack<ProjectNode>();
        for(ProjectNode project : projects){

            //stact recursion only on blank nodes
            if(project.getState() == ProjectNode.State.BLANK){
                //start recursion
                if(!buildOrderDFS(project,stack)){
                    System.out.println("Cycle detected!");
                    return null;
                }
            }

            
        }

        return stack;
     } 
     

     //recursive dfs method
     public boolean buildOrderDFS(ProjectNode n, Stack<ProjectNode> stack){


        if(n.getState() == ProjectNode.State.PROCESSING){
            return false; // cycle detected
        }


        //only start further recursion if current node is blank(not traversed and not visited)
        if(n.getState() == ProjectNode.State.BLANK){

            //set current node to processing
            n.setState(ProjectNode.State.PROCESSING);

            //recurse through every child of the node
            for(int childrenIndex : n.children){

                //return false if cycle detected
                if(!buildOrderDFS(vertices.get(childrenIndex), stack)){
                    return false;
                }

            }
            
            
             //above statement exited, recursion callback
             //set state to completed
            n.setState(ProjectNode.State.COMPLETE);
                
            //add node to stack
            stack.push(n);
        }

       
       
            
            
        //node is in completed state, simply return true
        return true;
     }
}