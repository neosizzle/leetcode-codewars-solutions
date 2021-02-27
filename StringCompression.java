import java.lang.StringBuilder;
//string compression
public class MyClass {
    public static void main(String args[]) {
        String str = "aabcccccaaa";
        int rep = 1;
        StringBuilder res =new StringBuilder(); 
        
        for(int i = 1; i < str.length(); i++){
            
            //if the index is at the strings end
            if(i == str.length() - 1){
                //ongoing repetition, append res and end loop
                if(Character.compare(str.charAt(i), str.charAt(i-1)) == 0){
                    rep++;
                    res.append(String.valueOf(str.charAt(i-rep+1)) + rep);
                    break;
                }
                
                //different character, append res with both characters and end loop
                else{
                    res.append(String.valueOf(str.charAt(i-rep)) + rep);
                    res.append(String.valueOf(str.charAt(i)) + 1);
                    break;
                }
                
            }
            
            //if the character @ current pointer is the same compared to last index, increment repetition and continue
            if(Character.compare(str.charAt(i), str.charAt(i-1)) == 0){
                rep++;
                continue;
            }
            //if not, showing that characters had changed, append the value of character and number of increments to result, resets increment as well
            if(Character.compare(str.charAt(i), str.charAt(i-1)) != 0){
                res.append(String.valueOf(str.charAt(i-rep)) + rep);
                rep = 1;
                continue;
            }
        }
        
       System.out.println(res);
      
    }
}