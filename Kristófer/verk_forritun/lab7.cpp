#include <iostream>

using namespace std;

const int SIZE = 9;

void initGrid(char grid[], int l);
void print(char grid[], int l);
bool oWin(char grid[], int l);
bool xWin(char grid[], int l);
void gameLoop(char grid[], int l);
void printWinner(char grid[], int l);
bool legalMove(char grid[], int l, int n);

int main() {
    char grid[SIZE];
    initGrid(grid, SIZE);
    print(grid, SIZE);

    gameLoop(grid, SIZE);
    printWinner(grid, SIZE);

    return 0;
}

bool legalMove(char grid[], int l, int n) {
    return (n < 10 && n > 0) && (grid[n - 1] != 'O' && grid[n - 1] != 'X');
}

void printWinner(char grid[], int l) {
    cout << "Winner is: ";
    if(oWin(grid, l)) {
        cout << "O" << endl;
    } else {
        cout << "X" << endl;
    }
}

void gameLoop(char grid[], int l) {
    int xpos, opos;
    while(!oWin(grid, SIZE) && !xWin(grid, SIZE)) {
        cout << "X position: ";
        cin >> xpos;
        while(!legalMove(grid, l, xpos)) {
            cout << "Illegal move!" << endl;
            cout << "X position: ";
            cin >> xpos;
        }
        grid[xpos - 1] = 'X';

        print(grid, SIZE);

        if(!xWin(grid, SIZE)) {
            cout << "O position: ";
            cin >> opos;
            while(!legalMove(grid, l, opos)) {
                cout << "Illegal move!" << endl;
                cout << "O position: ";
                cin >> opos;
            }
            grid[opos - 1] = 'O';
            print(grid, SIZE);
        }
    }
}

bool oWin(char grid[], int l) {
    // Check lines
    if(grid[0] == 'O' && grid[1] == 'O' && grid[2] == 'O') {
        return true;
    } else if(grid[3] == 'O' && grid[4] == 'O' && grid[5] == 'O') {
        return true;
    } else if(grid[6] == 'O' && grid[7] == 'O' && grid[8] == 'O') {
        return true;
    } // Check columns
    else if(grid[0] == 'O' && grid[3] == 'O' && grid[6] == 'O') {
        return true;
    } else if(grid[1] == 'O' && grid[4] == 'O' && grid[7] == 'O') {
        return true;
    } else if(grid[2] == 'O' && grid[5] == 'O' && grid[8] == 'O') {
        return true;
    } // Check diagonals
    else if(grid[0] == 'O' && grid[4] == 'O' && grid[8] == 'O') {
        return true;
    } else if(grid[6] == 'O' && grid[4] == 'O' && grid[2] == 'O') {
        return true;
    }
    return false;
}
bool xWin(char grid[], int l) {
    // Check lines
    if(grid[0] == 'X' && grid[1] == 'X' && grid[2] == 'X') {
        return true;
    } else if(grid[3] == 'X' && grid[4] == 'X' && grid[5] == 'X') {
        return true;
    } else if(grid[6] == 'X' && grid[7] == 'X' && grid[8] == 'X') {
        return true;
    } // Check columns
    else if(grid[0] == 'X' && grid[3] == 'X' && grid[6] == 'X') {
        return true;
    } else if(grid[1] == 'X' && grid[4] == 'X' && grid[7] == 'X') {
        return true;
    } else if(grid[2] == 'X' && grid[5] == 'X' && grid[8] == 'X') {
        return true;
    } // Check diagonals
    else if(grid[0] == 'X' && grid[4] == 'X' && grid[8] == 'X') {
        return true;
    } else if(grid[6] == 'X' && grid[4] == 'X' && grid[2] == 'X') {
        return true;
    }
    return false;
}

void initGrid(char grid[], int l) {
    char val = 49; // 49 = ascii value of 1
    for(int i = 0; i < SIZE; i++) {
        grid[i] = val++;
    }
}

void print(char grid[], int l) {
    for(int i = 0; i < SIZE; i++) {
        if(i % 3 == 0) {
            cout << endl;
        }
        cout << grid[i] << " ";
    }
    cout << endl;
}
