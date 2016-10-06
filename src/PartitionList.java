
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0), anotherDummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy, q = head, greater = anotherDummy;
		while(q != null){
			if(q.val >= x){// q is greater than x
				p.next = q.next;
				
				//add q to another list
				greater.next = q;
				greater = greater.next;
				greater.next = null;
			}
			else
				p = p.next;
			q = p.next;
		}
		p.next = anotherDummy.next;//join two lists
        return dummy.next;
    }
}
