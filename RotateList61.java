import java.util.*;
public class RotateList61 {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) return head;

		int n = 0;
		for (ListNode pos = head; pos != null; pos=pos.next)
			n++;
		
		k = k%n;
		if (k == 0) return head;
		ListNode cur = head;
		while (--k > 0 && cur.next !=null) cur = cur.next; 
		if (cur.next == null) return head;

		cur = cur.next;
		ListNode left = head;
		while (cur.next != null) {
			left = left.next;
			cur = cur.next;
		}
		cur.next = head;
		head = left.next;
		left.next = null;

		return head;
	}
}
