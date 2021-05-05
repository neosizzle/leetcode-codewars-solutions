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
//https://leetcode.com/problems/palindrome-linked-list/submissions/
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        //iterate through the linked list once 
        ListNode current = head;
        int length = 0;
        while(current != null){
            ++length;
            current = current.next;
        }
        
        //iterate through the linkedlist another time to determine if its a palindrome
        current = head;
        int index = 0;
        
        Stack<Integer> nums = new Stack<>();  
        
        while(current != null){
            
            //index still at the left part of linkedlist
            if(index < length/2){
                nums.push(current.val);
            }
            else{
                //index is at the second part of the lniked list
                
                //skip 1 node for odd length case
                if(index == length / 2 && length % 2 != 0){
                    current = current.next;
                    ++index;
                    continue;
                }
                
                //pop from stack and retrun false if elements are different
                if(nums.pop() != current.val){
                    return false;
                }
            }
            
            ++index;
            current = current.next;
        }
    
        
        return true;
        
        
    }
}
