import java.util.*;
import com.mutou.util.*;

class Cell{
	public int value;
	public int possibilities;
	public BitSet constraints;
	public Cell() {
		possibilities = 9;
		constraints = new BitSet(10);
	}
	public Cell(Cell c) {
		value = c.value;
		possibilities = c.possibilities;
		constraints = (BitSet) c.constraints.clone();
	}
}

public class SudokuSolver37_1 {
	private Cell[][] cells = new Cell[9][9];
	private ArrayList<Pairs<Integer,Integer>> emptyList = new ArrayList<>();

	public void solveSudoku(char[][] board) {
		//初始化每个cell记录
		for (int i = 0; i < 9; i++) 
			for (int j = 0; j < 9; j++) 
				cells[i][j] = new Cell();

		//遍历Board,记录非空单元的统计信息，同时收集所有的空cell到emptyList中
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !set(i, j, board[i][j] - '0'))
					return ;
				else
					emptyList.add(new Pairs<>(i,j));
			}
		}

		//开始在backtrack中处理空的单元,若发生错误，则直接返回
		if (!backtrack(0)) return;

		//处理完毕，将cells中的记录信息拷贝回board
		for (int i = 0; i < 9; i++) 
			for (int j = 0; j < 9; j++) 
				board[i][j] = (char) (cells[i][j].value + '0');
	}

	//设置单元(i,j)值为v,同时更新行、列和3×3格子的constraints信息
	private boolean set(int i, int j, int v){
		Cell c = cells[i][j];
		if (c.value == v) return true;
		if (c.constraints.get(v)) return false;

		c.value = v;
		c.possibilities = 1;
		c.constraints.set(1,10); //将1-9位都设为true
		c.constraints.flip(v);	 //翻转第v为，使其为false

		for (int k = 0; k < 9; k++) {
			if (i != k && !update(k, j, v)) return false;	//更新每行的cell记录
			if (j != k && !update(i, k, v)) return false;	//更新每列的cell记录
			int ix = i/3*3 + k/3;
			int jx = j/3*3 + k%3;
			if (ix != i && jx != j && !update(ix, jx, v)) return false; //更新每个3×3格子
		}

		return true;
	}

	//更新单元(i,j),使其在值v上的constraints位为true,如果单元
	//(i,j)只剩一种可能的取值情况(假设为m)，则调用set(i, j, m)
	private boolean update(int i ,int j, int excluded) {
		Cell c = cells[i][j];
		if (c.constraints.get(excluded)) return true;
		if (c.value == excluded) return false;

		c.constraints.set(excluded);
		if(--c.possibilities > 1)
			return true;

		//如果此单元只剩下一种取值可能性，设置这个值
		for (int v = 1; v <= 9; v++){
			if (!c.constraints.get(v))
				return set(i, j, v);
		}
		return false;
	}

	private boolean backtrack(int k) {
		if(k >= emptyList.size()) return true; //k索引大于列表大小说明已经处理完所有空单元
		int i = emptyList.get(k).getKey();
		int j = emptyList.get(k).getValue();

		Cell c = cells[i][j];
		//大于0说明设置了单元值，应该跳过这个单元(因为初始值为0)
		if (c.value > 0)
			return backtrack(k+1);

		//保存单元的快照，用于后面的回溯
		Cell[][] snapshot = new Cell[9][9];
		for (int n = 0; n < 9; n++)
			for (int m =0; m < 9; m++)
				snapshot[n][m] = new Cell(cells[n][m]);

		for (int v = 1; v <= 9; v++) {
			if (!c.constraints.get(v) && set(i, j, v) && backtrack(k+1))
				return true;

			//发生冲突，用snapshot将cells恢复到以前的状态
			for (int n = 0; n < 9; n++)
				for (int m =0; m < 9; m++)
					cells[n][m] = new Cell(snapshot[n][m]);

		}

		return false;

	}
	public static void main(String[] args){
		char[][] board={{'5','3','.','.','4','.','.','.','9'},
						{'.','.','4','.','1','.','.','3','.'},
						{'7','.','1','.','.','3','.','.','.'},
						{'.','.','.','8','.','4','2','.','.'},
						{'9','.','.','.','.','.','.','.','4'},
						{'.','.','6','5','.','2','.','.','.'},
						{'.','.','.','3','.','.','1','.','5'},
						{'.','8','.','.','7','.','6','.','.'},
						{'2','.','.','.','8','.','.','4','7'}};
		SudokuSolver37_1 sk=new SudokuSolver37_1();
		long t1=System.currentTimeMillis();
		sk.solveSudoku(board);
		System.out.println("time using: "+(System.currentTimeMillis()-t1));
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
