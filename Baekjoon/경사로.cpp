#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

vector<vector<int> > map;
int length;
int size;
vector<bool> visited;
int cnt = 0;

bool checkX(int prev, int y, int x){
	if(abs(prev - map[y][x])!=1) return false;
	if(prev < map[y][x]){
		if(x - length >= 0){
			for(int idx = x - 1; x-length <= idx; idx--)
				if(visited[idx] || map[y][idx] != prev) return false;
			}

		else
			return false;
	}
	else if(map[y][x] < prev){
		if(x + length - 1 < size){
			for(int idx = x; idx < x+length; idx++)
				if(visited[idx] || map[y][idx] != map[y][x]) return false;
			}

		else
			return false;
	}

	return true;
}

bool checkY(int prev, int y, int x){
	if(abs(prev - map[y][x])!=1) return false;

	if(prev < map[y][x]){
		if(y - length >= 0){
			for(int idx = y - 1; y-length <= idx; idx--)
				if(visited[idx] || map[idx][x] != prev) return false;
			}
		else
			return false;
	}
	else if(map[y][x] < prev){
		if(y + length - 1 < size){
			for(int idx = y; idx < y+length; idx++)
				if(visited[idx] || map[idx][x] != map[y][x])
					return false;
				}

		else
			return false;
	}

	return true;
}

void countWay(){
	for(int y = 0; y<size; y++){
		visited.clear();
		visited.resize(size,false);
		int prev = map[y][0];

		for(int x = 1; x<=size; x++){
			if(x == size){
				cnt++;
				break;
			}

			if(prev != map[y][x]){
				if(checkX(prev,y,x)){
					if(prev < map[y][x])
						for(int i = x-1; x-length <= i; i--)
							visited[i] = true;
					else
						for(int i = x; i < x + length; i++)
							visited[i] = true;
				}
				else break;
			}
			prev = map[y][x];
		}
	}

	for(int x = 0; x<size; x++){
		visited.clear();
		visited.resize(size,false);
		int prev = map[0][x];

		for(int y = 1; y<=size; y++){
			if(y == size){
				cnt++;
				break;
			}

			if(prev != map[y][x]){
				if(checkY(prev,y,x)){
					if(prev < map[y][x])
						for(int i = y-1; y-length <= i; i--)
							visited[i] = true;
					else
						for(int i = y; i < y + length; i++)
							visited[i] = true;
				}
				else break;
			}

			prev = map[y][x];
		}
	}

}

int main(){
	cin >> size >> length;
	map.resize(size,vector<int>(size));
	visited.resize(size,false);

	for(int y = 0; y<size; y++){
		for(int x = 0; x<size; x++){
			cin >> map[y][x];
		}
	}

	countWay();

	cout << cnt;
}