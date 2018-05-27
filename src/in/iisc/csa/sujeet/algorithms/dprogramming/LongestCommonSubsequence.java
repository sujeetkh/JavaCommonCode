package in.iisc.csa.sujeet.algorithms.dprogramming;

public class LongestCommonSubsequence {
	public static int lcs(String str1, String str2) {
		int[][] lcs = new int[str1.length()][str2.length()];
		for (int i = 0; i < str1.length(); i++)
			for (int j = 0; j < str2.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
					if (str1.charAt(i) == str2.charAt(j))
						lcs[i][j] = 1;
				} else {
					if (str1.charAt(i) == str2.charAt(j))
						lcs[i][j] = Math.max(Math.max(lcs[i - 1][j - 1] + 1, lcs[i - 1][j]), lcs[i][j - 1]);
					else
						lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}

		return lcs[str1.length() - 1][str2.length() - 1];
	}

	public static void main(String[] args) {
		String str1 = "string";
		String str2 = "straight";
		System.out.println(lcs(str1, str2));
	}
}
