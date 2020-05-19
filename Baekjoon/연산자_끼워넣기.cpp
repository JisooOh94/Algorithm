#include <iostream>
#include <vector>
using namespace std;

int* num;
vector<int> opt;
int size;
int mmax = -999999999;
int mmin = 999999999;

void Recursion(vector<int> opt, int rst, int idx){
	if(opt.empty()){
		if(mmax < rst) mmax = rst;
		if(rst < mmin) mmin = rst;
		return;
	}

	vector<int> opt_cpy;
	int rst_cpy;

	bool visited[4] = {false,};

	for(int i = 0; i < opt.size(); i++){
		if(visited[opt[i]])
			continue;

		visited[opt[i]] = true;

		opt_cpy.clear();
		opt_cpy.assign(opt.begin(), opt.end());

		opt_cpy.erase(opt_cpy.begin() + i);

		switch(opt[i]){
			case 0:
				rst_cpy = rst + num[idx];
				break;
			case 1:
				rst_cpy = rst - num[idx];
				break;
			case 2:
				rst_cpy = rst * num[idx];
				break;
			case 3:
				rst_cpy = rst / num[idx];
				break;
		}

		Recursion(opt_cpy,rst_cpy,idx + 1);
	}
}

int main(){
	cin >> size;

	num = new int[size];

	for(int i = 0; i<size; i++)
		cin >> num[i];

	int n;

	for(int i = 0; i<4; i++){
		cin >> n;
		for(int j = 0; j<n; j++)
			opt.push_back(i);
	}


	Recursion(opt,num[0],1);

	cout << mmax << "  " << mmin << endl;
}