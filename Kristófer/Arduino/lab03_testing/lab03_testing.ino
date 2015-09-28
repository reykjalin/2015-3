/*
 * Main code for arduino based morse decoder
 *
 * --------------- Group info -------------------
 * Freyja Yeatman
 * Kristofer Reykjalin
 * Robert Bjarnar
 * Stefan Oli
 * ----------------------------------------------
 *
 * --------------- SVN info ---------------------
 * $Id: lab03.ino 1221 2015-09-24 17:36:47Z kristofert13 $
 * $HeadURL: https://repository.cs.ru.is/svn/t-411-mech-2015/submit/lab3/freyja10-roberto12-kristofert13-stefanv13/lab03/lab03.ino $
 * $LastChangedDate: 2015-09-24 17:36:47 +0000 (Thu, 24 Sep 2015) $
 * $LastChangedRevision: 1221 $
 * $LastChangedBy: kristofert13 $
 * ----------------------------------------------
 */
#include "Morse.h"
#include <LiquidCrystal.h>
#include "Button.h"
#include "MorseElements.h"

Morse morse;
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
Button but(9);
MorseElements me(10);
int butState;

//The setup function is called once at startup of the sketch
void setup()
{
	// Add your initialization code here
	Serial.begin(9600);
	but.initBut();
	displayInit();
	//pinMode(10, INPUT);
}



// The loop function is called in an endless loop
void loop()
{
	/**
	 * Main function - undecided
	 */
	// Check for button events
//	if (but.chkBtnEvnts() == HIGH) {
//		me.startCalibration();
//	}
//	switch (me.chkMorseEvnts()) {
//		case 1: // dotDetected
//			morse.addDot();
//			break;
//		case 2: // dashDetected
//			morse.addDash();
//			break;
//		case 3: // charSpaceDetected
//			char alpha;
//			alpha = DecodeMorse();
//			if (alpha != '\0') {
//				write(alpha);
//			}
//			else {
//				write('?');
//			}
//			break;
//		case 4: // wordSpaceDetected
//			write(' ');
//			break;
//		default:
//			//write('');
//			break;
//	}
	int val = testCalibration(30, 70);
	lcd.print(val);
	lcd.print("            ");
	Serial.println(val);
	lcd.setCursor(0,0);
}

int testCalibration(int frstDlta, int pulse) {
	Serial.println("TestCalibration");
	int scndDlta;
	if (frstDlta == 0) {
		Serial.println("Set first delta as pulse width");
		frstDlta = pulse; // lastPulseWidth is assuming this is the most recent puse width
	}
	else {
		Serial.println("Set second delta as pulse width");
		scndDlta = pulse;
		if (100 * frstDlta / scndDlta <= 33) {
			Serial.println("First delta is dot time");
			//dotTime = frstDlta;;
			//return calCompleted;
			return frstDlta;
		}
		else if (100 * frstDlta / scndDlta >= 300) {
			Serial.println("Second delta is dot time");
			//dotTime = scndDlta;
			//return calCompleted;
			return scndDlta;
		}
		else { // prepare for next pulse
			Serial.println("First delta set as second delta in preperation for next pulse");
			frstDlta = scndDlta;
		}
	}
	//return calInProgress;
	return frstDlta;
}

int state = HIGH;
int lstState = LOW;
int lstRise = 0;

int risingEdge = 10;
int endOfCharacterFlag = 11;
int EOCDetected = 12;
int charSpaceDetected = 13;
int endOfWordFlag = 14;

int chkMorseEvnts() {
	// TODO: INITIALIZE 'noEvent', 'currentState', 'lastState', 'risingEdge', 'endOfCharacterFlag'
	// 					'EOCDetected', 'endOfWordFlag', 'EOWDetected', 'charSpaceDetected'
	//					'wordSpaceDeteced', 'fallingEdge', 'calCompletedFlag', 'calibrationCompleted',
	//					'dotDetected', 'dashDetected'
	Serial.println("Check morse events");
	if (state != lstState) {
		state = 2;
		if (state == HIGH) {
			// record current time as timeOfLastRise
			// does this mean timeOfLastRise = millis()
			// or currentTime = timeOfLastRise ??
			lstRise = millis();
			// Could I use timeOfLastRise in the function call instead of currentTime??
			int flag = morseElementsSM(risingEdge, lstRise);
			if (flag == endOfCharacterFlag) {
				Serial.println("end of character");
				morseElementsSM(EOCDetected, getLstRiseTime());
				return charSpaceDetected;
			}
			else if (flag == endOfWordFlag) {
				Serial.println("end of word");
				morseElementsSM(EOWDetected, getLstRiseTime());
				return wordSpaceDetected;
			}
		}
		else {
			setLstFallTime(millis());
			int flag = morseElementsSM(fallingEdge, getLstFallTime());
			if (flag == calCompletedFlag) {
				Serial.println("calcompleted");
				morseElementsSM(calCompleted, getLstFallTime());
				return noEvent;
			}
			else if (flag == dotDetected) {
				Serial.println("dot detected");
				return dotDetected;
			}
			else if (flag == dashDetected) {
				Serial.println("dash detected");
				return dashDetected;
			}
		}
		setLstState(getState());
	}
	return noEvent;
}

