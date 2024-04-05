package subsets;

import java.util.ArrayList;
import java.util.List;

public class UniqueGeneralizedAbbreviations {
	private static void helper(String word, int idx, StringBuilder sb, int count, List<String> result) {
		if (idx == word.length()) {
			if (count != 0) {
				sb.append(count);
			}
			result.add(sb.toString());
		} else {
			helper(word, idx + 1, new StringBuilder(sb), count + 1, result);
			if (count != 0) {
				sb.append(count);
			}
			helper(word, idx + 1, new StringBuilder(sb).append(word.charAt(idx)), 0, result);
		}
	}

	private static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<>();
		helper(word, 0, new StringBuilder(), 0, result);
		return result;
	}

	public static void main(String[] args) {
		List<String> result = generateGeneralizedAbbreviation("BAT");
		System.out.println(result);
		List<String> result2 = generateGeneralizedAbbreviation("code");
		System.out.println(result2);
	}
}
