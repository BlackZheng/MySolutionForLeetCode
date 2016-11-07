
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);//dummy head
        dummy.next = head;
        ListNode breakPoint = dummy;
        for(int i = 1; i < m; i++){ //find the breaking point
            breakPoint = breakPoint.next;
        }
        ListNode cur, next, nextNext;
        cur = breakPoint.next;
        next = cur.next;
        for(int i = 0; i < n - m; i++){//reversing the linked list from position m to n
            nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
        //link three segment
        breakPoint.next.next = next;
        breakPoint.next = cur;
        return dummy.next;
    }
}
