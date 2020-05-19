#include <iostream>
#include <vector>
using namespace std;

char cubeOrg[6][9] = {
	{'w','w','w','w','w','w','w','w','w'},
	{'y','y','y','y','y','y','y','y','y'},
	{'b','b','b','b','b','b','b','b','b'},
	{'g','g','g','g','g','g','g','g','g'},
	{'r','r','r','r','r','r','r','r','r'},
	{'o','o','o','o','o','o','o','o','o'}
};

char cube[6][9];

int self_idx[9] = { 6,3,0,7,4,1,8,5,2 };
int neighbor_surf_idx[6][4] = {
	{5,2,4,3},	//0
	{5,3,4,2},	//1
	{0,5,1,4},	//2
	{0,4,1,5},	//3
	{0,2,1,3},	//4
	{0,3,1,2}	//5
};

int neighbor_elem_idx[6][4][3] = {

	{
		{2,1,0},
		{2,1,0},
		{2,1,0},
		{2,1,0}
	},//0

	{
		{6,7,8},
		{6,7,8},
		{6,7,8},
		{6,7,8}
	},//1

	{
		{8,5,2},
		{0,3,6},
		{0,3,6},
		{8,5,2}
	},//2

	{
		{0,3,6},
		{0,3,6},
		{8,5,2},
		{8,5,2}
	},//3

	{
		{6,7,8},
		{0,3,6},
		{6,7,8},
		{8,5,2}
	},//4

	{
		{2,1,0},
		{0,3,6},
		{2,1,0},
		{8,5,2}
	}//5
};

char prev_[3];

char Name[] = { 'U','D','R','L','F','B' };
void spin(int surf, bool dir) {
	/*
	cout << "Before Spin" << endl;
	for (int i = 0; i < 6; i++) {
		cout << Name[i] << endl;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				cout << cube[i][y*3 + x] << " ";
			}
			cout << endl;
		}
		cout << endl;
	}
	*/
	char cubeCpy[9];
	copy(cube[surf], cube[surf] + 9, cubeCpy);

	for (int i = 0; i < 3; i++)
		prev_[i] = cube[neighbor_surf_idx[surf][0]][neighbor_elem_idx[surf][0][i]];

	if (dir) {
		for (int i = 0; i < 9; i++)
			cube[surf][i] = cubeCpy[self_idx[i]];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 3)
					cube[neighbor_surf_idx[surf][0]][neighbor_elem_idx[surf][0][j]] = prev_[j];
				else {
					char temp = cube[neighbor_surf_idx[surf][i + 1]][neighbor_elem_idx[surf][i + 1][j]];
					cube[neighbor_surf_idx[surf][i + 1]][neighbor_elem_idx[surf][i + 1][j]] = prev_[j];
					prev_[j] = temp;
				}
			}
		}
	}
	else {
		for (int i = 0; i < 9; i++)
			cube[surf][i] = cubeCpy[8 - self_idx[i]];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 3)
					cube[neighbor_surf_idx[surf][0]][neighbor_elem_idx[surf][0][j]] = prev_[j];
				else {
					char temp = cube[neighbor_surf_idx[surf][3 - i]][neighbor_elem_idx[surf][3 - i][j]];
					cube[neighbor_surf_idx[surf][3 - i]][neighbor_elem_idx[surf][3 - i][j]] = prev_[j];
					prev_[j] = temp;
				}
			}
		}
	}
}

int main() {
	int loop;
	cin >> loop;
	for (int i = 0; i < loop; i++) {

		int cnt;
		int order;
		bool dir;
		string str;
		copy(&cubeOrg[0][0], &cubeOrg[0][0] + 6 * 9, &cube[0][0]);

		cin >> cnt;
		for (int j = 0; j < cnt; j++) {
			cin >> str;
			switch (str.at(0))
			{
			case 'U':
				order = 0;
				break;

			case 'D':
				order = 1;
				break;

			case 'R':
				order = 2;
				break;

			case 'L':
				order = 3;
				break;

			case 'F':
				order = 4;
				break;

			case 'B':
				order = 5;
				break;
			}

			if (str.at(1) == '+') {
				dir = true;
			}
			else
				dir = false;

			spin(order, dir);
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				cout << cube[0][3 * y + x];
			}
			cout << endl;
		}
	}
}