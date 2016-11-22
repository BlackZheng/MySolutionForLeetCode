
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        if(head == null || head.next == null)
            return head;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            ListNode preCursor = dummyHead, curCursor = dummyHead.next;
            while(cur.val > curCursor.val){
                preCursor = preCursor.next;
                curCursor = curCursor.next;
            }
            if(cur == curCursor){
                pre = pre.next;
                cur = cur.next;
            }
            else{
                pre.next = cur.next;
                preCursor.next = cur;
                cur.next = curCursor;
                cur = pre.next;
            }
        }
        return dummyHead.next;
    }
}
