#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Pos{
	int x,y;
	Pos(int yy, int xx){ x = xx; y = yy;}
};

vector<vector<int> > map;
vector<Pos> wall;
vector<Pos> virus;

vector<Pos> min_wall;
int min_virus_area = 999999;
int x_size;
int y_size;
int empty_area = 0;

void BFS(vector<vector<int> > map){
	int virus_area = 0;
	queue<Pos> q;
	for(int i = 0; i<virus.size(); i++) q.push(virus[i]);

	while(!q.empty()){
		if(virus_area > min_virus_area) return;
		Pos p = q.front(); q.pop();

		//왼
		if(0 < p.x && map[p.y][p.x - 1] == 0){
			map[p.y][p.x - 1] = 2;
			virus_area++;

			Pos np(p.y, p.x - 1);
			q.push(np);
		}

		//오
		if(p.x < x_size - 1 && map[p.y][p.x + 1] == 0){
			map[p.y][p.x + 1] = 2;
			virus_area++;

			Pos np(p.y, p.x + 1);
			q.push(np);
		}

		//위
		if(0 < p.y && map[p.y - 1][p.x] == 0){
			map[p.y - 1][p.x] = 2;
			virus_area++;

			Pos np(p.y - 1, p.x);
			q.push(np);
		}

		//아래
		if(p.y < y_size - 1 && map[p.y + 1][p.x] == 0){
			map[p.y + 1][p.x] = 2;
			virus_area++;

			Pos np(p.y + 1, p.x);
			q.push(np);
		}
	}
	min_virus_area = virus_area;
}

void simulate(){
	for(int y1 = 0; y1<y_size; y1++){
		for(int x1 = 0; x1<x_size; x1++){
			if(map[y1][x1] == 0){
				Pos np(y1,x1);
				wall.push_back(np);

				for(int y2 = y1; y2 < y_size; y2++){
					for(int x2 = 0; x2 < x_size; x2++){
						if(y2 == y1 && x2 <= x1) continue;
						if(map[y2][x2] == 0){
							Pos np(y2,x2);
							wall.push_back(np);

							for(int y3 = y2; y3 < y_size; y3++){
								for(int x3 = 0; x3 < x_size; x3++){
									if(y3 == y2 && x3 <= x2) continue;
									if(map[y3][x3] == 0){
										Pos np(y3,x3);
										wall.push_back(np);
										vector<vector<int> > map_cpy;
										map_cpy.assign(map.begin(),map.end());
										for(int i = 0; i<3; i++) map_cpy[wall[i].y][wall[i].x] = 7;

										BFS(map_cpy);
										wall.pop_back();
									}
								}
							}
							wall.pop_back();
						}
					}
				}
				wall.pop_back();
			}
		}
	}
}


int main(){
	cin >> y_size >> x_size;

	map.resize(y_size,vector<int>(x_size,0));

	for(int y = 0; y<y_size; y++){
		for(int x = 0; x<x_size; x++){
			cin >> map[y][x];
			if(map[y][x] == 0) empty_area++;
			else if(map[y][x]==2){
				Pos np(y,x);
				virus.push_back(np);
			}
		}
	}
	simulate();
	cout << empty_area - min_virus_area - 3;
}