public class EightQueen8{
	private int[][] car = new int[2][9];
	private int[][] rlup = new int[2][17];
	public void backtrack(int i){
		for (int j = 1; j <=8; j++){
			if(car[0][j] == 0 && rlup[0][i+j] == 0 && rlup[1][i+8-j] == 0) {
				car[1][i] = j;
				car[0][j] = rlup[0][i+j] = rlup[1][i+8-j] = 1;
				backtrack(i+1);
				car[0][j] = rlup[0][i+j] = rlup[1][i+8-j] = 0;
			}
		}
	}
}