int morseElementsSM(int evnt, int time) {
	// currentEvent can be the following: risingEdge, fallingEdge, calibrationCompleted, EOCDetected, EOWDetected, buttonPressed
	// return value can be: All flags

	// TODO: INITIALIZE 'currentState', 'noFlag', 'risingEdge', 'currentTime', 'calWaitFall'
	//					'calibrationCompleted', 'EOCWaitRise', 'fallingEdge', 'calWaitRise',
	//					'EOCWaitFall', 'endOfCharacterFlag', 'endOfWordFlag', 'buttonPressed',
	//					'waitForRise', 'EOCDetected', 'decodeWaitFail', 'decodeWaitRise'
	// int nextState = getState();
	// based on the value of current state, which can take 6 values, we do something, let's use switch
	Serial.println("morseElementsSM");
	switch (getState()) {
	case 1: // currentState = calWaitRise
		Serial.println("Current state: calWaitRise");
		if (evnt == risingEdge) {
			setLstRiseTime(time);
			setLstState(getState());
			setState(calWaitFall);
		}
		if (evnt == calCompleted) {
			setLstState(getState());
			setState(EOCWaitRise);
		}
		break;
	case 2: // currentState is calWaitFall
		Serial.println("Current state: calWaitFall");
		if (evnt == fallingEdge) {
			setLstFallTime(time);
			setLstState(getState());
			setState(calWaitRise);
			if(testCalibration() == calCompleted) {
				return calCompletedFlag;
			}
		}
		break;
	case 3: // currentState = EOCWaitRise
		Serial.println("Current state: EOCWaitRise");
		if (evnt == risingEdge) {
			setLstRiseTime(time);
			setLstState(getState());
			setState(EOCWaitFall);
			// Some if function
			int charSpaceVal = characterizeSpace();
			if (charSpaceVal == endOfCharacterFlag || charSpaceVal == endOfWordFlag) {
				return endOfCharacterFlag;
			}
		}
		if (evnt == buttonPressed) {
			setLstState(getState());
			setState(calWaitRise);
			frstDlta = 0;
		}
		break;
	case 4: // currentState = EOCWaitFall
		Serial.println("Current state: EOCWaitFall");
		if (evnt == fallingEdge) {
			setLstFallTime(time);
			setLstState(getState());
			setState(EOCWaitRise);
		}
		if (evnt == buttonPressed) {
			setLstState(getState());
			setState(calWaitRise);
			frstDlta = 0;
		}
		if (evnt == EOCDetected) {
			setLstState(getState());
			setState(decodeWaitFall);
		}
		break;
	case 5: // currentState = decodeWaitRise
		Serial.println("Current state: decodeWaitRise");
		if (evnt == risingEdge) {
			setLstRiseTime(time);
			setLstState(getState());
			setState(decodeWaitFall);
			return characterizeSpace();
		}
		if (evnt == buttonPressed) {
			setLstState(getState());
			setState(calWaitRise);
			frstDlta = 0;
		}
		break;
	case 6: // currentState = decodeWaitFall
		Serial.println("Current state: decodeWaitFall");
		if (evnt == fallingEdge) {
			setLstFallTime(time);
			// nextState = decodeWaitRise;
			setLstState(getState());
			setState(decodeWaitRise);
			return characterizePulse();
		}
		if (evnt == buttonPressed) {
			// nextState = calWaitRise;
			setLstState(getState());
			setState(calWaitRise);
			frstDlta = 0;
		}
		break;
	}
	return noFlag;
}

// This function clears the morse string variable
void ClearMorseChar() {
	//morseString = "";
}

//
bool AddDot() {
	return morse.addDot();
}

bool AddDash() {
	return morse.addDash();
}

char DecodeMorse() {
	return morse.getLetter();
}

void displayInit() {
	lcd.clear();
	lcd.begin(16, 1);
	lcd.setCursor(0,0);
	//lcd.autoscroll();
}

// This function writes the character to the display - question is whether we only need to print out the word
void write(char value) {
	// Don't we need to specify the cursor placing if we are writing only the character to the display
	lcd.print(value);
}
