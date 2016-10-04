public class Node19{
    public static ListNode removeNthFromEnd(ListNode head,int n){
	ListNode t1=head,t2=head;
	while(n-->0) t2=t2.next;
	if(t2==null) return head.next;
	while(t2.next!=null){
	    t1=t1.next;
	    t2=t2.next;
	}
	t1.next=t1.next.next;
	return head;
    }
    public static void main(String[] args){
	ListNode head=new ListNode(1);
	head.next=new ListNode(2);
	head.next.next=new ListNode(3);
	head.next.next.next=new ListNode(4);
	head.next.next.next.next=new ListNode(5);
	ListNode r=removeNthFromEnd(head,2);
	for(ListNode i=r;i!=null;i=i.next)
	    System.out.print(i.val+" ");
	System.out.println();
    }
}
