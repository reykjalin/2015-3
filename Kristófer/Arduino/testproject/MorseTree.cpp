#include "MorseTree.h"

MorseTree::MorseTree() {
	// dot = 100, dash = 300 thus root node is 200
	int rkey[SL] = {200, 0, 0, 0, 0, 0};
	root = new MorseNode("", rkey);

	String data;

	data = "E";
	int ekey[SL] = {100, 0, 0, 0, 0, 0};
	this->add(data, ekey, root);

	data = "I";
	int ikey[SL] = {100, 100, 0, 0, 0, 0};
	this->add(data, ikey, root);

	data = "S";
	int skey[SL] = {100, 100, 100, 0, 0, 0};
	this->add(data, skey, root);

	data = "H";
	int hkey[SL] = {100, 100, 100, 100, 0, 0};
	this->add(data, hkey, root);

	data = "5";
	int fivekey[SL] = {100, 100, 100, 100, 100, 0};
	this->add(data, fivekey, root);

	data = "4";
	int fourkey[SL] = {100, 100, 100, 100, 300, 0};
	this->add(data, fourkey, root);

	data = "V";
	int vkey[SL] = {100, 100, 100, 300, 0, 0};
	this->add(data, vkey, root);

	data = "Ŝ";
	int sskey[SL] = {100, 100, 100, 300, 100, 0};
	this->add(data, sskey, root);

	data = "3";
	int threekey[SL] = {100, 100, 100, 300, 300, 0};
	this->add(data, threekey, root);

	data = "U";
	int ukey[SL] = {100, 100, 300, 0, 0, 0};
	this->add(data, ukey, root);

	data = "F";
	int fkey[SL] = {100, 100, 300, 100, 0, 0};
	this->add(data, fkey, root);

	data = "É";
	int eekey[SL] = {100, 100, 300, 100, 100, 0};
	this->add(data, eekey, root);

	data = "Ü";
	int uuukey[SL] = {100, 100, 300, 300, 0, 0};
	this->add(data, uuukey, root);

	data = "Ð";
	int ddkey[SL] = {100, 100, 300, 300, 100, 0};
	this->add(data, ddkey, root);

	data = "Ð";
	int qqkey[SL] = {100, 100, 300, 300, 100, 100};
	this->add(data, qqkey, root);

	data = "_";
	int uskey[SL] = {100, 100, 300, 300, 100, 300};
	this->add(data, uskey, root);

	data = "A";
	int akey[SL] = {100, 300, 0, 0, 0, 0};
	this->add(data, akey, root);

	data = "B";
	int bkey[SL] = {300, 100, 100, 100, 0, 0};
	this->add(data, bkey, root);
}

MorseTree::~MorseTree() {
	clear(root);
}
void MorseTree::clear(NodePtr node) {
	if(node != NULL) {
		clear(node->left);
		clear(node->right);
		delete node;
	}
}

String MorseTree::getData(int key[]) {
	return getData(root, key);
}
String MorseTree::getData(NodePtr node, int key[]) {
	if(node != NULL) {
		for(int i = 0; i < SL; i++) {
			if(key[i] < node->key[i]) {
				getData(node->left, key);
			} else if(key[i] > node->key[i]) {
				getData(node->right, key);
			}
		}
		return node->data;
	}
	return "";
}

void MorseTree::add(String data, int key[], NodePtr node) {
	if(node != NULL) {
		for(int i = 0; i < SL; i++) {
			if(key[i] < node->key[i]) {
				add(data, key, node->left);
			} else if(key[i] > node->key[i]) {
				add(data, key, node->right);
			}
		}
	} else {
		node = new MorseNode(data, key);
	}
}

// void MorseTree::print() {
// 	print(root);
// }
// void MorseTree::print(NodePtr node) {
// 	if(node != NULL) {
// 		print(node->left);
// 		cout << node->data << endl;
// 		print(node->right);
// 	}
// }
