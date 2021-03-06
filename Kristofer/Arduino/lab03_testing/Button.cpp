/*
 * --------------- SVN info ---------------------
 * $Id: Button.cpp 1216 2015-09-24 16:32:57Z kristofert13 $
 * $HeadURL: https://repository.cs.ru.is/svn/t-411-mech-2015/submit/lab3/freyja10-roberto12-kristofert13-stefanv13/lab03/Button.cpp $
 * $LastChangedDate: 2015-09-24 16:32:57 +0000 (Thu, 24 Sep 2015) $
 * $LastChangedRevision: 1216 $
 * $LastChangedBy: kristofert13 $
 * ----------------------------------------------
 */

#include "Button.h"

 void Button::setDeb(int value) {
 	debounce = value;
 }
 unsigned long Button::getDeb() {
 	return debounce;
 }

 void Button::setCurrState(int value) {
 	currBtnState = value;
 }
 int Button::getCurrState() {
 	return currBtnState;
 }

 void Button::setLstState(int value) {
 	lstBtnState = value;
 }
 int Button::getLstState() {
 	return lstBtnState;
 }

 void Button::setLstSmpl(int value) {
 	lstSmplTm = value;
 }
 unsigned long Button::getLstSmpl() {
 	return lstSmplTm;
 }

 void Button::initBut() {
 	// Initialize the port line to monitor the button
	pinMode(pin, INPUT);
	// Initialize button state and sample time
	setLstState(read());
	//setLstSmpl(millis());
 }

int Button::chkBtnEvnts() {
	int returnVal = 0;
//	if (getDeb() < millis() - getLstSmpl()) {
//		setCurrState(read());
//		if (getCurrState() != getLstState()) {
//			if (getCurrState() == HIGH) {
//				returnVal = HIGH;
//			}
//			else {
//				returnVal = LOW;
//			}
//			setLstState(getCurrState());
//			setLstSmpl(millis());
//		}
//	}
//	return returnVal;

//	if(debounce/*getDeb()*/ < millis() - lstSmplTm/*getLstSmpl()*/) {
//		//setCurrState(read());
//		currBtnState = digitalRead(pin);
//		if(lstBtnState != currBtnState/*getLstState() != getCurrState()*/) {
//			if(currBtnState == HIGH/*getCurrState() == HIGH*/) {
//				returnVal = HIGH;
//			} else {
//				returnVal = LOW;
//			}
//			lstBtnState = currBtnState;
//			lstSmplTm = millis();
//			//setLstState(getCurrState());
//			//setLstSmpl(millis());
//		}
//	}
	returnVal = read();
	return returnVal;
}

int Button::read() {
	return digitalRead(pin);
}
