#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int> > map;
vector<vector<bool> > isVisited;
int countSum = 0;
int mapSize_X;
int mapSize_Y;

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
	if (0 <= p.x && p.x < mapSize_X &&
		0 <= p.y && p.y < mapSize_Y) {
		return true;
	}
	return false;
}

void BFS(Point startP) {
	int count = 0;
	queue<Point> q;

	q.push(startP);
	isVisited[startP.y][startP.x] = true;
	countSum++;

	while (!q.empty()) {
		Point p = q.front(); q.pop();
		Point neighborP[4];
		makeNeighborP(neighborP, p);
		for (int i = 0; i < 4; i++) {
			if (checkRange(neighborP[i]) && !isVisited[neighborP[i].y][neighborP[i].x] && map[neighborP[i].y][neighborP[i].x] == 1) {
				q.push(neighborP[i]);
				isVisited[neighborP[i].y][neighborP[i].x] = true;
			}
		}
	}
}

int main()
{
	int loop = 0;
	cin >> loop;
	for (int repeat = 0; repeat < loop; repeat++) {
		int count = 0;
		countSum = 0;
		cin >> mapSize_X >> mapSize_Y >> count;
		map.resize(mapSize_Y, vector<int>(mapSize_X, 0));
		isVisited.resize(mapSize_Y, vector<bool>(mapSize_X, false));

		for (int i = 0; i < count; i++) {
			int x, y;
			cin >> x >> y;
			map[y][x] = 1;
		}

		for (int y = 0; y < mapSize_Y; y++) {
			for (int x = 0; x < mapSize_X; x++) {
				if (map[y][x] == 1 && !isVisited[y][x]) {
					BFS(Point(y, x));
				}
			}
		}

		cout << countSum << endl;
		map.clear();
		isVisited.clear();
	}
}