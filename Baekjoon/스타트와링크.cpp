#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int size;
vector<int> team_B;
vector<int> team_A;

vector<vector<int> > ability;
int min_ = 999999;

bool debug = false;
void DFS(int idx){
	if(idx == size /2){
		team_B.clear();

		int A_E = 0;

		for(int i = 0; i<size/2-1; i++)
			for(int j = i+1; j<size/2; j++)
				A_E += ability[team_A[i]][team_A[j]] + ability[team_A[j]][team_A[i]];


		int B_E = 0;
		int idx = 0;
		for(int i = 0; i<size; i++){
			if(idx < team_A.size() && team_A[idx] == i){
				idx ++;
				continue;
			}
			team_B.push_back(i);
		}

		for(int i = 0; i<size/2-1; i++)
			for(int j = i+1; j<size/2; j++)
				B_E += ability[team_B[i]][team_B[j]] + ability[team_B[j]][team_B[i]];

		int gap = abs(A_E - B_E);

		if(gap < min_)
			min_ = gap;

		return;
	}

	for(int i = team_A[idx - 1] + 1; i <= size - (size/2 - idx); i++){
		team_A[idx] = i;
		DFS(idx + 1);
	}
}

int main(){
	cin >> size;
	team_A.resize(size/2);
	ability.resize(size,vector<int>(size,0));

	for(int y = 0; y<size; y++)
		for(int x = 0; x<size; x++)
			cin >> ability[y][x];


	for(int i = 0; i<= size - (size/2); i++){
		team_A[0] = i;
		DFS(1);
	}

	cout << min_;
}