#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
using namespace std;

struct Pos{
	int y, x;
	Pos(int yy, int xx){ y = yy; x= xx;}
};

int mapSize;
int Rmin,Rmax;
int cnt = 0;

vector<vector<int> > map;
vector<vector<Pos> > union_list;
vector<vector<bool> > visited;

void BFS(Pos sp){
	queue<Pos> q;
	vector<Pos> uni;
	q.push(sp);
	uni.push_back(sp);

	while(!q.empty()){
		Pos p = q.front(); q.pop();

		if(0 < p.x && !visited[p.y][p.x - 1]){
			int diff = abs(map[p.y][p.x] - map[p.y][p.x - 1]);

			if(Rmin <= diff && diff <= Rmax){
				Pos np(p.y, p.x - 1);

				q.push(np);
				uni.push_back(np);
				visited[np.y][np.x] = true;
			}
		}

		if(p.x < mapSize - 1 && !visited[p.y][p.x + 1]){
			int diff = abs(map[p.y][p.x] - map[p.y][p.x + 1]);

			if(Rmin <= diff && diff <= Rmax){
				Pos np(p.y, p.x + 1);

				q.push(np);
				uni.push_back(np);
				visited[np.y][np.x] = true;
			}
		}

		if(0 < p.y && !visited[p.y - 1][p.x]){
			int diff = abs(map[p.y][p.x] - map[p.y - 1][p.x]);

			if(Rmin <= diff && diff <= Rmax){
				Pos np(p.y - 1, p.x);

				q.push(np);
				uni.push_back(np);
				visited[np.y][np.x] = true;
			}
		}

		if(p.y < mapSize - 1 && !visited[p.y + 1][p.x]){
			int diff = abs(map[p.y][p.x] - map[p.y + 1][p.x]);

			if(Rmin <= diff && diff <= Rmax){
				Pos np(p.y + 1, p.x);

				q.push(np);
				uni.push_back(np);
				visited[np.y][np.x] = true;
			}
		}
	}

	if(uni.size() > 1) union_list.push_back(uni);
}

void getUnion(){
	for(int y = 0; y<mapSize; y++){
		for(int x = 0; x<mapSize; x++){
			if(!visited[y][x]){
				visited[y][x] = true;
				Pos sp(y,x);
				BFS(sp);
			}
		}
	}
}

void setPopulation(){
	for(int y = 0; y<union_list.size(); y++){
		int total = 0;
		for(int x = 0; x<union_list[y].size(); x++)
			total += map[union_list[y][x].y][union_list[y][x].x];

		int set = total / union_list[y].size();
		for(int x = 0; x<union_list[y].size(); x++)
			map[union_list[y][x].y][union_list[y][x].x] = set;
	}
}

int main()
{
	cin >> mapSize >> Rmin >> Rmax;

	map.resize(mapSize, vector<int>(mapSize, 0));

	for(int y = 0; y<mapSize; y++){
		for(int x = 0; x<mapSize; x++){
			cin >> map[y][x];
		}
	}
	while(1){
		union_list.clear();
		visited.clear();
		visited.resize(mapSize,vector<bool>(mapSize,false));

		getUnion();
		if(union_list.empty()) break;

		cnt++;

		setPopulation();
	}

	cout << cnt;
	return 0;
}