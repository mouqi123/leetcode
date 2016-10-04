public class PermutationSequence60{
	public static String getPermutation(int n, int k) {
		int[] sequence = new int[n];
		for (int i = 0; i < n; i++)
			sequence[i] = i+1;
		for (int i = 0; i < k - 1; i++) {
			nextPermutation(sequence);
		}
		char[] c = new char[n];
		for (int i = 0; i < n; i++)
			c[i] = (char) (sequence[i] + '0');
		return new String(c);
	}
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
		System.out.println(getPermutation(3, 3));
	}
}
