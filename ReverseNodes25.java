public class ReverseNodes25{
    public static ListNode reverseKGroup(ListNode head,int k){
	ListNode cur=head;
	int count=0;
	while(cur!=null&&count!=k){
	    count++;
	    cur=cur.next;
	}
	if(count==k){
	    cur=reverseKGroup(cur,k);
	    while(count-->0){
		ListNode temp=head.next;
		head.next=cur;
		cur=head;
		head=temp;
	    }
	    head=cur;
	}
	return head;
    }
}
