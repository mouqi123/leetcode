import java.util.*;
public class SpiralMatrix54{
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0) return result;

		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		
		//每次外层循环剥掉矩阵的一个圈
		while(rowBegin <= rowEnd && colBegin <= colEnd) {
			//剥掉top行
			for (int i = colBegin; i <= colEnd; i++)
				result.add(matrix[rowBegin][i]);
			rowBegin++;
			
			//剥掉right列
			for (int i = rowBegin; i <= rowEnd; i++)
				result.add(matrix[i][colEnd]);
			colEnd--;

			//剥掉bottom列,前面rowBegin增加了1,所以此处须判断rowBegin<=rowEnd
			if (rowBegin <= rowEnd){
				for (int i = colEnd; i >= colBegin; i--)
					result.add(matrix[rowEnd][i]);
				rowEnd--;
			}

			//剥掉left列,前面rowBegin增加了1,所以此处须判断rowBegin<=rowEnd
			if (colBegin <= colEnd) {
				for (int i = rowEnd; i >= rowBegin; i--)
					result.add(matrix[i][colBegin]);
				colBegin++;
			}
		}
		return result;
	}
}
