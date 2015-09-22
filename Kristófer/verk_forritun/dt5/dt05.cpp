#include <iostream>
#include <cstdlib>
#include <string>
#include <fstream>

using namespace std;

bool startSlash(string inp);
string addZero(string inp);
string removeDot(string inp);
string remUScore(string inp);
string addUCase(string inp);
string extToLow(string inp);

void openFile(ifstream& fin);
void writeFile(ofstream& fout);

int main() {
	ifstream fin;
	openFile(fin);	

	string inp = "", out = "";
	while(getline(fin, inp)) {
		if(!startSlash(inp)) {
			inp = addZero(inp);
			inp = removeDot(inp);
			inp = remUScore(inp);
			inp = addUCase(inp);
			inp = extToLow(inp);
		}
		out += inp + "\n";
	}

	ofstream fout;
	writeFile(fout);
	fout << out;

	fin.close();
	fout.close();
	return 0;
}

bool startSlash(string inp) {
	return inp.substr(0,2) == "//";
}

string addZero(string inp) {
	return "0" + inp;
}

string removeDot(string inp) {
	return inp.substr(0, inp.find(".")) + " - " + inp.substr(inp.find(".") + 1, inp.length());
}

string remUScore(string inp) {
	int pos = inp.find('_');
	while(pos > -1) {
		inp = inp.substr(0, pos) + " " + inp.substr(pos + 1, inp.length());
		pos = inp.find('_', pos + 1);
	}

	return inp;
}

string addUCase(string inp) {
	int pos = inp.find(' ') + 1;
	while(pos > 0) {
		inp[pos] = toupper(inp[pos]);
		pos = inp.find(' ', pos) + 1;
	}
	return inp;
}

string extToLow(string inp) {
	return inp.substr(0, inp.find("MP3")) + "mp3";
}

void openFile(ifstream& fin) {
	fin.open("songlist.txt");
	if(fin.fail()) {
		cout << "Couldn't open file." << endl;
		exit(1);
	}
}
void writeFile(ofstream& fout) {
	fout.open("prettysonglist.txt");
	if(fout.fail()) {
		cout << "Couldn't write to file." << endl;
		exit(-1);
	}
}