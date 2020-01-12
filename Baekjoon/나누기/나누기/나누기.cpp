// 나누기.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
using namespace std;

int main()
{
	int N, F;
	cin >> N >> F;

	int midRst = N / 100 * 100 / F * F;
	if (midRst < N / 100 * 100) {
		midRst += F;
	}

	int rst = midRst % 100;
	if (rst < 10) {
		cout << "0";
	}
	cout << rst;

}