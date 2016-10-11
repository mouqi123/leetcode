public class MergeLists21_1{
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
	if(l1==null) return l2;
	if(l2==null) return l1;
	
	ListNode ret;
	if(l1.val<=l2.val)  ret=l1;
	else 		    ret=l2;
	
	while(l1!=null||l2!=null){
	    if(l1==null) 
