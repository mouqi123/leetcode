import java.util.*;
class Pair{
	public int first;
	public int second;
	public Pair(int first,int second){
		this.first=first;
		this.second=second;
	}
}
class Cell implements Cloneable{
	public int value;
	public int possibilities;
	public BitSet constraints;
	public Cell(){
		value=0;
		possibilities=9;
		constraints=new BitSet(10);
	}
	public Object clone(){
		Cell o=null;
		try{
			o=(Cell)super.clone();
			o.constraints=(BitSet)this.constraints.clone();
		}catch(Exception e){}
		return o;
	}
} 
public class SudokuSolver37{

	public Cell[][] cells;

	public void solveSudoku(char[][] board){
		cells=new Cell[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				cells[i][j]=new Cell();
		}

		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				//process none empty cell.
				if(board[i][j]!='.'&& !set(i,j,board[i][j]-'0'))
					return;
			}
		}

		//process empty cell.
		if(!doEmptyCells())  return;

		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				board[i][j]=(char)(cells[i][j].value+'0');
		}
	}

	public boolean set(int i,int j,int v){
		Cell c=cells[i][j];

		if(c.value==v)  return true;
		if(c.constraints.get(v))  return false;

		c.value=v;
		c.possibilities=1;
		BitSet b=new BitSet(10);
		b.set(1,10);  //set index of 1 to 9 to true.
		b.flip(v);    //reverse index v.
		c.constraints=b;

		for(int k=0;k<9;k++){
			if(i!=k&& !update(k,j,v))  return false;
			if(j!=k&& !update(i,k,v))  return false;
			int ix=(i/3)*3+k/3;
			int jx=(j/3)*3+k%3;
			if(ix!=i&&jx!=j && !update(ix,jx,v)) return false;
		}

		return true;
	}

	public boolean update(int i,int j,int excluded){
		Cell c=cells[i][j];
		if(c.constraints.get(excluded))  return true;
		if(c.value==excluded) return false;

		c.constraints.set(excluded);
		if(--c.possibilities>1)
			return true;
		//如果这个单元只剩下一种可能，找到这种可能并设置这个值
		for(int v=1;v<=9;v++){
			if(!c.constraints.get(v)){
				return set(i,j,v);
			}
		}
		return false;
	}

	public ArrayList<Pair> list=new ArrayList<>();
	public boolean doEmptyCells(){
		list.clear();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(cells[i][j].value==0)
					list.add(new Pair(i,j));
			}
		}
		//此处排序后将会降低性能.
		/*Collections.sort(list,(a,b)->{  
		  if(cells[a.first][a.second].possibilities<cells[b.first][b.second].possibilities) return -1;
		  else if(cells[a.first][a.second].possibilities==cells[b.first][b.second].possibilities) return 0;
		  else return 1; });*/
		return backtrack(0);
	}

	public boolean backtrack(int k){
		if(k>=list.size())  return true;
		int i=list.get(k).first;
		int j=list.get(k).second;

		//大于0说明此单元已经填了数字，因为初始假设单元为0
		if(cells[i][j].value>0) 
			return backtrack(k+1);
		BitSet constraints=cells[i][j].constraints;
		Cell[][] snapshot=new Cell[9][9];
		for(int n=0;n<9;n++){
			for(int m=0;m<9;m++){
				snapshot[n][m]=(Cell)cells[n][m].clone();
			}
		}
		for(int v=1;v<=9;v++){
			if(!constraints.get(v)){
				if(set(i,j,v)){
					if(backtrack(k+1))
						return true;
				}
			}
			//发生冲突，回退
			for(int n=0;n<9;n++){
				for(int m=0;m<9;m++){
					cells[n][m]=(Cell)snapshot[n][m].clone();
				}
			}
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
		SudokuSolver37 sk=new SudokuSolver37();
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
