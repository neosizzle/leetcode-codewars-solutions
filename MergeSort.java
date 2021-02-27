import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,4,3,634,14,6788,4657,89,10,6,5,7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    
    public static void mergeSort(int[] a){
        //if length is less than 2, cant split anymore, return
        if(a.length < 2) return;
        
        //declare mid index
        int mid = a.length / 2;
        
        
        //split a into two parts
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];
        
        //add values into arrays
        for(int i = 0; i < left.length; i++){
            left[i] = a[i];
        }
        
        for(int i = 0; i < right.length; i++){
            right[i] = a[mid + i];
        }
        
        //recursive call to split them even further
        mergeSort(left);
        mergeSort(right);
        
        //merge / overwrite he sorted elemts into parent array
        merge(left , right, a);
        
        return;
        
    }
    
    public static void merge(int[] left, int[] right, int[]a){
        //overrides a wtih sorted simpler lists.
        
        //starts loop with two pointers traversing the arrays 
        int leftP = 0;
        int rightP = 0;
        
        //declare a pointer to overwrite
        int aP = 0;
        
        //since left and right will be sorted before they pass, we can asssume the rest of one side is completely sorted once the other side is sorted as well.
        while(leftP < left.length && rightP < right.length){
            //compare and overwrites a with sorted values
            
            //left pointed value is smaller than right poitned value
            if(left[leftP] < right[rightP]){
                
                //overwrites a pointer with left pointer value
                a[aP] = left[leftP];
                
                //increment
                aP++;
                leftP++;
                continue;
            }
            
            //right pointed value is smaller than left poitned value
            
            //overwrites a pointer with left pointer value
            a[aP] = right[rightP];
            
            //increment
            aP++;
            rightP++;
            continue;
            
        }
        
        //merge the remaining elemtents into a
        while(leftP < left.length){
            a[aP] = left[leftP];
            
            leftP++;
            aP++;
        }
        
        while(rightP < right.length){
            a[aP] = right[rightP];
            
            rightP++;
            aP++;
        }
        
        //return when both arrays are merged into A
        return;
    }
}