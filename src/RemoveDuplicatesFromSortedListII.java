
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = head;
        while(q != null){
            int curVal = q.val;
            if(q.next != null && q.next.val == curVal){//discover a duplicates
            	//remove duplicates
                while(q != null && q.val == curVal){
                    q = q.next;
                    p.next = q;
                }
            }
            //the current node is not duplicated, so we move on
            else{
                p = p.next;
                q = q.next;
            }
        }
        return dummyHead.next;
    }
}
