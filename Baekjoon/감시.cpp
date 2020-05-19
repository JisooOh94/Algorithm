#include <iostream>
#include <vector>
using namespace std;

struct Pos{ int x,y; Pos(int yy, int xx){ x = xx; y = yy; } };

vector<int> camera_id;
vector<int> camera_dir;
vector<Pos> camera_pos;
vector<vector<int> > map;

int y_size,x_size;

int min_blind = 9999999;

int calc_blind(){
	vector<vector<int> > cpy = map;
	for(int idx = 0; idx<camera_id.size(); idx++){
		switch(camera_id[idx]){
			case 1:
				switch(camera_dir[idx]){
					case 1:
						//위
						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
					case 2:
						//오른쪽
						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						break;
					case 3:
						//아래
						for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
					case 4:
						//왼쪽
						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						break;
				}
				break;

			case 2:
				//단축
				switch(camera_dir[idx]){
					case 1:
						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}

						for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}

						break;
					case 2:
						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}

						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}

						break;
					}
				break;

			case 3:
				switch(camera_dir[idx]){
					case 1:
						//위+ 오른쪽
						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}

						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}

						break;
					case 2:
						//오른쪽 + 아래
						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}

						for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
					case 3:
						//아래 + 왼쪽
						 for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}

						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						break;
					case 4:
						//왼쪽 + 위
						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}

						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
				}
				break;

			case 4:
				switch(camera_dir[idx]){
					case 1:
						//왼 + 오 + 위
						//왼쪽
						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						//오른쪽
						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						//위
						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
					case 2:
						// 위 + 오 + 아래
						//위
						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						//오른쪽
						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						//아래
						for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
					case 3:
						// 왼 + 아래 + 오
						//왼쪽
						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}

						//아래
						for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}

						//오른쪽
						for(int x = camera_pos[idx].x; x < x_size; x++){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						break;
					case 4:
						// 아래 + 왼 + 위
						//아래
						for(int y = camera_pos[idx].y; y < y_size; y++){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						//왼쪽
						for(int x = camera_pos[idx].x; 0 <= x ; x--){
							if(cpy[camera_pos[idx].y][x] == 6) break;
							cpy[camera_pos[idx].y][x] = 1;
						}
						//위
						for(int y = camera_pos[idx].y; y>=0; y--){
							if(cpy[y][camera_pos[idx].x] == 6) break;
							cpy[y][camera_pos[idx].x] = 1;
						}
						break;
				}
				break;

			case 5:
				//아래
				for(int y = camera_pos[idx].y; y < y_size; y++){
					if(cpy[y][camera_pos[idx].x] == 6) break;
					cpy[y][camera_pos[idx].x] = 1;
				}
				//왼쪽
				for(int x = camera_pos[idx].x; 0 <= x ; x--){
					if(cpy[camera_pos[idx].y][x] == 6) break;
					cpy[camera_pos[idx].y][x] = 1;
				}
				//위
				for(int y = camera_pos[idx].y; y>=0; y--){
					if(cpy[y][camera_pos[idx].x] == 6) break;
					cpy[y][camera_pos[idx].x] = 1;
				}
				for(int x = camera_pos[idx].x; x < x_size; x++){
					if(cpy[camera_pos[idx].y][x] == 6) break;
					cpy[camera_pos[idx].y][x] = 1;
				}
				break;
		}
	}
	int cnt = 0;
	for(int y = 0; y < y_size; y++)
		for(int x = 0; x<x_size; x++)
			if(cpy[y][x] == 0) cnt++;

	return cnt;
}



void set_dir(int n){
	if(n==camera_id.size()){
		int rst = calc_blind();

		if(rst < min_blind) min_blind = rst;
		return;
	}

	if(camera_id[n] == 1 || camera_id[n] == 3 || camera_id[n] == 4)
		for(int i = 0; i<4; i++){
			camera_dir[n] = i+1;
			set_dir(n+1);
		}
	else if(camera_id[n] == 2)
		for(int i = 0; i<2; i++){
			camera_dir[n] = i+1;
			set_dir(n+1);
		}

	else if(camera_id[n] == 5)	set_dir(n+1);
}

int main()
{
	cin >> y_size >> x_size;

	map.resize(y_size,vector<int>(x_size,0));

	int data;

	for(int y = 0; y<y_size; y++)
		for(int x = 0; x<x_size; x++)
		{
			cin >> data;
			if(data == 6) map[y][x] = 6;
			else if(data != 0){
				Pos np(y,x);
				camera_id.push_back(data);
				camera_pos.push_back(np);
			}
		}
	camera_dir.resize(camera_id.size());

	set_dir(0);

	cout << min_blind;
}