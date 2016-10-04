public class SubString3_1 {
	public static int lengthOfLongestSubString(String s) {
		int[] occurs = new int[128];
		int maxL = 0;

		int n = s.length();
		for (int i = 0, j = 0; i < n; i++) {
			char c = s.charAt(i);
			occurs[c]++;
			while (occurs[c] > 1) {
				occurs[s.charAt(j++)]--;
				maxL = Math.max(maxL, i-j+1);
			}
		}
		return maxL;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubString("abcdefgasd"));
	}
}
