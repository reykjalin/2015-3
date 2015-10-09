#include <iostream>
#include <string>

using namespace std;

char** initGrid(int x, int y);
void printBoard(char **grid, int x, int y);
bool nextStep(int &x, int &y, char dir, int n, int m);
bool chkPos(int x, int y, int n, int m);
void drawPath(char **grid, int x, int y, int n, int m);
void clear(char **grid, int y);

int main() {
	int n, m, x, y;

	cin >> n >> m >> x >> y;

	// Initialize grid
	char **grid = initGrid(n, m);
	grid[n - x - 1][y] = 'X';

	// Change path
	drawPath(grid, x, y, n, m);

	// Print grid
	printBoard(grid, n, m);

	// Release memory
	clear(grid, m);

	return 0;
}

char** initGrid(int x, int y) {
	char **grid = new char*[x];
	for(int i = 0; i < x; i++) {
		grid[i] = new char[y];
	}
	for(int i = 0; i < x; i++) {
		for(int j = 0; j < y; j++) {
			grid[i][j] = '.';
		}
	}
	return grid;
}

bool chkPos(int x, int y, int n, int m) {
	return (x < n && x >= 0 && y < m && y >= 0);
}

void drawPath(char **grid, int x, int y, int n, int m) {
	char dir;
	int k;
	cin >> k;
	for(int i = 0; i < k; i++) {
		cin >> dir;
		if(nextStep(x, y, dir, n, m)) {
			grid[n - x - 1][y] = 'o';
		} else {
			grid[n - x - 1][y] = '!';
			break;
		}
	}
}

bool nextStep(int &x, int &y, char dir, int n, int m) {
	if(dir == 'U') {
		if(chkPos(x + 1, y, n, m)){
			x++;
			return true;
		}
	} else if(dir == 'D') {
		if(chkPos(x - 1, y, n, m)) {
			x--;
			return true;
		}
	} else if(dir == 'R') {
		if(chkPos(x, y + 1, n, m)) {
			y++;
			return true;
		}
	} else if(dir == 'L') {
		if(chkPos(x, y - 1, n, m)) {
			y--;
			return true;
		}
	}
	return false;
}

void printBoard(char **grid, int x, int y) {
	for(int i = 0; i < x; i++) {
		for(int j = 0; j < y; j++) {
			cout << grid[i][j];
		}
		cout << endl;
	}
}

void clear(char **grid, int y) {
	for(int i = 0; i < y; i++) {
		delete[] grid[i];
	}

	delete[] grid;
}
