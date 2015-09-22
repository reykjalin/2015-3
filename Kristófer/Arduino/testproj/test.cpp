#include <iostream>
#include "MorseTree (copy).h"
#include <string>

using namespace std;

int main() {
	MorseTree tree;

	string word = "";

	word += tree.getData("....");
	word += tree.getData(".");
	word += tree.getData(".-..");
	word += tree.getData(".-..");
	word += tree.getData("---");
	word += "";
	word += tree.getData(".--");
	word += tree.getData("---");
	word += tree.getData(".-.");
	word += tree.getData(".-..");
	word += tree.getData("-..");

	cout << word << endl;
}