public class WaterContainer11{
	public static int maxArea(int[] height){
		int len=height.length;
		if(len<2)  return 0;
		int[] r=new int[len-1];
		int ret=0;

		for(int i=0;i<len-1;i++){
			int max=0;
			int temp=0;
			for(int j=i+1;j<len;j++){
				temp= height[i]<height[j] ? height[i]*(j-i) : height[j]*(j-i);
				if(temp>max)
					max=temp;
			}
			if(max>ret)  ret=max;
		}
		return ret;
	}
	public static void main(String[] args){
		int[] a={4,9,6};
		System.out.println(maxArea(a));
	}
}
