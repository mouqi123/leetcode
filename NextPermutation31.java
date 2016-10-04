//寻找下一个组合
//    Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i]. So, elements from num[i] to num[n-1] is reversely sorted.
//        To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount, we have to make the highest changed position as high as possible. Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted. So, we want to increase the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] that is larger than num[i-1]. For example, original number is 121543321, we want to swap the '1' at position 2 with '2' at position 7. The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the num[i,n-1] 
public class NextPermutation31{
	public static void nextPermutation(int[] num){
		int n=num.length;
		int i=n-1,j=n-1;
		while(i>0&&num[i-1]>=num[i])
			i--;
		if(i==0){
			reverse(num,0,n-1);
			return;
		}
		i--;
		while(num[i]>=num[j])
			j--;
		swap(num,i,j);
		reverse(num,i+1,n-1);
	}
	public static void swap(int[] num,int i,int j){
		int temp=0;
		temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}
	public static void reverse(int[] num,int s,int e){
		int temp=0;
		int j=e;
		for(int i=s;i<=(s+e)/2;i++,j--)
			swap(num,i,j);
	}
	public static void main(String[] args){
		int a[]={1,3,2};
		for(int i:a) System.out.print(i+"  ");
		System.out.println();
		nextPermutation(a);
		for(int i:a) System.out.print(i+"  ");
		System.out.println();
	}
}
