#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<long> stair;
vector<long> singleMaxScore;
vector<long> doubleMaxScore;

int stairSize;
int maxScore_ = -1;

#define SINGLE 1
#define DOUBLE 2

void getMax(int pos, long score, int continueCnt, int flag) {
	switch (flag) {
	case SINGLE:
		singleMaxScore[pos] = score;
		break;
	case DOUBLE:
		doubleMaxScore[pos] = score;
		break;
	}

	if (pos == stairSize) {
		return;
	}

	//1
	if (continueCnt + 1 < 3) {
		int newPos = pos + 1;
		if (!(newPos + 1 == stairSize && continueCnt + 1 == 2)) {
			if (score + stair[newPos] > singleMaxScore[newPos]) {
				getMax(newPos, score + stair[newPos], continueCnt + 1, SINGLE);
			}
		}
	}

	//2
	if (pos + 2 <= stairSize) {
		int newPos = pos + 2;
		if (score + stair[newPos] > doubleMaxScore[newPos]) {
			getMax(newPos, score + stair[newPos], 1, DOUBLE);
		}
	}
}

int main()
{
	cin >> stairSize;
	stair.resize(stairSize + 1, 0);
	singleMaxScore.resize(stairSize + 1, 0);
	doubleMaxScore.resize(stairSize + 1, 0);

	for (int i = 1; i <= stairSize; i++) {
		cin >> stair[i];
	}

	getMax(0, 0, 0, SINGLE);

	cout << max(singleMaxScore[stairSize], doubleMaxScore[stairSize]);
}
