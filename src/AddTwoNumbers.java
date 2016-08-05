
public class AddTwoNumbers {
	/**
	 You are given two linked lists representing two non-negative numbers.
	 The digits are stored in reverse order and each of their nodes contain
	  a single digit. Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	 */
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        boolean hasExtra = false;
        ListNode result,temp;  //result will be used to be returned, and temp is for loop  
        result = new ListNode(0);// result keep a dummy head
        temp = result;
        while(l1 != null || l2 != null){// the two list might not have same numbers
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(hasExtra) // the former sum of two digits have a carry
                sum++;
            if(sum > 9){
                sum = sum % 10;
                hasExtra = true;
            }
            else
                hasExtra = false;
            temp.next = new ListNode(sum);//build a new node with sum
            temp = temp.next;
        }
        if(hasExtra)
            temp.next = new ListNode(1);//there is a carry after all node is added
        return result.next;
        
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	  }
