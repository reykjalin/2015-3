/*
 * --------------- SVN info ---------------------
 * $Id: MorseElements.h 1208 2015-09-24 15:49:21Z freyja10 $
 * $HeadURL: https://repository.cs.ru.is/svn/t-411-mech-2015/submit/lab3/freyja10-roberto12-kristofert13-stefanv13/lab03/MorseElements.h $
 * $LastChangedDate: 2015-09-24 15:49:21 +0000 (Thu, 24 Sep 2015) $
 * $LastChangedRevision: 1208 $
 * $LastChangedBy: freyja10 $
 * ----------------------------------------------
 */

#ifndef MORSEELEMENTS_H_
#define MORSEELEMENTS_H_

#include <Arduino.h>

class MorseElements {
	private:
		int pin;
		unsigned int dotTime;
		unsigned int lstRsTm;
		unsigned int lstFlTm;
		int frstDlta;
		int currState;
		int lstState;

		// Events and flags
		int waitForRise = 1;
		int risingEdge = 3;
		int fallingEdge = 4;

		int noEvent = 0;
		int noFlag = -1;
		int buttonPressed = 2;

		int EOCDetected = 5;
		int EOWDetected = 8;
		int EOCWaitRise = 3;
		int EOCWaitFall = 4;

		int charSpaceDetected = 3;
		int wordSpaceDetected = 4;

		int endOfWordFlag = 7;
		int endOfCharacterFlag = 14;
		int badSpaceFlag = 22;
		int badPulseFlag = 23;
		
		int calCompleted = 10;
		int calCompletedFlag = 11;
		int calWaitFall = 2;
		int calWaitRise = 1;
		int calInProgress = 21;

		int dotDetected = 1;
		int dashDetected = 2;

		int decodeWaitFall = 6;
		int decodeWaitRise = 5;
		
	public:
		MorseElements(int p) : pin(p) { initialize(); };

		void startCalibration();
		int chkMorseEvnts();
		int morseElementsSM(int evnt, int time);
		int testCalibration();
		int characterizeSpace();
		int characterizePulse();

		// Getter and setter for current state, 'currState'
		void setState(int state);
		int getState();

		// Getter and setter for last state, 'lstState'
		void setLstState(int state);
		int getLstState();

		// Getter and setter for last rise time, 'lstRsTm'
		void setLstRiseTime(unsigned int time);
		unsigned int getLstRiseTime();

		// Getter and setter for last fall time, 'lstFlTm'
		void setLstFallTime(unsigned int time);
		unsigned int getLstFallTime();

		// Getter for last pulse width
		unsigned int getPulseWidth();

		void initialize();
};

#endif /* MORSEELEMENTS_H_ */
