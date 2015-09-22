#ifndef MORSETREE_H_
#define MORSETREE_H_

//#include <Arduino.h>
#include "MorseNode.h"

class MorseTree {
public:
	MorseTree();
	~MorseTree();

	void add(String data, String key, NodePtr& node);

	String getData(String key);
	// void print();
private:
	NodePtr root;

	String getData(NodePtr node, String key);

	// void print(NodePtr node);
	void clear(NodePtr node);
};

#endif
