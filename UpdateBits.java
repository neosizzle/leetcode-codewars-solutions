//Cracking the coding interview question 5.1
public class MyClass {
    static int updateBits(int n, int m, int i, int j)
    {
        //create a sequence of full 1s
        int fullOnes = ~0;
        
        //create left and right sections of the mask to clear ns positions
        int leftMask = fullOnes << (j + 1);
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        
        //pop the mask at n
        int n_clred = n & mask;
        
        //move correct position for m
        int m_moved = m << i;
        
        //use an or statement to apply m
        return n_clred | m_moved;
    }
    public static void main(String args[]) {
        int test = ~4;
        
        System.out.println(updateBits(1024, 19, 2, 6));
    }
}
