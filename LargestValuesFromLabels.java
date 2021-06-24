//https://leetcode.com/problems/largest-values-from-labels/
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        //create a list of items 
        List<Item> items = new ArrayList<>();
        
        //create items object and add them into a list
        for(int i = 0; i < labels.length; ++i){
            Item item = new Item(labels[i], values[i]);
            items.add(item);
        }
        
        
        //create a max heap and throw all the items in that heap
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a ,b)-> b.value - a.value);
        maxHeap.addAll(items);
        
        //create a hashmap that stores the number of occurences of label 
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        
        //while the heap is not empty AND num wanted is greater than 0, do sth
        int res = 0;
        while(!maxHeap.isEmpty() && num_wanted > 0){
            //remove the current product from max heap
            Item currItem = maxHeap.remove();
            
            //increment use limit for that item
            hashMap.put(currItem.label , hashMap.getOrDefault(currItem.label, 0) + 1);
            
            //check if labels are valid
            if(hashMap.get(currItem.label) <= use_limit){
                
                //if yes, take it, +1 to label
                res += currItem.value;
                num_wanted--;
                

            }

        }
        return res;
    }
    
    public class Item{
        int label;
        int value;
        
        public Item(int label , int value){
        this.label = label;
        this.value = value;
      }
        
    }
    

}
