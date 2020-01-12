#include <iostream>
#include <vector>

using namespace std;

vector<int> glassAmt;
int selectMax;
int glassTotal;

int findMax(int idx, int amt, int continueCnt, int selectCnt) {
	int maxAmt = amt;
	if (continueCnt < 2) {
		maxAmt = findMax(idx + 1, amt + glassAmt[idx + 1], continueCnt + 1, selectCnt + 1);
	}

	for (int i = idx + 2; i < glassTotal - (selectMax - (selectCnt)); i++) {
		int tempMax = findMax(i, amt + glassAmt[i], 1, selectCnt + 1);
		if (tempMax > maxAmt) {
			maxAmt = tempMax;
		}
	}
	return maxAmt;
}

int main()
{
	cin >> glassTotal;
	glassAmt.resize(glassTotal, 0);
	selectMax = glassTotal - (glassTotal / 3);

	for (int i = 0; i < glassTotal; i++) {
		cin >> glassAmt[i];
	}

	cout << findMax(0, glassAmt[0], 1, 1);
}