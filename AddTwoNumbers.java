//https://leetcode.com/problems/add-two-numbers/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode resHead = new ListNode();
        ListNode res = resHead;
        
        //error checking
        if(l1 == null || l2 == null){
            return resHead;
        }
        
        //while l1 or l2 is not null, do sth
        while(l1 != null || l2 != null){
            //create nodes with 0s complementary to which node is longer
            if(l1 == null && l2 != null){
                ListNode temp = new ListNode(0);
                l1 = temp;
            }
            
            if(l1 != null && l2 == null){
                ListNode temp = new ListNode(0);
                l2 = temp;
            }
            
            //calculate the sum of the numbers
            int currSum = l1.val + l2.val;
            
            //if the sum is less than 10, we can append it to our result
            if(currSum < 10){
               resHead.val = currSum;
            
            }
            else{
                //else , store the remainder in reshead val and increment the next vals node by 1
                resHead.val = currSum - 10;

                if(l1.next != null){
                    l1.next.val = l1.next.val + 1;
                }
                else if( l2.next != null){
                    l2.next.val = l2.next.val + 1;
                }
                
                else{
                    ListNode temp = new ListNode(1);
                    l1.next = temp;
                }
                
            }
            
            //traverse
            l1 = l1.next;
            l2 = l2.next;
            
            //if we reached the end of the list, we need to break to prevent adding extra 0
            if(l1 == null && l2 == null){
                break;
            }
            
            resHead.next = new ListNode(0);
            resHead = resHead.next;
        
        }
        
        //System.out.println(resHead.val);
        return res;
        
        
    }
}
