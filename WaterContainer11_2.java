/**
 * File Name: WaterContainer11_2.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年04月13日 星期三 13时20分35秒
 */
public class WaterContainer11_2{
	public static int maxArea(int[] height){
		int i=0,j=height.length-1;
		int maxArea=0;

		while(i<j){
			int len=j-i;
			int h=height[i]<height[j] ? height[i] : height[j];
			int tempArea=h*len;
			maxArea= tempArea>maxArea ? tempArea: maxArea;
			while(height[i]<=h&&i<j) i++;
			while(height[j]<=h&&i<j) j--;
		}
		return maxArea;
	}
	public static void main(String[] args){
		int[] a={2,1,1,2};
		System.out.println(maxArea(a));
	}
}
