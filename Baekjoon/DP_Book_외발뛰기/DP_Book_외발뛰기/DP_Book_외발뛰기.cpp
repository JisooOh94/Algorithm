#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > map;
vector<vector<bool> > visited;
int mapSize;
bool found = false;

struct Point {
	int x, y;

	Point(int yy, int xx) {
		x = xx;
		y = yy;
	}
};

void findWay(Point p) {
	if (found) {
		return;
	}
	else if (map[p.y][p.x] == 0) {
		found = true;
		return;
	}

	visited[p.y][p.x] = true;

	Point rP(p.y, p.x + map[p.y][p.x]);

	if (rP.x < mapSize && !visited[rP.y][rP.x]) {
		findWay(rP);
	}

	Point uP(p.y + map[p.y][p.x], p.x);

	if (uP.y < mapSize && !visited[uP.y][uP.x]) {
		findWay(uP);
	}
}

int main()
{
	int loop;
	cin >> loop;
	for (int i = 0; i < loop; i++) {
		found = false;
		cin >> mapSize;
		map.clear();
		visited.clear();
		map.resize(mapSize, vector<int>(mapSize, 0));
		visited.resize(mapSize, vector<bool>(mapSize, false));

		for (int y = 0; y < mapSize; y++) {
			for (int x = 0; x < mapSize; x++) {
				cin >> map[y][x];
			}
		}

		Point rP(0, map[0][0]);
		if (rP.x < mapSize && !visited[rP.y][rP.x]) {
			findWay(rP);
		}
		
		Point uP(map[0][0], 0);
		if (uP.y < mapSize && !visited[uP.y][uP.x]) {
			findWay(uP);
		}

		if (found) {
			cout << "YES";
		}
		else {
			cout << "NO";
		}
	}
}