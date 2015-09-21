#include "MorseTree.h"

MorseTree tree;

//The setup function is called once at startup of the sketch
void setup()
{
	Serial.begin(9600);
// Add your initialization code here
}

// The loop function is called in an endless loop
void loop()
{
//Add your repeated code here
	int key[SL] = {100,0,0,0,0,0};
	Serial.println(tree.getData(key));
}
