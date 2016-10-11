class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long x1=0,x2=0;
        long factor=1;
        for(ListNode i=l1;i!=null;i=i.next){
            x1+=i.val*factor;
            factor*=10;
        }
        factor=1;
        for(ListNode i=l2;i!=null;i=i.next){
            x2+=i.val*factor;
            factor*=10;
        }
        long x=x1+x2;
	System.out.println(x);
        ListNode head=new ListNode((int)(x%10));
	System.out.println(x%10);
        x=x/10;
        ListNode itr=head;
        for(long i=x;i!=0;i=i/10){
	    int m=(int)(i%10);
	    System.out.println(m);
            ListNode tail=new ListNode(m);
            itr.next=tail;
            itr=itr.next;
        }
        return head;
    }
    public static void main(String[] args){
	Solution2 s=new Solution2();
    	ListNode l1=new ListNode(9);

    	ListNode l2=new ListNode(1);
        l2.next=new ListNode(9);
	l2.next.next=new ListNode(9);
	l2.next.next.next=new ListNode(9);
	l2.next.next.next.next=new ListNode(9);
	l2.next.next.next.next.next=new ListNode(9);
	l2.next.next.next.next.next.next=new ListNode(9);
	l2.next.next.next.next.next.next.next=new ListNode(9);
	l2.next.next.next.next.next.next.next.next=new ListNode(9);
	l2.next.next.next.next.next.next.next.next.next=new ListNode(9);
	ListNode r=s.addTwoNumbers(l1,l2);
        for(ListNode i=r;i!=null;i=i.next)
	    System.out.print(i.val+" ");
	System.out.println();
    }
}
