import java.util.LinkedList;


public class ReorderList {
	public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head, fast = head;
        LinkedList<ListNode> stk = new LinkedList<>();
      //Detect the cutting node by slow-fast-runner
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
      //Cut the list, push the second part into stack
        ListNode toInsert = slow.next;
        slow.next = null;
        while(toInsert != null){
            stk.push(toInsert);
            toInsert = toInsert.next;
        }
        slow = head;
        fast = slow.next;
      //Insert nodes of second part into first part at every interval between two nodes.
        while(!stk.isEmpty()){
            slow.next = stk.pop();
            slow.next.next = fast;
            slow = fast;
            fast = slow.next;
        }
    }
}
