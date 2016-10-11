// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Input (3 -> 7) + (9 -> 2)
// Output 2 -> 0 -> 1
public class Solution2_1{
	public ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode prev = new ListNode(0);
		ListNode head = prev;
		int flag = 0;
		while (l1 != null || l2 != null || flag != 0) {
			ListNode cur = new ListNode(0);
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) +flag;
			cur.val = sum % 10;
			flag = sum / 10;
			prev.next = cur;
			prev = cur;

			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}
		return head.next;
	}
	public static void main(String[] args){
		Solution2_1 s=new Solution2_1();
		ListNode l1=new ListNode(3);
		l1.next=new ListNode(7);

		ListNode l2=new ListNode(9);
		l2.next=new ListNode(2);
		ListNode r=s.addTwoNumbers(l1,l2);
		for(ListNode i=r;i!=null;i=i.next)
			System.out.print(i.val+" ");
		System.out.println();
	}
}
