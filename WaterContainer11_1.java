public class WaterContainer11_1{
    public static int maxArea(int[] height){
	int i=0,j=height.length-1;
	int maxArea=0;

	while(i<j){
	    int len=j-i;
	    System.out.println("i="+i+"  j="+j+"  len="+len);
	    int h= height[i]<height[j] ? height[i] : height[j];
	    int tempArea=h*len;
	    maxArea= tempArea>maxArea ? tempArea : maxArea;
	    while(height[i]<=h&&i<j) i++;
	    while(height[j]<=h&&i<j) j--;
	}
	return maxArea;
    }
    public static void main(String[] args){
	int[] a={1,1};
	System.out.println(maxArea(a));
    }
}
