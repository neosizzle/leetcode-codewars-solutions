import java.lang.StringBuilder;
public class MyClass {
    public static void main(String args[]) {
      String x = "Mr John Smith ";
      //char[] str = x.toCharArray();
      StringBuilder str = new StringBuilder(x.trim());
      
     for(int i = 0; i < str.length(); i++){
         if(Character.compare(str.charAt(i) , ' ') == 0){
             str.insert(i,"%20");
             str.delete(i+3,i+4);
         }
     }
      
      
      
      System.out.println(str);
      
    }
}