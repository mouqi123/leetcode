public class FirstMissing41{
    public static int firstMissingPositive(int[] nums){
	int n=nums.length;
	if(n==0) return 1;
	
	int k=partion(nums)+1;
	int firstMissing=k;
	for(int i=0;i<k;i++){
	    System.out.println(nums[i]);
	    int temp=Math.abs(nums[i]);
	    if(temp<=k)
		nums[temp-1]= (nums[temp-1]<0) ?nums[temp-1]:-nums[temp-1];
	}

	for(int i=0;i<k;i++){
	    if(nums[i]>0){
		firstMissing=i;
		break;
	    }
	}
	return firstMissing+1;
    }
    private static int partion(int[] nums){
	int n=nums.length;
	int q=-1;
	int i=0;
	while(i<n){
	    if(nums[i]>0){
		q++;
		int temp=nums[i];
		nums[i]=nums[q];
		nums[q]=temp;
	    }
	    i++;
	}
	return q;
    }

   int firstMissingPositive(int A[], int n) {
        for (int i = 0; i < n; ++i)
        {
            int digit = A[i];
            while (digit <= n && digit > 0 && A[digit - 1] != digit)
            {
                swap(A[digit - 1], A[i]);
                digit = A[i];
            }
        }
        for (int i = 0; i < n; ++i)
        {
            if (A[i] != i + 1)
            {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args){
	int[] a={2,2,2,2,2};
	System.out.println(firstMissingPositive(a));
    }
}
