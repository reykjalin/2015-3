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
	//automatic,
	manual
};
enum State {
	readCmd,
	cmdComplete,
	readPwd,
	checkPwd,
	logout,
	readUsr,
	setFan,
	fanSet,
	automatic
};
enum FanState {
	off,
	slow,
	normal,
	fast
};

class Enums {
	public:


		void setState(State s);
		State getState();

		void setFanState(FanState s);
		FanState getFanState();

	private:
		State state;
		CtrlState ctrl;
		FanState fanstate;
};

#endif /* ENUMS_H_ */
