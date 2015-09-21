#ifndef MORSENODE_H
#define MORSENODE_H

#include <Arduino.h>

const int SL = 6;

struct MorseNode {
	String data;
	String key;
	MorseNode* left;
	MorseNode* right;

	MorseNode() : data(""), key(""), left(NULL), right(NULL) { }
	MorseNode(String d, String k, MorseNode* r = NULL, MorseNode* l = NULL)
	: data(d), key(k), left(l), right(r) { }
};
typedef MorseNode* NodePtr;

#endif
