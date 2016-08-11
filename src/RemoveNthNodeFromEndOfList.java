import java.util.ArrayList;
import java.util.List;


public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<ListNode>();
		while(head != null){
			list.add(head);
			head = head.next;
		}
		if(list.size() == 1)
			return null;
		int target = list.size() - n;
		if(target > 0){
			list.get(target - 1).next = n > 1 ? list.get(target + 1) : null;
		}
		else
			list.remove(target);
		return list.get(0);
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}