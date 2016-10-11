/**
 * File Name: TextJustify68.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年10月09日 星期日 22时37分37秒
 */
import java.util.*;
public class TextJustify68 {
	public static List<String> fullJustify(String[] words, int L) {
		List<String> results = new ArrayList<>();
		for (int i = 0, k, l; i < words.length; i += k) {
			for ( k = l = 0; i + k < words.length && l + words[i+k].length() <= L; k++) 
				l += words[i+k].length();
			StringBuilder sb = new StringBuilder(words[i]);
			for (int j = 0; j < k-1; j++) {
				if (i + k >= words.length) sb.append(' ');
				else {
					int count = (L - l) / (k - 1) + (j < (L - l) % (k - 1) ? 1 : 0);
					for (int n = 0; n < count; n++) {
						sb.append(' ');
					}
				}
				sb.append(words[i+j+1]);
			}
			for (int m = 0; m < L - sb.length(); m++) {
				sb.append(' ');
			}
			results.add(sb.toString());

		}
		return results;
	}
}
