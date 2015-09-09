#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>

using namespace std;

string getFname();
void openFile(ifstream& inp, string fname);
int nrLines(ifstream& inp);
int nrWords(ifstream& inp);
int nrChars(ifstream& inp);
void print(ostream& out);
void print(ostream& out, ifstream& inp, string fname);

int main() {
	ifstream inp;
	string fname = getFname();
	openFile(inp, fname);
	print(cout, inp, fname);
    return 0;
}

string getFname() {
	string fname;
	cin >> fname;
	return fname;
}
void openFile(ifstream& inp, string fname) {
	inp.open(fname.c_str());
	if(inp.fail()) {
		cout << "Couldn't open file" << endl;
		exit(1);
	}
}

int nrLines(ifstream& inp) {
	string line;
	int counter = 0;
	while(getline(inp, line)) {
		counter++;
	}
	return counter;
}

int nrWords(ifstream& inp) {
	string word;
	int counter = 0;
	while(inp >> word) {
		counter++;
	}
	return counter;
}

int nrChars(ifstream& inp) {
	char c;
	int counter = 0;
	while(inp.get(c)) {
		counter++;
	}
	return counter;
}

void print(ostream& out, ifstream& inp, string fname) {
	out << "Lines: " << nrLines(inp) << endl;
	inp.close();

	openFile(inp, fname);
	out << "Words: " << nrWords(inp) << endl;
	inp.close();

	openFile(inp,fname);
	out << "Chars: " << nrChars(inp) << endl;
}