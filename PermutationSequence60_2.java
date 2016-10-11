import java.util.*;
public class PermutationSequence60_2 {
	public static String getPermutation(int n, int k) {
		List<Integer> numbers = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++)
			numbers.add(i);

		int[] factorial = new int[n+1];
		int sum = 1;
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
			factorial[i] = sum;
		}
		k--;
		for (int i = 1; i <= n; i++) {
			int index = k/factorial[n-i];
			sb.append(numbers.get(index));
			numbers.remove(index);
			k-=index*factorial[n-i];
		}
		return sb.toString();
	}
}
