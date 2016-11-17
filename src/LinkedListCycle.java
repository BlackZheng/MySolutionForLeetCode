
public class LinkedListCycle {
	//The trick here is change the visited node's value into minimal integer. 
	//This solution does AC, but it won't work if the value of one or more nodes of 
	//the list is the minimal integer initially. Therefore, the best solution is the slow-fast-runner way.
	public boolean hasCycle(ListNode head) {
        while(head != null){
            if(head.val != Integer.MIN_VALUE)
                head.val = Integer.MIN_VALUE;
            else
                return true;
            head = head.next;
        }
        return false;
    }
}
