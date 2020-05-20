package medium.ZigZag_Conversion;

/**
 * Time Complexity : O(n)
 */
public class Solution {
	public static String convert(String sample, int rowCnt) {
		if(rowCnt == 1) {
			return sample;
		}

		int blockSize = rowCnt * 2 - 2;
		int blockCnt = sample.length() / blockSize;
		int leftOver = sample.length() % blockSize;

		int rowElemCnt[] = new int[rowCnt];
		int rowStartIdx[] = new int[rowCnt];


		rowElemCnt[0] = rowElemCnt[rowCnt - 1] = blockCnt;

		for(int i = 1; i < rowCnt - 1; i++) {
			rowElemCnt[i] = blockCnt * 2;
		}

		int idx = 0;
		int inv = 1;
		for(int i = 0; i<leftOver; i++) {
			rowElemCnt[idx]++;
			if(i == blockSize / 2) {
				inv *= -1;
			}
			idx += inv;
		}

		int startIdx = 0;
		for(int i = 0; i < rowCnt; i++) {
			rowStartIdx[i] = startIdx;
			startIdx += rowElemCnt[i];
		}


		char[] resultStr = new char[sample.length()];

		int rowNum = 0;
		inv = 1;

		for(int i = 0; i < sample.length(); i++) {
			char targetChar = sample.charAt(i);
			resultStr[rowStartIdx[rowNum]] = targetChar;
			rowStartIdx[rowNum]++;

			if(i % (blockSize/2) == 0 && i != 0){
				inv *= -1;
			}

			rowNum += inv;
		}

		return String.valueOf(resultStr);
	}
}
