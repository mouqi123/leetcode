public class EightQueen1{
	private int[] column;
	private int[] rup;
	private int[] lup;
	private int[] queen;
	private int num;

	public EightQueen1() {
		column = new int[9];
		rup = new int[17];
		lup = new int[17];
		queen = new int[9];
	}

	public void backtrack(int i) {
		if (i > 8)
			showAnswer();
		else {
			for (int j = 1; j <=8; j++) {
				if (column[j] == 0 && rup[i+j] == 0 && lup[i+8-j] == 0) {
					queen[i] = j;
					column[j] = rup[i+j] = lup[i+8-j] = 1;
					backtrack(i+1);
					column[j] = rup[i+j] = lup[i+8-j] = 0;
				}
			}
		}
	}

	private void showAnswer() {
		num++;
		System.out.println("\n answer:" +num);
		for (int i=1; i<=8; i++) {
			for (int j=1; j<=8; j++) {
				if (queen[i] == j)
					System.out.print("Q");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] agrs) {
		EightQueen1 eq = new EightQueen1();
		eq.backtrack(1);
	}
}
