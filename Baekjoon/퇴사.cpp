#include <iostream>

using namespace std;

int d_size;
int* day;
int* price;
int Max_p = 0;

void DFS(int date, int profit){
	if(date + day[date] >= d_size){
		if(date + day[date] == d_size) profit += price[date];

		if(profit > Max_p) Max_p = profit;

		return;
	}

	int next_date = date + day[date];
	profit += price[date];

	for(int i = next_date; i < d_size; i++) DFS(i, profit);
}

int main(){
	cin >> d_size;
	day = new int[d_size];
	price = new int[d_size];

	for(int i = 0; i<d_size; i++){
		cin >> day[i];
		cin >> price[i];
	}

	for(int i = 0; i<d_size; i++)
		DFS(i, 0);
	cout << Max_p;
}