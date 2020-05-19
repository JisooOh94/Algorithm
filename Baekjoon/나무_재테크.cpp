#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<vector<int> > > tMap;
int** dMap;
int** nMap;
int** sMap;

int tYear;
int mSize;
int tCnt;

void Spring(){
	for(int y = 0; y<mSize; y++){
		for(int x = 0; x<mSize; x++){
			if(tMap[y][x].size() > 0){
				sort(tMap[y][x].begin(), tMap[y][x].end());

				for(int l = 0; l<tMap[y][x].size(); l++){
					if(tMap[y][x][l] <= nMap[y][x]){
						nMap[y][x] -= tMap[y][x][l];
						tMap[y][x][l]++;
					}
					else{
						for(int i = l; i< tMap[y][x].size(); i++)
							dMap[y][x] += tMap[y][x][i] / 2;
						tMap[y][x].erase(tMap[y][x].begin() + l,tMap[y][x].begin() + tMap[y][x].size());
						break;
					}
				}
			}
		}
	}
}

void Summer(){
	for(int y = 0; y<mSize; y++){
		for(int x = 0; x<mSize; x++){
			if(dMap[y][x]!=0){
				nMap[y][x] += dMap[y][x];
				dMap[y][x] = 0;
			}
		}
	}
}

void Fall(){
	for(int y = 0; y<mSize; y++){
		for(int x = 0; x<mSize; x++){
			if(tMap[y][x].size() != 0)
			{
				for(int l = 0; l<tMap[y][x].size(); l++){
					if(tMap[y][x][l] % 5 == 0){
						//왼
						if(0 < x)
							tMap[y][x - 1].push_back(1);
						//오
						if(x < mSize - 1)
							tMap[y][x + 1].push_back(1);

						//위
						if(0 < y)
							tMap[y - 1][x].push_back(1);

						//아래
						if(y < mSize - 1)
							tMap[y + 1][x].push_back(1);

						//왼 위
						if(0 < x && 0 < y)
							tMap[y - 1][x - 1].push_back(1);

						//왼 아래
						if(0 < x && y < mSize - 1)
							tMap[y + 1][x - 1].push_back(1);

						//오 위
						if(x < mSize - 1 && 0 < y)
							tMap[y - 1][x + 1].push_back(1);

						// 오 아래
						if(x < mSize - 1 && y < mSize - 1)
							tMap[y + 1][x + 1].push_back(1);
					}
				}
			}
		}
	}
}

void Winter(){
	for(int y = 0; y<mSize; y++)
		for(int x = 0; x<mSize; x++)
			nMap[y][x] += sMap[y][x];
}

int main(){
	cin >> mSize >> tCnt >> tYear;
	tMap.resize(mSize,vector<vector<int> >(mSize, vector<int>(0)));

	dMap = new int*[mSize];
	nMap = new int*[mSize];
	sMap = new int*[mSize];

	for(int i = 0; i<mSize; i++){
		dMap[i] = new int[mSize];
		nMap[i] = new int[mSize];
		sMap[i] = new int[mSize];
	}

	for(int y = 0; y<mSize; y++){
		for(int x = 0; x<mSize; x++)
		{
			cin >> sMap[y][x];
			nMap[y][x] = 5;
			dMap[y][x] = 0;
		}
	}

	for(int i = 0; i<tCnt; i++){
		int y,x,l;
		cin >> y >> x >> l;
		tMap[y-1][x-1].push_back(l);
	}

	int n = 0;
	while(n < tYear){
		n++;
		Spring();
		Summer();
		Fall();
		Winter();
	}

	int rst = 0;

	for(int y = 0; y<mSize; y++)
		for(int x = 0; x<mSize; x++)
			rst += tMap[y][x].size();

	cout << rst;
}