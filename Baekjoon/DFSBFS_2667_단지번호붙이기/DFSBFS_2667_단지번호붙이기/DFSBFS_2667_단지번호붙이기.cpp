#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<vector<int> > map;
vector<vector<bool> > isVisited;
vector<int> countSum;
int mapSize;

struct Point {
	int x, y;
	Point(int yy, int xx) {
		x = xx;
		y = yy;
	}

	Point() {}
};

void makeNeighborP(Point* neighborP, Point p) {
	neighborP[0] = Point(p.y - 1, p.x);
	neighborP[1] = Point(p.y, p.x - 1);
	neighborP[2] = Point(p.y + 1, p.x);
	neighborP[3] = Point(p.y, p.x + 1);
}

bool checkRange(Point p) {
	if (0 <= p.x && p.x < mapSize &&
		0 <= p.y && p.y < mapSize) {
		return true;
	}
	return false;
}

void BFS(Point startP) {
	int count = 0;
	queue<Point> q;
	
	q.push(startP);
	isVisited[startP.y][startP.x] = true;
	count++;

	while (!q.empty()) {
		Point p = q.front(); q.pop();
		Point neighborP[4];
		makeNeighborP(neighborP, p);
		for (int i = 0; i < 4; i++) {
			if (checkRange(neighborP[i]) && !isVisited[neighborP[i].y][neighborP[i].x] && map[neighborP[i].y][neighborP[i].x] == 1) {
				q.push(neighborP[i]);
				isVisited[neighborP[i].y][neighborP[i].x] = true;
				count++;
			}
		}
	}

	countSum.push_back(count);
}

int main()
{
	cin >> mapSize;
	map.resize(mapSize, vector<int>(mapSize, 0));
	isVisited.resize(mapSize, vector<bool>(mapSize, false));

	for (int y = 0; y < mapSize; y++) {
		string str;
		cin >> str;
		for (int x = 0; x < mapSize; x++) {
			map[y][x] = str.at(x) - 48;
		}
	}

	for (int y = 0; y < mapSize; y++) {
		for (int x = 0; x < mapSize; x++) {
			if (map[y][x] == 1 && !isVisited[y][x]) {
				BFS(Point(y, x));
			}
		}
	}

	sort(countSum.begin(), countSum.end());

	cout << countSum.size() << endl;
	for (int i = 0; i < countSum.size(); i++) {
		cout << countSum[i] << endl;
	}
}