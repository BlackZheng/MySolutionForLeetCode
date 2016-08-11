
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
			return head;
		ListNode dummy, pre, current, next;
		dummy = new ListNode(0);
		dummy.next = head;
        current = dummy;
		while(current.next != null && current.next.next != null){
			//move pointers
			pre = current;
			current = current.next;
			next = current.next;
			//start swapping
			current.next = next.next;
			pre.next = next;
			next.next= current;
			
		}
        return dummy.next;
    }
}
