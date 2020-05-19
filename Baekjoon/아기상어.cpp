#include <iostream>
#include <vector>
#include <queue>
//#include <conio.h>
using namespace std;

struct pos{
	int x,y;
	pos(){};
	pos(int yy, int xx){ x = xx; y = yy;};
};

vector<vector<int> > map;
vector<vector<bool> > visited;

int map_size;

pos fish_pos;

int fish_size = 2;
int ate_cnt = 0;

int total_cnt = 0;

int BFS(){
	queue<pos> q;
	q.push(fish_pos);
	int cnt = 0;
	vector<pos> found;

	visited.clear();
	visited.resize(map_size,vector<bool>(map_size,false));
	//visited[fish_pos.y][fish_pos.x] = true;

	//cout << "<<<<<Info>>>>>>>" << endl;
	//cout << "fish size : " << fish_size <<endl;
	//cout << "ate fish : " << ate_cnt<<endl;

	while(q.size()!= 0){
		cnt++;
		int size = q.size();

		for(int i = 0; i<size; i++){
			pos cur = q.front(); q.pop();
			//cout << "from : " << cur.y << " " << cur.x << endl;

		//cout << "go left" << endl;
			//좌
			if(cur.x - 1 >= 0){
				if(!visited[cur.y][cur.x - 1]){
					if(map[cur.y][cur.x - 1] <= fish_size){
						if(map[cur.y][cur.x - 1] < fish_size && map[cur.y][cur.x - 1]!=0){
							pos np(cur.y,cur.x-1);
							found.push_back(np);
							//cout << "ate fish";
						}
						else{
							pos np(cur.y,cur.x-1);
							q.push(np);
							//cout << "just go";
						}
					}
					//else cout << "but failed - fish is big";
					visited[cur.y][cur.x - 1] = true;
				}
				//else cout << "but failed - already visited";
			}
			//else cout << "but failed - range exceed";
			//cout << endl;

			//우
			//cout << "go right" << endl;
			if(cur.x + 1 < map_size){
				if(!visited[cur.y][cur.x + 1]){
					if(map[cur.y][cur.x + 1] <= fish_size){
						if(map[cur.y][cur.x + 1] < fish_size && map[cur.y][cur.x + 1]!=0){
							pos np(cur.y,cur.x+1);
							found.push_back(np);
							//cout << "ate fish";
						}
						else{
							pos np(cur.y,cur.x+1);
							q.push(np);
							//cout << "just go";
						}
					}
					//else cout << "but failed - fish is big";
					visited[cur.y][cur.x + 1] = true;
				}
				//else cout << "but failed - already visited";
			}
			//else cout << "but failed - range exceed";
			//cout << endl;

			//위
			//cout << "go up" << endl;
			if(cur.y - 1 >= 0){
				if(!visited[cur.y - 1][cur.x]){
					if(map[cur.y - 1][cur.x] <= fish_size){
						if(map[cur.y - 1][cur.x] < fish_size && map[cur.y - 1][cur.x]!=0){
							pos np(cur.y-1,cur.x);
							found.push_back(np);
							//cout << "ate fish";
						}
						else{
							pos np(cur.y-1,cur.x);
							q.push(np);
							//cout << "just go";
						}
					}
					//else cout << "but failed - fish is big";
					visited[cur.y-1][cur.x] = true;
				}
				//else cout << "but failed - already visited";
			}
			//else cout << "but failed - range exceed";
			//cout << endl;
			//아래
			//cout << "go down" << endl;
			if(cur.y + 1 < map_size){
				if(!visited[cur.y + 1][cur.x]){
					if(map[cur.y + 1][cur.x] <= fish_size){
						if(map[cur.y + 1][cur.x] < fish_size && map[cur.y + 1][cur.x]!=0){
							pos np(cur.y + 1,cur.x);
							found.push_back(np);
							//cout << "ate fish";
						}
						else{
							pos np(cur.y + 1,cur.x);
							q.push(np);
							//cout << "just go";
						}
					}
					//else cout << "but failed - fish is big";
					visited[cur.y + 1][cur.x] = true;
				}
				//else cout << "but failed - already visited";
			}
				//else cout << "but failed - range exceed";
				//cout << endl;
		}
		if(found.size()!=0){
				pos min = found[0];

				for(int i = 1; i<found.size(); i++){
					if(found[i].y<min.y)
						min = found[i];

					else if(found[i].y == min.y){
						if(found[i].x < min.x)
							min = found[i];
					}
				}

				fish_pos = min;
				map[min.y][min.x] = 0;
				return cnt;
		}
	}
	return -1;
}

void count_life(){
	while(1){
		int rst = BFS();

		if(rst == -1) return;

		ate_cnt++;

		if(ate_cnt == fish_size){
			fish_size++;
			ate_cnt = 0;
		}
		/*
		cout << endl;

		for(int y = 0; y<map_size; y++){
			for(int x = 0; x<map_size; x++)
			{
				cout << map[y][x] << " ";
			}
			cout << endl;
		}

		cout << endl;
		getch();
		*/
		total_cnt += rst;
	}
}

int main()
{
	cin >> map_size;

	map.resize(map_size,vector<int>(map_size));
	visited.resize(map_size,vector<bool>(map_size,false));

	for(int y = 0; y<map_size; y++){
		for(int x = 0; x<map_size; x++)
		{
			cin >> map[y][x];
			if(map[y][x] == 9){
				pos np(y,x);
				fish_pos = np;
				map[y][x] = 0;
			}
		}
	}

	count_life();

	cout << total_cnt;
}