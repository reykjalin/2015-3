#ifndef MORSENODE_H
#define MORSENODE_H

#include <Arduino.h>

const int SL = 6;

struct MorseNode {
	String data;
	int key[SL];
	MorseNode* left;
	MorseNode* right;

	MorseNode() : data(""), left(NULL), right(NULL) {
		for(int i = 0; i < SL; i++) {
			key[i] = 0;
		}
	}
	MorseNode(String d, int k[], MorseNode* l = NULL, MorseNode* r = NULL)
	: data(d), left(l), right(r) {
		for(int i = 0; i < SL; i++) {
			key[i] = k[i];
		}
	}
};
typedef MorseNode* NodePtr;

#endif
