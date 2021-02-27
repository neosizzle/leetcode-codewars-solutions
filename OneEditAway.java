public class OneEditAway{
    public static void main(String args[]) {
      String x ="pale";
      String y ="bale";
      
      //hashset to compare chacters in both strings
      //1 edit means there should be no more than 1 character change in both strings      
      
      String strLong = (x.length() >= y.length())? x:y;
      String strShort = (strLong.equals(x))? y:x;
      
      //since we are comparing 2 strings, using 2 pointer approach
      int indexLong = 0;
      int indexShort = 0;
      
      int changes = 0;
      
      
      while(indexLong < strLong.length()){
          
          //short index out of bounds/ push/pop found, increment long index and changes
          if(indexShort == strShort.length()){
              indexLong++;
              changes++;
              continue;
              
          }
          
          //compare indexes
          int compare  = Character.compare(strLong.charAt(indexLong), strShort.charAt(indexShort));  
          
          
          
          //no difference in pointers, increment both indexes
          if(compare == 0){
              indexLong++;
              indexShort++;
              continue;
          }
          
          //insertion/deletion found, increment long pointer and change only
          if(compare != 0 && x.length()!=y.length()){
              indexLong++;
              changes++;
              continue;
          }
          
          //replace found, increment both indexes and changes
          if(compare!=0){
              indexLong++;
              indexShort++;
              changes++;
              continue;
          }
          
          
      }
      
      
      System.out.println(changes <= 1);
      
    }
}