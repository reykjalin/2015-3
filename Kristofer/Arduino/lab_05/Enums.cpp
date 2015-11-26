/*
 * Enums.cpp
 *
 *  Created on: Oct 8, 2015
 *      Author: root
 */

#include "Enums.h"

void Enums::setState(State s) {
	state = s;
}

State Enums::getState() {
	return state;
}

void Enums::setFanState(FanState s) {
	fanstate = s;
}
FanState Enums::getFanState() {
	return fanstate;
}