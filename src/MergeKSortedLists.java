
public class MergeKSortedLists {
	public ListNode mergeKList(ListNode[] lists){
		if(lists.length < 1) return null;
		ListNode[] temp; 
		int i, j, k;
		while(lists.length > 1){
			i = 0;
			j = i + 1;
			temp = new ListNode[(lists.length + 1) / 2]; 
			k = 0;
			while(i + 2 <= lists.length){ //merge each couple of elements in lists, the result will be placed in temp 
				temp[k] = twoMerge(lists[i], lists[j]);
				i += 2;
				j += 2;
				k ++;		
			}
			if(i < lists.length) // when the length of lists is odd, we should put the last element in temp
				temp[k] = lists[i];
			lists = temp;
		}
		return lists[0];
	}
	//merger two sorted linked list;
	public ListNode twoMerge(ListNode l1, ListNode l2){
		ListNode dummy, result;
		dummy = new ListNode(0); // a dummy head of the result
		result = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				result.next = l1;
				l1 = l1.next;
			}
			else{
				result.next = l2;
				l2 = l2.next;
			}
			result = result.next;
		}
		while(l1 != null){ // l1 might have nodes which never been traversed
			result.next = l1;
			l1 = l1.next;
			result = result.next;
		}
		while(l2 != null){ // l2 might have nodes which never been traversed
			result.next = l2;
			l2 = l2.next;
			result = result.next;
		}
		return dummy.next;
	}
}
