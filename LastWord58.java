public class LastWord58 {
	public static int lengthOfLastWord(String s) {
		s = s.trim();
		return s.length()-1-s.lastIndexOf(" ");
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world"));
		System.out.println(lengthOfLastWord(""));
	}
}
