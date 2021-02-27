import java.util.Arrays;
public class PermutationCheck{

     public static void main(String []args){
        String x = "a22bc";
        String y = "cb2a";
        
        char[] yArr = y.toCharArray();
        char[] xArr = x.toCharArray();
        Arrays.sort(xArr);
        Arrays.sort(yArr);
        
         if(xArr.length != yArr.length){
            System.out.println("false");
            return;
        } 
        
        System.out.println(Arrays.toString(xArr).equals(Arrays.toString(yArr)));
        
       
        
    
       
        
        
     }
}