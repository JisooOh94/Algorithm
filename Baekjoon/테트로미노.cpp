#include <iostream>
#include <vector>
using namespace std;
int y_size;
int x_size;
int max_ = -9999;
vector<vector<int> > map;
int v_six_mask[8][3][2] = {
	{
		{1,0},
		{1,0},
		{1,1}
	},

	{
		{0,1},
		{0,1},
		{1,1}
	},

	{
		{1,1},
		{1,0},
		{1,0}
	},

	{
		{1,1},
		{0,1},
		{0,1}
	},

	{
		{1,0},
		{1,1},
		{0,1}
	},

	{
		{0,1},
		{1,1},
		{1,0}
	},

	{
		{1,0},
		{1,1},
		{1,0}
	},

	{
		{0,1},
		{1,1},
		{0,1}
	}
};

int h_six_mask[8][2][3] = {
	{
		{1,1,1},
		{0,0,1}
	},

	{
		{1,1,1},
		{1,0,0}
	},

	{
		{0,0,1},
		{1,1,1}
	},

	{
		{1,0,0},
		{1,1,1}
	},

	{
		{1,1,0},
		{0,1,1}
	},

	{
		{0,1,1},
		{1,1,0}
	},

	{
		{1,1,1},
		{0,1,0}
	},

	{
		{0,1,0},
		{1,1,1}
	}
};

void getmax(){
	for(int y = 0; y<y_size; y++){
		for(int x = 0; x<x_size; x++){
			//six_v
			if(x+1 < x_size && y+2 < y_size){
				for(int i = 0; i<8; i++){
					int sum = 0;
					for(int my = 0; my<3; my++){
						for(int mx = 0; mx<2; mx++){
							sum+= map[y+my][x+mx] * v_six_mask[i][my][mx];
						}
					}

					if(max_ < sum) max_ = sum;
				}
			}
			//six_h
			if(x+2 < x_size && y+1 < y_size){
				for(int i = 0; i<8; i++){
					int sum = 0;
					for(int my = 0; my<2; my++){
						for(int mx = 0; mx<3; mx++){
							sum+= map[y+my][x+mx] * h_six_mask[i][my][mx];
						}
					}

					if(max_ < sum) max_ = sum;
				}
			}
			//square
			if(x+1 < x_size && y+1 < y_size){
				int sum = map[y][x] + map[y+1][x] + map[y][x+1] + map[y+1][x+1];

				if(max_<sum) max_ = sum;
			}

			//bar_v
			if(y+3 < y_size){
				int sum = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+3][x];

				if(max_<sum) max_ = sum;
			}
			//bar_h
			if(x+3 < x_size){
				int sum = map[y][x] + map[y][x+1] + map[y][x+2] + map[y][x+3];

				if(max_<sum) max_ = sum;
			}
		}
	}
}


int main(){
	cin >> y_size >> x_size;
	map.resize(y_size,vector<int>(x_size));

	for(int y = 0; y<y_size; y++)
		for(int x = 0; x<x_size; x++)
			cin >> map[y][x];

	getmax();

	cout << max_;
}