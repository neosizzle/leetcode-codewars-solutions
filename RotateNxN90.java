//rotate 2d array 90 degrees clockwsise (N X M) OR (N^2)
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        int [] [] a = {
            {1,2,3,4},
            {1,2,3,4},
            {1,2,3,4}
          
          
            
        };
        int[][]b = new int[4][3]; 
        
        int currentRow = 0;
        int currentCol = 0;
        
        //traverse through each row of matrix
        while(currentRow < a.length){
            //travese through each column for a row
            while(currentCol < a[currentRow].length){
                //place current index into b after rotation
                b[currentCol][a.length -1- currentRow] = a[currentRow][currentCol];
                currentCol++;
            }
            
            currentRow++;
            currentCol = 0;
        }
        
        for(int[] i : b){
            System.out.println(Arrays.toString(i));
        }
      
    }
}