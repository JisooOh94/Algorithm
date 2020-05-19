#include <iostream>
#include <deque>
#include <vector>
#include <math.h>
using namespace std;

#define left_contact_idx 6
#define right_contact_idx 2

struct screwWay{
	int idx,dir;
	screwWay(){};
};

int screwState[4];
vector<deque<int> > Screw;
vector<screwWay> operation;
int operation_cnt;

void updateScrew(){
	for(int i = 0; i<4; i++){
		if(screwState[i]==0) continue;
		else if(screwState[i]==1){
			int move = Screw[i].back();
			Screw[i].pop_back();
			Screw[i].push_front(move);
		}
		else if(screwState[i]==-1){
			int move = Screw[i].front();
			Screw[i].pop_front();
			Screw[i].push_back(move);
		}
	}
}

void setOperation(int idx){
	screwState[operation[idx].idx] = operation[idx].dir;
	for(int i = operation[idx].idx; 1 <= i; i--){
		int left = *(Screw[i-1].begin() + right_contact_idx);
		int right = *(Screw[i].begin() + left_contact_idx);

		if(left == right) screwState[i-1] = 0;
		else screwState[i-1] = screwState[i] * -1;
	}

	for(int i = operation[idx].idx; i <= 2; i++){
		int left = *(Screw[i].begin() + right_contact_idx);
		int right = *(Screw[i+1].begin() + left_contact_idx);

		if(left == right) screwState[i+1] = 0;
		else screwState[i+1] = screwState[i] * -1;
	}
}

void getState(){
	deque<int>::iterator iter;

	for(int i = 0; i<operation_cnt; i++){
		setOperation(i);
		updateScrew();
	}
}

int main()
{
	Screw.resize(4);
	string str;
	for(int i = 0; i<4; i++){
		cin >> str;
		for(int j = 0; j<8; j++){
			Screw[i].push_back(str[j] - 48);
		}
	}

	cin >> operation_cnt;
	operation.resize(operation_cnt);

	int idx;

	for(int i = 0; i<operation_cnt; i++){
		cin >> idx >> operation[i].dir;
		operation[i].idx = idx - 1;
	}

	getState();

	int score = 0;

	for(int i = 0; i<4; i++)
		score += Screw[i].front() * pow(2,i);

	cout << score;
}
