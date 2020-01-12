#include <iostream>

int* day;
int* price;
int maxMoney = 0;
int maxDate;

using namespace std;

void recursion(int date, int money) {
	for (int i = date; i < maxDate; i++) {
		if (i + day[i] <= maxDate) {
			recursion(i + day[i], money + price[i]);
		}
	}
	if (money > maxMoney) {
		maxMoney = money;
	}
}

int main()
{
	cin >> maxDate;
	day = new int[maxDate];
	price = new int[maxDate];

	for (int i = 0; i < maxDate; i++) {
		cin >> day[i] >> price[i];
	}

	for (int i = 0; i < maxDate; i++) {
		recursion(i, 0);
	}

	cout << maxMoney;
}