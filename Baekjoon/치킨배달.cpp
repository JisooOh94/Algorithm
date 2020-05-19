#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
struct Pos{ int x,y; Pos(int yy, int xx){ x = xx; y = yy; } };

int minRst = 99999;
vector<Pos> house;
vector<Pos> chick;
vector<int> past;
vector<vector<int> > dist;

int n,m;

void calcDist(){
	for(int i = 0; i<chick.size(); i++)
		for(int j = 0; j<house.size(); j++){
			dist[i][j] =
				abs(chick[i].x - house[j].x) +
					abs(chick[i].y - house[j].y);
		}
}

void DFS(int n){
	if(n == m){
		int rst = 0;
		for(int i = 0; i<house.size(); i++){
			int m_min = 99999;
			for(int j = 0; j < past.size(); j++)
				m_min = min(m_min,dist[past[j]][i]);
			rst += m_min;
		}
		if(rst < minRst) minRst = rst;
		return;
	}

	for(int i = past[n-1] + 1; i <= chick.size() - (m-n); i++){
		past[n] = i;
		DFS(n+1);
	}
}

int main()
{
	cin >> n >> m;
	int data;
	for(int y = 0; y < n; y++){
		for(int x= 0; x<n; x++)
		{
			cin >> data;
			if(data == 1){
				Pos np(y,x);
				house.push_back(np);
			}

			else if(data == 2){
				Pos np(y,x);
				chick.push_back(np);
			}
		}
	}

	dist.resize(chick.size(),vector<int>(house.size()));
	past.resize(m);

	calcDist();

	for(int i = 0; i<chick.size(); i++){
		past[0] = i;
		DFS(1);
	}

	cout << minRst;
}

/*
vector<int> arr;
vector<int> idx;
int size;
int n;

void make_Case(int l){
	if(l == n)
	{
		for(int i = 0; i<n; i++)
			cout << idx[i] << "  ";
		cout << endl;
		return;
	}

	for(int i = idx[l-1]+1; i <= size - (n-l); i++)
	{
		idx[l] = arr[i];
		make_Case(l+1);
	}
}

int main(){
	size = 4;
	n = 3;
	arr.resize(size);
	idx.resize(n);

	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 3;

	for(int i = 0; i<=size - n; i++)
	{
		idx[0] = arr[i];
		make_Case(1);
	}
}*/