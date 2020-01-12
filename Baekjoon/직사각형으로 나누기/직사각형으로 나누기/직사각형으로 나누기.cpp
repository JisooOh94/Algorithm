#include <iostream>

using namespace std;

int width, height;
long subPartSize, mainPartSize;

long maxMult = -1;
int** map;

struct Point {
	int x, y;
	Point(int xx, int yy) {
		x = xx;
		y = yy;
	}
};

long getSize(Point lt, Point rb) {
	long size = 0;
	for (int y = lt.y; y <= rb.y; y++) {
		for (int x = lt.x; x <= rb.x; x++) {
			size += map[y][x];
		}
	}
	return size;
}

void case_1() {
	long sizeA = 0;
	long sizeB = 0;
	long sizeC = 0;
	for (int i = 0; i < height - 2; i++) {
		Point ltA(0, i);
		Point rbA(width - 1, i);
		sizeA += getSize(ltA, rbA);
		subPartSize = mainPartSize - sizeA;
		sizeB = 0;
		for (int j = i + 1; j < height - 1; j++) {
			Point ltB(0, j);
			Point rbB(width - 1, j);
			sizeB += getSize(ltB, rbB);
			sizeC = subPartSize - sizeB;

			long mult = sizeA * sizeB * sizeC;
			if (mult > maxMult) {
				maxMult = mult;
			}
		}
	}
}

void case_2() {
	long sizeA = 0;
	long sizeB = 0;
	long sizeC = 0;
	for (int i = 0; i < width - 2; i++) {
		Point ltA(i, 0);
		Point rbA(i, height - 1);
		sizeA += getSize(ltA, rbA);
		subPartSize = mainPartSize - sizeA;
		sizeB = 0;
		for (int j = i + 1; j < width - 1; j++) {
			Point ltB(j, 0);
			Point rbB(j, height - 1);
			sizeB += getSize(ltB, rbB);
			sizeC = subPartSize - sizeB;

			long mult = sizeA * sizeB * sizeC;
			if (mult > maxMult) {
				maxMult = mult;
			}
		}
	}
}

void case_3() {
	long sizeA = 0;
	long sizeB = 0;
	long sizeC = 0;
	for (int i = 0; i < width - 1; i++) {
		Point ltA(i, 0);
		Point rbA(i, height - 1);
		sizeA += getSize(ltA, rbA);
		subPartSize = mainPartSize - sizeA;
		sizeB = 0;
		for (int j = 0; j < height - 1; j++) {
			Point ltB(i + 1, j);
			Point rbB(width - 1, j);
			sizeB += getSize(ltB, rbB);
			sizeC = subPartSize - sizeB;

			long mult = sizeA * sizeB * sizeC;
			if (mult > maxMult) {
				maxMult = mult;
			}
		}
	}
}

void case_4() {
	long sizeA = 0;
	long sizeB = 0;
	long sizeC = 0;
	for (int i = width - 1; 0 < i; i--) {
		Point ltA(i, 0);
		Point rbA(i, height - 1);
		sizeA += getSize(ltA, rbA);
		subPartSize = mainPartSize - sizeA;
		sizeB = 0;
		for (int j = 0; j < height - 1; j++) {
			Point ltB(0, j);
			Point rbB(i - 1, j);
			sizeB += getSize(ltB, rbB);
			sizeC = subPartSize - sizeB;

			long mult = sizeA * sizeB * sizeC;
			if (mult > maxMult) {
				maxMult = mult;
			}
		}
	}
}

void case_5() {
	long sizeA = 0;
	long sizeB = 0;
	long sizeC = 0;
	for (int i = 0; i < height - 1; i++) {
		Point ltA(0, i);
		Point rbA(width - 1, i);
		sizeA += getSize(ltA, rbA);
		subPartSize = mainPartSize - sizeA;
		sizeB = 0;
		for (int j = 0; j < width - 1; j++) {
			Point ltB(j, i + 1);
			Point rbB(j, height - 1);
			sizeB += getSize(ltB, rbB);
			sizeC = subPartSize - sizeB;

			long mult = sizeA * sizeB * sizeC;
			if (mult > maxMult) {
				maxMult = mult;
			}
		}
	}
}

void case_6() {
	long sizeA = 0;
	long sizeB = 0;
	long sizeC = 0;
	for (int i = height - 1; 0 < i; i--) {
		Point ltA(0, i);
		Point rbA(width - 1, i);
		sizeA += getSize(ltA, rbA);
		subPartSize = mainPartSize - sizeA;
		sizeB = 0;
		for (int j = 0; j < width - 1; j++) {
			Point ltB(j, 0);
			Point rbB(j, i - 1);
			sizeB += getSize(ltB, rbB);
			sizeC = subPartSize - sizeB;

			long mult = sizeA * sizeB * sizeC;
			if (mult > maxMult) {
				maxMult = mult;
			}
		}
	}
}

int main()
{
	string num;
	mainPartSize = subPartSize = 0;
	cin >> height >> width;
	map = new int*[height];
	
	for (int y = 0; y < height; y++) {
		map[y] = new int[width];
		cin >> num;
		for (int x = 0; x < width; x++) {
			map[y][x] = num.at(x) - '0';
			mainPartSize += map[y][x];
		}
	}

	case_1();
	case_2();
	case_3();
	case_4();
	case_5();
	case_6();

	cout << maxMult << endl;
}
