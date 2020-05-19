#include <iostream>
#include <queue>

using namespace std;

struct Pos{
	int rx,ry,bx,by,prev;
	Pos(int ryy, int rxx, int byy, int bxx) { rx = rxx; ry = ryy; bx = bxx; by = byy;}
};

struct T{
	int x,y;
};

vector<vector<int> > Map;
int x_size,y_size;
T target;
Pos start(0,0,0,0);

int count()
{
	int cnt = 0;
	queue<Pos> q;
	start.prev = 0;
	q.push(start);

	while(1){
		if(cnt > 9) return -1;
		if(q.size() == 0) return -1;

		cnt++;

		int size = q.size();

		for(int i = 0; i<size; i++){
			Pos cur = q.front(); q.pop();
			int rt,bt;
			//오른쪽
			if(cur.prev!=1 && cur.prev!=3){
				if(!((Map[cur.ry][cur.rx+1]==1 &&  Map[cur.by][cur.bx+1]==1)|| (cur.ry == cur.by && cur.rx+1 == cur.bx && Map[cur.ry][cur.rx+2]==1) || (cur.ry == cur.by && cur.bx+1 == cur.rx && Map[cur.ry][cur.bx+2]==1))){
					for(int x = cur.rx+1; x<x_size; x++)
						if(Map[cur.ry][x]==1){
							rt = x-1;
							break;
						}

					for(int x = cur.bx+1; x<x_size; x++)
						if(Map[cur.by][x]==1)
						{
							bt = x-1;
							break;
						}

					bool bfront = false;

					if(cur.ry == cur.by && rt == bt){
						if(cur.rx < cur.bx) {
							rt = bt-1;
							bfront = true;
						}
						else{
							if(!(cur.ry == target.y && rt==target.x))
								bt = rt-1;
						}
					}

					bool failed = false;

					if(target.y == cur.by && (cur.bx < target.x && target.x <= bt))
						failed = true;

					else if(target.y == cur.ry){
						if(cur.rx < target.x && target.x <= rt){
							return cnt;
						}
					}



					if(!failed){
						Pos np(cur.ry,rt,cur.by,bt);
						np.prev = 3;
						q.push(np);
					}
				}
			}
			//왼쪽
			if(cur.prev!=1 && cur.prev!=3){
				if(!((Map[cur.ry][cur.rx-1]==1 && Map[cur.by][cur.bx-1]==1)|| (cur.ry == cur.by && cur.rx-1 == cur.bx && Map[cur.ry][cur.rx-2]==1) || (cur.ry == cur.by && cur.bx-1 == cur.rx && Map[cur.by][cur.bx-2]==1))){
					for(int x = cur.rx-1; 0<=x; x--)
						if(Map[cur.ry][x]==1){
							rt = x+1;
							break;
						}

					for(int x = cur.bx-1; 0<=x; x--)
						if(Map[cur.by][x]==1)
						{
							bt = x+1;
							break;
						}

					bool bfront = false;

					if(cur.ry == cur.by && rt == bt){
						if(cur.bx < cur.rx) {
							rt = bt+1;
							bfront = true;
						}

						else
							if(!(cur.ry == target.y && rt==target.x))
								bt = rt+1;
					}

					bool failed = false;

					if(target.y == cur.by && (target.x < cur.bx && bt <= target.x))
						failed = true;

					else if(target.y == cur.ry){
						if( target.x < cur.rx && rt <= target.x){
							return cnt;
						}
					}



					if(!failed){
						Pos np(cur.ry,rt,cur.by,bt);
						np.prev = 1;
						q.push(np);
					}
				}
			}


			//위쪽
			if(cur.prev!=2 && cur.prev!=4){
				if(!((Map[cur.ry - 1][cur.rx]==1 && Map[cur.by - 1][cur.bx]==1) || (cur.rx == cur.bx && cur.ry-1 == cur.by && Map[cur.ry - 2][cur.rx]==1) || (cur.rx == cur.bx && cur.by-1 == cur.ry && Map[cur.by - 2][cur.bx]==1))){
					for(int y = cur.ry-1; 0<=y; y--)
						if(Map[y][cur.rx]==1){
							rt = y+1;
							break;
						}

					for(int y = cur.by-1; 0<=y; y--)
						if(Map[y][cur.bx]==1)
						{
							bt = y+1;
							break;
						}

					bool bfront = false;

					if(cur.rx == cur.bx && rt == bt){
						if(cur.by < cur.ry) {
							rt = bt+1;
							bfront = true;
						}

						else
							if(!(cur.rx == target.x && rt==target.y))
								bt = rt+1;
					}

					bool failed = false;

					if(target.x == cur.bx && (target.y < cur.by && bt <= target.y))
							failed = true;

					else if(target.x == cur.rx){
						if( target.y < cur.ry && rt <= target.y){
							return cnt;
						}
					}



					if(!failed){
						Pos np(rt,cur.rx,bt,cur.bx);
						np.prev = 2;
						q.push(np);
					}
				}
			}

			//아래쪽
			if(cur.prev!=2 && cur.prev!=4){
				if(!((Map[cur.ry + 1][cur.rx]==1 && Map[cur.by + 1][cur.bx]==1) || (cur.rx == cur.bx && cur.ry + 1 == cur.by && Map[cur.ry + 2][cur.rx]==1) || (cur.rx == cur.bx && cur.by + 1 == cur.ry && Map[cur.by + 2][cur.bx]==1))){
					for(int y = cur.ry+1; y<y_size; y++)
						if(Map[y][cur.rx]==1){
							rt = y-1;
							break;
						}

					for(int y = cur.by+1; y < y_size; y++)
						if(Map[y][cur.bx]==1)
						{
							bt = y-1;
							break;
						}

					bool bfront = false;

					if(cur.rx == cur.bx && rt == bt){
						if(cur.by > cur.ry) {
							rt = bt-1;
							bfront = true;
						}
						else
							if(!(cur.rx == target.x && rt==target.y))
								bt = rt-1;
					}

					bool failed = false;

					if(target.x == cur.bx && (target.y > cur.by && bt >= target.y))
							failed = true;

					else if(target.x == cur.rx){
						if( target.y > cur.ry && rt >= target.y){
							return cnt;
						}
					}

					if(!failed){
						Pos np(rt,cur.rx,bt,cur.bx);
						np.prev = 4;
						q.push(np);
					}
				}
			}
		}
	}
}

int main()
{
	cin >> y_size >> x_size;

	Map.resize(y_size,vector<int>(x_size,0));

	for(int y = 0; y< y_size; y++)
		for(int x = 0; x<x_size; x++){
			char ch;
			cin >> ch;
			if(ch == '#') Map[y][x] = 1;
			else if(ch == 'B'){
				start.bx = x;
				start.by = y;
			}
			else if(ch == 'R'){
				start.rx = x;
				start.ry = y;
			}
			else if(ch == 'O'){
				target.x = x;
				target.y = y;
			}
		}

	cout << count();
}