//My explanation for this problem:https://discuss.leetcode.com/topic/68335/java-solution-by-two-pointers-with-graph-explanation
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
//          Detect the circle. 
//          Now the current node and head node are about equidistant from the the node where the cycle begins.
            if(slow == fast){
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
