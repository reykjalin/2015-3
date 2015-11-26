/*
 * --------------- SVN info ---------------------
 * $Id: Button.h 1216 2015-09-24 16:32:57Z kristofert13 $
 * $HeadURL: https://repository.cs.ru.is/svn/t-411-mech-2015/submit/lab3/freyja10-roberto12-kristofert13-stefanv13/lab03/Button.h $
 * $LastChangedDate: 2015-09-24 16:32:57 +0000 (Thu, 24 Sep 2015) $
 * $LastChangedRevision: 1216 $
 * $LastChangedBy: kristofert13 $
 * ----------------------------------------------
 */

#ifndef BUTTON_H_
#define BUTTON_H_

#include <Arduino.h>

class Button {
	private:
		unsigned long debounce;
		int pin;
		int lstBtnState;
		int currBtnState;
		unsigned long lstSmplTm;
	public:
		Button(int p) : debounce(0), pin(p), lstBtnState(LOW), currBtnState(LOW), lstSmplTm(millis()) { }

		// Getter & setter for 'debounce'
		void setDeb(int value);
		unsigned long getDeb();

		// Getter & setter for 'currBtnState', current button state
		void setCurrState(int value);
		int getCurrState();

		// Getter & setter for 'lstBtnState', last button state
		void setLstState(int value);
		int getLstState();

		// Getter & setter for 'lstSmplTm', last sample time
		void setLstSmpl(int value);
		unsigned long getLstSmpl();

		// Initialize the button
		void initBut();

		// Check button events
		int chkBtnEvnts();
		// Read button
		int read();
};

#endif /* BUTTON_H_ */
