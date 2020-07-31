package medium.Minimum_ASCII_Delete_Sum_for_Two_Strings;

import org.junit.Test;

/**
 * Runtime : 1493ms(5.18%)
 * Memory : 51.6mb(5.71%)
 */
public class Solution {
	@Test
	public void execute() {
//		String s1 = "sea"; String s2 = "eat";
//		String s1 = "delete"; String s2 = "leet";
		String s1 = "zyomgwqaoninimjmgrvlubqjhrzuhooukkytlrymjjqeiusguxgssjiozmvxgndcukmstsdrefhrtwqvcqtxvtapszxryazsrguszwitukccbxwjqucorvyerxvpalrpvockrfxntwsktjumkmjohknviqhuvzmnqowqazjnwedtavxxxaitcgwnnhulhqzqybgfwgapjuxjysygpcnomedaoyjywjpkijahfcwpwjjzgoczugl";
		String s2 = "vlhxdnzgaojwsyzdghjgplbidswfniohpdsrczbililhubozfzjstqrnkonbpyykssdvwugcnmsqasnxylgtnuygoacnwevqbjtvyisdojnotjjrifnnmojjcgpeglqejyerhywkmuyppfscbybcjusralaosqvkhceuolvaxwrehigvdvojkyueudnwzukgijagauxyblnuajifvcsaqelotezbfecircokqhhpqoyjrzqdvuyqvscgjuehtuygbraawzqqpaqeqfxiffaunilooccmrihjoosakmxlhsmiokpmlehigqbxblzkjyzwmxsuiutubpmoravvftwhtudrprmwzvszgoqyyythptkhgscdypwcocdfpuxspdc";
		System.out.println(minimumDeleteSum(s1, s2));
	}

	private int recursion(String s1, String s2, int idx_1, int idx_2, int[][] record, int[][] subRecord) {
		if(idx_1 == s1.length() || idx_2 == s2.length()) return 0;
		else if(record[idx_1][idx_2] != 0) {
			return record[idx_1][idx_2];
		}
		int maxScore = 0;
		for(int i = idx_1; i < s1.length(); i++) {
			int subMaxScore = 0;
			if(subRecord[i][idx_2] != 0) {
				subMaxScore = subRecord[i][idx_2];
			} else {
				for (int j = idx_2; j < s2.length(); j++) {
					if (s1.charAt(i) == s2.charAt(j)) {
						int curScore = s1.charAt(i) + s2.charAt(j) + recursion(s1, s2, i + 1, j + 1, record, subRecord);
						subMaxScore = Math.max(subMaxScore, curScore);
					}
				}
				subRecord[i][idx_2] = subMaxScore;
			}
			maxScore = Math.max(maxScore, subMaxScore);
		}
		record[idx_1][idx_2] = maxScore;
		return maxScore;
	}

	public int minimumDeleteSum(String s1, String s2) {
		int[][] record = new int[s1.length()][s2.length()];
		int[][] subRecord = new int[s1.length()][s2.length()];
		int totalScore = 0;
		for(int i = 0; i < s1.length(); i++) totalScore += s1.charAt(i);
		for(int i = 0; i < s2.length(); i++) totalScore += s2.charAt(i);
		return totalScore - recursion(s1, s2, 0, 0, record, subRecord);
	}
}
