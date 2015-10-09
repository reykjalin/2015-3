/*
 * Enums.h
 *
 *  Created on: Oct 8, 2015
 *      Author: root
 */

#ifndef ENUMS_H_
#define ENUMS_H_

#include <Arduino.h>

enum CtrlState {
	automatic,
	manual
};
enum State {
	readCmd,
	cmdComplete,
	readPwd,
	checkPwd,
	logout,
	readUsr,
};

class Enums {
	public:


		void setState(State s);
		State getState();

	private:
		State state;
		CtrlState ctrl;
};

#endif /* ENUMS_H_ */
