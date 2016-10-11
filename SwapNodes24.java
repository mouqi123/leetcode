public class SwapNodes24{
    public static ListNode swapPairs(ListNode head){
	ListNode ret=new ListNode(0);
	ret.next=head;
	for(ListNode cur=ret;cur.next!=null&&cur.next.next!=null;cur=cur.next.next)
	    cur.next=swap(cur.next,cur.next.next);
	return ret.next;
    }
    public static ListNode swap(ListNode l1,ListNode l2){
	l1.next=l2.next;
	l2.next=l1;
	return l2;
    }
}
