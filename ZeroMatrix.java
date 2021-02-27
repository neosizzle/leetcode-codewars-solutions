//changes the whole row and column into 0 when a 0 is found in a mXn matrix
import java.util.Arrays;
import java.util.ArrayList;
public class ZeroMatrix {
    public static void main(String args[]) {
      int [][] matrix = {
          {1,2,3,4},
          {1,0,3,4},
          {1,2,3,4},
          {1,2,3,4}
      };
      
      int currentRow = 0;
      int currentCol = 0;
      
      boolean dirtyRow = false;
     

      ArrayList<Integer> zeroCols = new ArrayList<Integer>();
     
      
      //traverse through the cells
      while(currentRow < matrix.length){
          while(currentCol < matrix[currentRow].length){
              //if current cell is 0, add the col value in arraylist
              if(matrix[currentRow][currentCol] == 0){
                  zeroCols.add(currentCol);
                  dirtyRow = true;
                 
              }
              
              
              currentCol++;
          }
          //when an iretation of a row is finished and the row is dirty, replce the row with array of 0
          if(dirtyRow){
              matrix[currentRow] = new int[matrix[currentRow].length];
              dirtyRow = false;
          }
          
          currentCol = 0;
          currentRow ++;
      };
      
     // change the columns to zeroes 
      for(int col : zeroCols){
          for(int i  = 0; i < matrix.length; i++){
              matrix[i][col] = 0;
          }
      }
      
      
      
      for(int[] row : matrix){
          System.out.println(Arrays.toString(row));
      }
      
      
      
    }
}