#include <iostream>
#include <deque>
#include <queue>
using namespace std;

struct Pos{
	int x,y;
	Pos(int yy, int xx){
		y = yy;
		x = xx;
	}
};

vector<vector<int> > map;
deque<Pos> snake;
queue<int> turnTime;
queue<int> turnDir;

int time = 0;
int dir = 1;
int mapSize;

void calcTime(){
	Pos head(0,0);
	snake.push_front(head);
	while(1){
		Pos newHead(0,0);

		switch(dir){
			case 1:
				newHead.x = head.x + 1;
				newHead.y = head.y;
				break;

			case 2:
				newHead.x = head.x;
				newHead.y = head.y + 1;
				break;

			case 3:
				newHead.x = head.x - 1;
				newHead.y = head.y;
				break;

			case 4:
				newHead.x = head.x;
				newHead.y = head.y - 1;
				break;
		}
		if(	newHead.x < 0 || mapSize == newHead.x ||
			newHead.y < 0 || mapSize == newHead.y ||
			map[newHead.y][newHead.x] == 1 ){
				return;
			}

		if(map[newHead.y][newHead.x] == 0){
			Pos tail = snake.back(); snake.pop_back();
			map[tail.y][tail.x] = 0;
		}
		snake.push_front(newHead);
		map[newHead.y][newHead.x] = 1;
		time++;

		if(time == turnTime.front()){
			dir += turnDir.front();
			if(dir == 0)
				dir = 4;
			else if(dir == 5)
				dir = 1;

			turnTime.pop();
			turnDir.pop();
		}

		head = newHead;
		/*
		for(int y = 0; y < mapSize; y++){
			for(int x = 0; x < mapSize; x++){
				cout << map[y][x] << " ";
			}
			cout << endl;
		}
		int kkk;
		cin >> kkk;
		*/
	}
}

int main(){
	int appleNum;
	cin >> mapSize;
	cin >> appleNum;

	map.assign(mapSize, vector<int>(mapSize, 0));

	int x,y;
	for(int i = 0; i<appleNum; i++){
		cin >> y >> x;
		map[y-1][x-1] = 2;
	}

	int cnt;
	int tTime;
	char dir;
	cin >> cnt;
	for(int i = 0; i<cnt; i++){
		cin >> tTime;
		cin >> dir;
		turnTime.push(tTime);
		if(dir == 'L')
			turnDir.push(-1);
		else
			turnDir.push(1);
	}

	calcTime();

	cout << time + 1 << endl;
}