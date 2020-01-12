#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int from;
int to;
int minTime = 0;
int maxSize = 100000;
vector<bool> isVisited(maxSize + 1, false);

int* makeNextPoint(int curPoint) {
	int* arr = new int[3];
	arr[0] = curPoint + 1;
	arr[1] = curPoint - 1;
	arr[2] = curPoint * 2;

	return arr;
}

void BFS() {
	queue<int> q;
	q.push(from);

	while (!q.empty()) {
		int size = q.size();
		minTime++;
		
		for(int i = 0; i<size; i++) {
			int curPoint = q.front(); q.pop();
			
			int* nextPoints = makeNextPoint(curPoint);

			for (int j = 0; j < 3; j++) {
				if (0 <= nextPoints[j] && nextPoints[j] <= maxSize && !isVisited[nextPoints[j]]) {
					if (nextPoints[j] == to) {
						return;
					}
					q.push(nextPoints[j]);
					isVisited[nextPoints[j]] = true;
				}
			}

			delete[] nextPoints;
		}
	}
}

int main()
{
	cin >> from >> to;

	if (from == to) {
		cout << 0;
		return 0;
	}

	BFS();

	cout << minTime;
}
