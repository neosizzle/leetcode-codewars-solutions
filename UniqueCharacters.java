
public class MyClass {
      public static void main(String []args){
         String str = "a33c";
         boolean[] charSet = new boolean[128];
         for(int i = 0; i < str.length(); i++){
             if(!charSet[(int) str.charAt(i)]){
                 charSet[(int) str.charAt(i)] = true;
             }
             else{
                 System.out.println("nope fam");
                 break;
             }
             
         }
         System.out.println("complete");
     }
}