//check if a string is a rotation of another string
public class isRotation {
    public static void main(String args[]) {
      String s1 = "waterbottle";
      String s2 = "erbottlewat";

	  //check if s1 and s2 are equal length
      if(s1.length() != s2.length()){
          System.out.println(false);
          return;
      }
      
      /**
       * Split the string into 2 parts: x and y seperated by index of rotation.
       * in this case, x = wat, y = erbottle.
       * thus, s1 = xy = waterbottle
       * if s2 should be equals to yx.
       * reagrdless of index rotation, yx will always be substring of xyxy.
       * thus, s2 should be a substring of s1s1
       * 
       **/
      String s1s1 = s1 + s1;
      System.out.println(s1s1.indexOf(s2) != -1);
    }
}