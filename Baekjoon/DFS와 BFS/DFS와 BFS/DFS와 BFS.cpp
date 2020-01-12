#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<vector<int> > map;
vector<bool> isVisited;
int nodeCnt;

void dfs(int node) {
	cout << node + 1 << " ";
	isVisited[node] = true;

	for (int i = 0; i < nodeCnt; i++) {
		if (map[node][i] == 1 && !isVisited[i]) {
			dfs(i);
		}
	}
}

void bfs(int startNode) {
	queue<int> q;
	q.push(startNode);
	isVisited[startNode] = true;
	int totalStep = 0;

	while (!q.empty()) {
		int size = q.size();
		totalStep++;
		for (int i = 0; i < size; i++) {
			int node = q.front(); q.pop();
			cout << node + 1 << " ";
			for (int j = 0; j < nodeCnt; j++) {
				if (map[node][j] == 1 && !isVisited[j]) {
					q.push(j);
					isVisited[j] = true;
				}
			}
		}
	}
}

int main()
{
	int edgeCnt;
	int startPoint;

	cin >> nodeCnt >> edgeCnt >> startPoint;

	map.resize(nodeCnt, vector<int>(nodeCnt, 0));
	isVisited.resize(nodeCnt, false);

	for (int i = 0; i < edgeCnt; i++) {
		int lv, rv;
		cin >> lv >> rv;

		map[lv-1][rv-1] = 1;
		map[rv-1][lv-1] = 1;
	}

	dfs(startPoint-1);

	cout << endl;

	isVisited.clear();
	isVisited.resize(nodeCnt, false);

	bfs(startPoint-1);
}