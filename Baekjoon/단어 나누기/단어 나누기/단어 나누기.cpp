// 단어 나누기.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

string str;

vector<int> point;
string result;

string revert() {
	string result;
	string sub = str.substr(0, point[1] + 1);
	reverse(sub.begin(), sub.end());
	result = sub;

	sub = str.substr(point[1] + 1, point[2] - point[1]);
	reverse(sub.begin(), sub.end());
	result += sub;

	sub = str.substr(point[2] + 1, str.length() - ( point[2] + 1 ));
	reverse(sub.begin(), sub.end());
	result += sub;

	return result;
}

void comp(string param) {
	if (result.empty()) {
		result = param;
	}
	else {
		if (result.compare(param) > 0) {
			result = param;
		}
	}
}

void findRange(int idx) {
	if (idx == 2) {
		comp(revert());
		return;
	}

	vector<int> temp;
	int min = point.back() + 1;
	temp.push_back(min);
	
	for (int i = min + 1; i < str.length() - (2 - idx); i++) {
		if (str.at(i) < str.at(min)) {
			min = i;
			temp.clear();
			temp.push_back(i);
		}
		else if (str.at(i) == str.at(min)) {
			temp.push_back(i);
		}
	}

	for (int i = 0; i < temp.size(); i++) {
		point.push_back(temp.at(i));
		findRange(idx + 1);
		point.pop_back();
	}
}

int main() {
	point.push_back(-1);
	cin >> str;
	findRange(0);
	cout << result;
}