#include <iostream>
#include <vector>

using namespace std;

vector<vector<int> > map;
int y_size;
int x_size;
int e_size;

bool BFS(){
	for(int y = 0; y<y_size; y++){
		int cur = y;
		for(int x =  0; x<x_size; x++)
			cur += map[cur][x];
		if(cur != y) return false;
	}
	return true;
}

int col_line(){
	if(BFS()) return 0;

	for(int y = 0; y<y_size-1; y++){
		for(int x = 0; x<x_size; x++)
			if(map[y][x] == 0 && map[y+1][x] == 0){
				map[y][x] = 1;
				map[y+1][x] = -1;
				if(BFS()) return 1;
				map[y][x] = map[y+1][x] = 0;
		}
	}

	for(int y1 = 0; y1<y_size-1; y1++)
		for(int x1 = 0; x1<x_size; x1++)
			if(map[y1][x1] == 0 && map[y1+1][x1] == 0){
				map[y1][x1] = 1;
				map[y1+1][x1] = -1;

				for(int y2 = y1; y2<y_size-1; y2++)
					for(int x2 = 0; x2<x_size; x2++){
						if(y2 == y1 && x2 <= x1) continue;
						if(map[y2][x2] == 0 && map[y2+1][x2] == 0){
							map[y2][x2] = 1;
							map[y2+1][x2] = -1;
							if(BFS()) return 2;
							map[y2][x2] = map[y2+1][x2] = 0;
						}
					}
				map[y1][x1] = map[y1+1][x1] = 0;
			}

	for(int y1 = 0; y1<y_size-1; y1++){
		for(int x1 = 0; x1<x_size; x1++){
			if(map[y1][x1] == 0 && map[y1+1][x1] == 0){
				map[y1][x1] = 1;
				map[y1+1][x1] = -1;

				for(int y2 = y1; y2<y_size-1; y2++){
					for(int x2 = 0; x2<x_size; x2++){
						if(y2 == y1 && x2 <= x1) continue;
						if(map[y2][x2] == 0 && map[y2+1][x2] == 0){
							map[y2][x2] = 1;
							map[y2+1][x2] = -1;

							for(int y3 = y2; y3<y_size-1; y3++){
								for(int x3 = 0; x3<x_size; x3++){
									if(y3 == y2 && x3 <= x2) continue;
									if(map[y3][x3] == 0 && map[y3+1][x3] == 0){
										map[y3][x3] = 1;
										map[y3+1][x3] = -1;
										if(BFS()) return 3;
										map[y3][x3] = map[y3+1][x3] = 0;
									}
								}
							}
							map[y2][x2] = map[y2+1][x2] = 0;
						}
					}
				}
				map[y1][x1] = map[y1+1][x1] = 0;
			}
		}
	}

	return -1;
}

int main(){
	cin >> y_size >> e_size >> x_size;
	map.resize(y_size, vector<int>(x_size,0));

	int x,y;
	for(int i = 0; i<e_size; i++){
		cin >> x >> y;
		map[y - 1][x - 1] = 1;
		map[y][x - 1] = -1;
	}

	cout << col_line();
}