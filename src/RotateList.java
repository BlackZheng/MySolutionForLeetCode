
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null) return head; //Empty list and 0th, just return head
        ListNode newHead;
        ListNode slowRunner, tail;
        slowRunner = tail = head;
        int len= 1;
        while(tail.next != null){ //find the tail node and get length of the list
            tail = tail.next;
            len++;
        }
        int place = k % len; //if k > len, we need to recount from tail 
        if(place == 0)
            return head;
        for(int i = 0; i < len - place - 1; i++){
           slowRunner = slowRunner.next;
        }
        //reconnect two lists
        newHead = slowRunner.next;
        slowRunner.next = null;
        tail.next = head;
        return newHead;
    }
}
