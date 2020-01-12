// FileOutput.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	int userCount = 200;
	ofstream outFile("C:\\Users\\USER\\Desktop\\" + to_string(userCount) + "명.txt");

	for (int i = 1; i <= userCount; i++) {
		outFile << i;
		if (i != userCount) {
			outFile << endl;
		}
	}

	outFile.close();
}
