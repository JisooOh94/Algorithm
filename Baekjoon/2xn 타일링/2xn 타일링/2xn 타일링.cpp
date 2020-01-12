#include <iostream>

using namespace std;

int result = 0;
int listLength = 0;

void fill(int startIdx) {
	if (startIdx == listLength) {
		result++;
		return;
	}

	if (startIdx + 2 <= listLength) {
		fill(startIdx + 2);
		fill(startIdx + 1);
	}
	else if (startIdx + 1 <= listLength) {
		fill(startIdx + 1);
	}
}

int main()
{
	cin >> listLength;

	fill(0);

	cout << result % 10007;
}
