/*
 * Morse.cpp
 * --------------- SVN info ---------------------
 * $Id: Morse.cpp 1208 2015-09-24 15:49:21Z freyja10 $
 * $HeadURL: https://repository.cs.ru.is/svn/t-411-mech-2015/submit/lab3/freyja10-roberto12-kristofert13-stefanv13/lab03/Morse.cpp $
 * $LastChangedDate: 2015-09-24 15:49:21 +0000 (Thu, 24 Sep 2015) $
 * $LastChangedRevision: 1208 $
 * $LastChangedBy: freyja10 $
 * ----------------------------------------------
 */

#include "Morse.h"

 char Morse::getLetter() {
 	for(int i = 0; i < 56; i++) {
 		if(this->morse[i] == morseSgnl) {
 			resetSgnl();
 			return legalchars.charAt(i);
 		}
 	}
 	resetSgnl();
 	return '\0';
 }

bool Morse::addDot() {
	if(!eoc()) {
		morseSgnl += ".";
		return 1;
	}
	return 0;
}
bool Morse::addDash() {
	if(!eoc()) {
		morseSgnl += "-";
		return 1;	
	}
	return 0;
}

void Morse::resetSgnl() {
	morseSgnl = "";
}

void Morse::setEOC(int value)  {
	eOfCharFlag = value;
}
int Morse::eoc() {
	return eOfCharFlag;
}

char Morse::testGet(String signal) {
	morseSgnl = signal;
	return getLetter();
}

String Morse::getMorse(char letter) {
	for(int i = 0; i < 55; i++) {
		if(letter == legalchars[i]) {
			return morse[i];
		}
	}
	return "N/F";
}

char Morse::getCharByIndex(int index) {
	return legalchars.charAt(index);
}