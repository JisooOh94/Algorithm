#include <iostream>
using namespace std;

struct Robot{
	int x,y;
	int dir;
};

int x_size;
int y_size;
int** map;
Robot r;

int cleaning(){
	int rst = 0;

	while(1){
		if(map[r.y][r.x] == 1) return rst;
		else if(map[r.y][r.x] == 0){ map[r.y][r.x] = 2; rst++; }

		int cnt = 0;
		bool found = false;
		while(1){
			if(found) break;
			else if(cnt == 4){
				switch(r.dir){
					case 0:
						r.y += 1;
						break;
					case 1:
						r.x -= 1;
						break;
					case 2:
						r.y -= 1;
						break;
					case 3:
						r.x += 1;
						break;
				}
				break;
			}

			cnt++;
			switch(r.dir){
				case 0:
					r.dir = 3;
					if(map[r.y][r.x - 1] == 0){
						r.x -= 1;
						found = true;
					}
					break;
				case 1:
					r.dir = 0;
					if(map[r.y - 1][r.x] == 0){
						r.y -= 1;
						found = true;
					}
					break;
				case 2:
					r.dir = 1;
					if(map[r.y][r.x + 1] == 0){
						r.x += 1;
						found = true;
					}
					break;
				case 3:
					r.dir = 2;
					if(map[r.y + 1][r.x] == 0){
						r.y += 1;
						found = true;
					}
					break;
			}
		}
	}
}


int main(){
	cin >> y_size >> x_size;
	map = new int*[y_size];
	for(int i = 0; i<y_size; i++) map[i] = new int[x_size];

	cin >> r.y >> r.x >> r.dir;

	for(int y = 0; y<y_size; y++)
		for(int x = 0; x<x_size; x++)
			cin >> map[y][x];

	cout << cleaning();
}