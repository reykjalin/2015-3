#ifndef MORSENODE_H
#define MORSENODE_H

//#include <Arduino.h>
#include <iostream>
#include <string>

using namespace std;

const int SL = 6;

struct MorseNode {
	string data;
	string key;
	MorseNode* left;
	MorseNode* right;

	MorseNode() : data(""), key(""), left(NULL), right(NULL) { }
	MorseNode(string d, string k, MorseNode* r = NULL, MorseNode* l = NULL)
	: data(d), key(k), left(l), right(r) { }
};
typedef MorseNode* NodePtr;

#endif
