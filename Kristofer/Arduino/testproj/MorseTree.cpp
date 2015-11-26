#include "MorseTree.h"

MorseTree::MorseTree() {
	// dot = 100, dash = 300 thus root node is 200
	String data = "", key = "";
	root = new MorseNode(data, key);

	data = "E";
	key = ".";
	this->add(data, key, root);

	data = "I";
	key = "..";
	this->add(data, key, root);

	data = "S";
	key = "...";
	this->add(data, key, root);

	data = "H";
	key = "....";
	this->add(data, key, root);

	data = "5";
	key = ".....";
	this->add(data, key, root);

	data = "4";
	key = "....-";
	this->add(data, key, root);

	data = "V";
	key = "...-";
	this->add(data, key, root);

	data = "Ŝ";
	key = "...-.";
	this->add(data, key, root);

	data = "";
	key = "...-..";
	this->add(data, key, root);

	data = "$";
	key = "...-..-";
	this->add(data, key, root);

	data = "3";
	key = "...--";
	this->add(data, key, root);

	data = "U";
	key = "..-";
	this->add(data, key, root);

	data = "F";
	key = "..-.";
	this->add(data, key, root);

	data = "É";
	key = "..-..";
	this->add(data, key, root);

	data = "Ü";
	key = "..--";
	this->add(data, key, root);

	data = "Ð";
	key = "..--.";
	this->add(data, key, root);

	data = "?";
	key = "..--..";
	this->add(data, key, root);

	data = "_";
	key = "..--.-";
	this->add(data, key, root);

	data = "2";
	key = "..---";
	this->add(data, key, root);

	data = "A";
	key = ".-";
	this->add(data, key, root);

	data = "R";
	key = ".-.";
	this->add(data, key, root);

	data = "L";
	key = ".-..";
	this->add(data, key, root);

	data = "&";
	key = ".-...";
	this->add(data, key, root);

	data = "É";
	key = ".-..-";
	this->add(data, key, root);

	data = "\"";
	key = ".-..-.";
	this->add(data, key, root);

	data = "Ä";
	key = ".-.-";
	this->add(data, key, root);

	data = "+";
	key = ".-.-.";
	this->add(data, key, root);

	data = ".";
	key = ".-.-.-";
	this->add(data, key, root);

	data = "W";
	key = ".--";
	this->add(data, key, root);

	data = "P";
	key = ".--.";
	this->add(data, key, root);

	data = "Þ";
	key = ".--..";
	this->add(data, key, root);

	data = "Á";
	key = ".--.-";
	this->add(data, key, root);

	data = "at";
	key = ".--.-.";
	this->add(data, key, root);

 	//Serial.println("at");

	data = "J";
	key = ".---";
	this->add(data, key, root);

	//Serial.println("J");

	data = "-";
	key = ".---.";
	this->add(data, key, root);

	//Serial.println("min");

	data = "1";
	key = ".----";
	this->add(data, key, root);

	//Serial.println("Added 1");

	data = "\'";
	key = ".----.";
	this->add(data, key, root);

	//Serial.println("Added \'");

	data = "T";
	key = "-";
	this->add(data, key, root);

	data = "N";
	key = "-.";
	this->add(data, key, root);

	data = "D";
	key = "-..";
	this->add(data, key, root);

	data = "B";
	key = "-...";
	this->add(data, key, root);

	data = "6";
	key = "-....";
	this->add(data, key, root);

	data = "=";
	key = "-....-";
	this->add(data, key, root);

	data = "=";
	key = "-...-";
	this->add(data, key, root);

	data = "X";
	key = "-..-";
	this->add(data, key, root);

	data = "/";
	key = "-..-.";
	this->add(data, key, root);

	data = "K";
	key = "-.-";
	this->add(data, key, root);

	data = "C";
	key = "-.-.";
	this->add(data, key, root);

	data = "";
	key = "-.-.-";
	this->add(data, key, root);

	data = ";";
	key = "-.-.-.";
	this->add(data, key, root);

	data = "!";
	key = "-.-.--";
	this->add(data, key, root);

	data = "Y";
	key = "-.--";
	this->add(data, key, root);

	data = "Ĥ";
	key = "-.--.";
	this->add(data, key, root);

	data = "(";
	key = "-.--.-";
	this->add(data, key, root);
	data = ")";
	this->add(data, key, root);

	data = "M";
	key = "--";
	this->add(data, key, root);

	data = "G";
	key = "--.";
	this->add(data, key, root);

	data = "Z";
	key = "--..";
	this->add(data, key, root);

	data = "7";
	key = "--...";
	this->add(data, key, root);

	data = "";
	key = "--..-";
	this->add(data, key, root);

	data = ",";
	key = "--..--";
	this->add(data, key, root);

	data = "Q";
	key = "--.-";
	this->add(data, key, root);

	data = "O";
	key = "---";
	this->add(data, key, root);

	data = "Ö";
	key = "---.";
	this->add(data, key, root);

	data = "8";
	key = "---..";
	this->add(data, key, root);

	data = ":";
	key = "---...";
	this->add(data, key, root);

	data = "CH";
	key = "----";
	this->add(data, key, root);

	data = "9";
	key = "----.";
	this->add(data, key, root);

	data = "0";
	key = "-----";
	this->add(data, key, root);
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

String MorseTree::getData(String key) {
	return getData(root, key);
}
String MorseTree::getData(NodePtr node, String key) {
	if(node == root) {
		if(key.charAt(0) == '.') {
			return getData(node->right, key);
		} else if(key.charAt(0) == '-') {
			return getData(node->left, key);
		}
	} else if(node != NULL) {
		if(key.length() == node->key.length()) {
			return node->data;
		} else {
			if(key.charAt(node->key.length()) == '.') {
				return getData(node->right, key);
			} else if(key.charAt(node->key.length()) == '-') {
				return getData(node->left, key);
			}
		}
	}
	return "";
}

void MorseTree::add(String data, String key, NodePtr& node) {
	if(node != NULL) {
		if(node == root) {
			if(key.charAt(0) == '.') {
				add(data, key, node->right);
			} else if(key.charAt(0) == '-') {
				add(data, key, node->left);
			}
		} else {
			if(key.length() != node->key.length()) {
				if(key.charAt(node->key.length()) == '-') {
					add(data, key, node->left);
				} else if(key.charAt(node->key.length()) == '.') {
					add(data, key, node->right);
				}
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
