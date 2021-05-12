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
    int nGlobal = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //declare global variable to keep track on the node position
        nGlobal = n + 1;
        
        //call helper method
        ListNode newHead = removeHelper(head);
        
        //if nGlobal is more than 0, which means we have to remove the first node
        if(nGlobal > 0){
            return head.next;
        }
        
        return newHead;
        
    }
    
    public ListNode removeHelper(ListNode head){
        //recursive approach
        //call this function recursively until it reaches the end node
        
        //base case
        if(head == null){
            return head;
        }
        
        //recursively call the next node
        removeHelper(head.next);
        
        //after the recursive calls return, means it reached the tail
        //decrement n
        --nGlobal;
        
        //remove element if n == 0;
        if(nGlobal == 0){
            head.next = head.next.next;
        }
        
        return head;
    }
}
