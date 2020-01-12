#include <iostream>

using namespace std;

int listSize;
long* numList;
int targetNum;
int listCount = 0;

void findNumList(int startIdx, int sum) {
	if (sum == targetNum) {
		listCount++;
	}
	for (int i = startIdx + 1; i < listSize; i++) {
		findNumList(i, sum + numList[i]);
	}
}

int main()
{
	cin >> listSize >> targetNum;

	numList = new long[listSize];

	for (int i = 0; i < listSize; i++) {
		cin >> numList[i];
	}

	for (int i = 0; i < listSize; i++) {
		findNumList(i, numList[i]);
	}

	cout << listCount;
}