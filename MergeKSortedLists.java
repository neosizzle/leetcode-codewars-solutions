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
//https://leetcode.com/problems/merge-k-sorted-lists/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //edge case check
        if(lists.length == 0){
            return null;
        }
        
        
        //create min heap to store all the listnodes values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        
        //use a loop to add all nodes into min heap
        for(int i = 0 ;i < lists.length; ++i){
            
            while(lists[i] != null){
                minHeap.add(lists[i].val);
                lists[i] = lists[i].next;
            }
            
        }
        
        //if minheap is empty from data population, return null
        if(minHeap.isEmpty()){
            return null;
        }
        
        //while the heap is not empty, do sth
        ListNode resHead = new ListNode(minHeap.poll());
        ListNode resCurrent = resHead;
        while(!minHeap.isEmpty()){
                        
            //set next node to polled node
            resCurrent.next = new ListNode(minHeap.poll());
            
            //move current node to next node
            resCurrent = resCurrent.next;
        }
        
        return resHead;
    }
    
 
}
