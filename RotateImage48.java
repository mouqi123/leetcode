/**
 * File Name: RotateImage48.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年04月26日 星期二 12时59分28秒
 */
import java.util.Arrays;
public class RotateImage48{
	public static void rotate(int[][] matrix){
		int len1=matrix.length;
		int len2=matrix[0].length;
		int[][] temp=new int[len1][len2];
		for(int i=0;i<len1;i++)
			temp[i]=Arrays.copyOf(matrix[i],len2);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				matrix[j][len2-i-1]=temp[i][j];
			}
		}
	}
	public static void main(String[] args){
		int[][] a={ { 1,2,3 },{ 4,5,6 },{ 7,8,9 }};
		for(int[] i:a){
			for(int j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		rotate(a);
		for(int[] i:a){
			for(int j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
