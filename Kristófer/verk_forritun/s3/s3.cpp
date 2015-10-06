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
	grid[x][y] = 'x';
	
	// Change path
	drawPath(grid, x, y, n, m);

	// Print grid
	printBoard(grid, n, m);

	// Release memory
	clear(grid, m);

	return 0;
}

char** initGrid(int x, int y) {
	char **grid = new char*[y];
	for(int i = 0; i < y; i++) {
		grid[i] = new char[x];
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
			grid[x][y] = 'o';
		} else {
			grid[x][y] = '!';
		}
	}
}

bool nextStep(int &x, int &y, char dir, int n, int m) {
	if(dir == 'u') {
		if(chkPos(x - 1, y, n, m)){
			x--;
			return true;
		}
	} else if(dir == 'd') {
		if(chkPos(x + 1, y, n, m)) {
			x++;
			return true;
		}
	} else if(dir == 'r') {
		if(chkPos(x, y + 1, n, m)) {
			y++;
			return true;
		}
	} else {
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