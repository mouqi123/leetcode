import java.util.*;
public class MergeLists23{
    public static ListNode mergeKLists(ListNode[] lists){
	return partion(lists,0,lists.length-1);
    }
 
    public static ListNode partion(ListNode[] lists,int s,int e){
	if(s==e)  return lists[s];
	if(s<e){
	    int q=(s+e)/2;
	    ListNode l1=partion(lists,s,q);
	    ListNode l2=partion(lists,q+1,e);
	    return merge(l1,l2);
	}else 
	    return null;
    }

    public static ListNode merge(ListNode l1,ListNode l2){
	if(l1==null) return l2;
	if(l2==null) return l1;
	if(l1.val<l2.val){
	    l1.next=merge(l1.next,l2);
	    return l1;
	}else{
	    l2.next=merge(l1,l2.next);
	    return l2;
	}
    }
    public static void main(String[] args){
	ListNode[] lists=new ListNode[7];
	for(int i=0;i<7;i++){
	    lists[i]=new ListNode(0);
	}
	ListNode list1=lists[0];
	ListNode list2=lists[1];
	ListNode list3=lists[2];
	ListNode list4=lists[3];
	ListNode list5=null;
	ListNode list6=lists[5];
	ListNode list7=lists[6];
	list1.val=-10;
	list1.next=new ListNode(-9);
	list1.next.next=new ListNode(-9);
	list1.next.next.next=new ListNode(-3);
	list1.next.next.next.next=new ListNode(-1);
	list1.next.next.next.next.next=new ListNode(-1);
	list1.next.next.next.next.next.next=new ListNode(0);
	list2.val=-5;
	list3.val=4;
	list4.val=-8;
	list6.val=-9;
	list6.next=new ListNode(-6);
	list6.next.next=new ListNode(-5);
	list6.next.next.next=new ListNode(-4);
	list6.next.next.next.next=new ListNode(-2);
	list6.next.next.next.next.next=new ListNode(2);
	list7.val=-3;
	list7.next=new ListNode(-3);
	list7.next.next=new ListNode(-2);
	list7.next.next.next=new ListNode(-1);
	list7.next.next.next.next=new ListNode(0);
	ListNode results=mergeKLists(lists);
	while(results!=null){
	    System.out.print(results.val+"  ");
	    results=results.next;
	}
	System.out.println();
    }
}
