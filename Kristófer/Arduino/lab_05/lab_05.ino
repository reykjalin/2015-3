#include <LiquidCrystal.h>
#include "Enums.h"
#include <Wire.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
String inp;
String usr;

const int PAYLOAD = 4;
const int NODES = 5;
const int START_NODE = 1;
const int READ_DELAY = 1000;

int nodeData[PAYLOAD];

Enums SM;
FanState fanState = off;

/**
 * Initial setup
 */
void setup()
{
	lcd.clear();
	lcd.begin(16,2);
	lcd.setCursor(0,0);
	Serial.begin(9600);
	SM.setState(automatic);

	printState();
	Wire.begin();
}

/**
 * Program loop
 */
void loop()
{
	if(SM.getState() != automatic) {
		man_sm();
	} else {
		auto_sm();
	}
}

/**
 * Automatic State Machine code
 */
void auto_sm() {
	for(int i = START_NODE; i <= NODES; i++) {
		Wire.requestFrom(i, PAYLOAD);
		if(Wire.available() == PAYLOAD) {
			for(int j = 0; j < PAYLOAD; j++) {
				nodeData[j] = Wire.read();
			}
			for(int k = 0; k < PAYLOAD; k++) {
				Serial.println(nodeData[k]);
			}
		}
	}
	delay(READ_DELAY);
}

/**
 * State machines: 3 functions
 */
void man_sm() {
	switch(SM.getState()) {
		case readCmd:
			getInp();
			break;
		case cmdComplete:
			execCmd();
			printState();
			break;
		case readPwd:
			getPwd();
			break;
		case checkPwd:
			chkPwd();
			break;
		case logout:
			SM.setState(readUsr);
			printState();
			break;
		case readUsr:
			getUsr();
			break;
		case setFan:
			fanSpeed();
			break;
		case fanSet:
			fanSetState();
			break;
		default:
			break;
	}
}

void printState() {
	lcd.clear();
	switch(SM.getState()) {
		case readUsr:
			lcd.print("usr:");
			break;
		case setFan:
			lcd.print("#:setfan");
			lcd.setCursor(0,1);
			lcd.print("state:");
			break;
		case automatic:
			lcd.print("auto");
			break;
		default:
			lcd.print("#:");
			break;
	}
}

/**
 * Get user information and password: 3 functions
 */
void getUsr() {
	while(Serial.available()) {
		char inpChar = Serial.read();
		if(inpChar == '\n') {
			usr = inp;
			inp = "";
			SM.setState(readPwd);
			lcd.print(usr);
			lcd.setCursor(0,1);
			lcd.print("pwd:");
		} else {
			inp += inpChar;
		}
	}
}

void getPwd() {
	while(Serial.available()) {
		char inpChar = Serial.read();
		if(inpChar == '\n') {
			SM.setState(checkPwd);
		} else {
			inp += inpChar;
		}
	}
}

void chkPwd() {
	if(usr == "kristofer") {
		if(inp == "3.1415") {
			SM.setState(readCmd);
		} else {
			SM.setState(readUsr);
		}
	} else if(usr == "stefan") {
		if(inp == "frobert") {
			SM.setState(readCmd);
		} else {
			SM.setState(readUsr);
		}
	} else if(usr == "haukur") {
		if(inp == "thinkpad") {
			SM.setState(readCmd);
		} else {
			SM.setState(readUsr);
		}
	}
	else if(usr == "guest") {
		if(inp == "guest") {
			SM.setState(readCmd);
		}  else {
			SM.setState(readUsr);
		}
	} else {
		SM.setState(readUsr);
	}
	inp = "";
	printState();
}

/**
 * Read input from Serial console. Make sure it ends with NL
 */
void getInp() {
	while(Serial.available()) {
		char inpChar = Serial.read();
		if(inpChar == '\n') {
			SM.setState(cmdComplete);
		} else {
			inp += inpChar;
		}
	}
}

/**
 * Execute command stored in 'inp' variable
 */
void execCmd() {
	if(inp == "logout") {
		SM.setState(logout);
	} else if (inp == "whoami") {
		whoAmI();
	} else if(inp == "temp") {
		temp();
	} else if(inp == "setfan") {
		SM.setState(setFan);
	} else if(inp == "getfan") {
		getFan();
	} else if(inp == "auto") {
		SM.setState(automatic);
	} else if(inp == "manual") {
		SM.setState(readUsr);
	}
	else {
		lcd.print(inp); lcd.print("                ");
		SM.setState(readCmd);
		//lcd.setCursor(0,0);
		delay(1000);
	}
	inp = "";
	printState();
}

/**
 * What to do when 'whoami' command is executed
 */
void whoAmI() {
	lcd.print(inp);
	lcd.setCursor(0, 1);
	lcd.print(usr);
	delay(1500);
	SM.setState(readCmd);
}
void temp() {
	// get temperature
	lcd.print(inp);
	lcd.setCursor(0,1);
	lcd.print("20 C");
	delay(1500);
	SM.setState(readCmd);
}
void fanSpeed() {
	while(Serial.available()) {
		char inpChar = Serial.read();
		if(inpChar == '\n') {
			SM.setState(fanSet);
		} else {
			inp += inpChar;
		}
	}
}
void fanSetState() {
	if(inp == "off") {
		SM.setFanState(off);
	} else if(inp == "slow") {
		SM.setFanState(slow);
	} else if(inp == "normal") {
		SM.setFanState(normal);
	} else if(inp == "fast") {
		SM.setFanState(fast);
	}
	SM.setState(readCmd);
	printState();
	inp = "";
}
void getFan() {
	lcd.print(inp);
	lcd.setCursor(0,1);
	switch(SM.getFanState()) {
		case off:
			lcd.print("off");
			break;
		case slow:
			lcd.print("slow");
			break;
		case normal:
			lcd.print("normal");
			break;
		case fast:
			lcd.print("fast");
			break;
		default:
			break;
	}
	delay(1500);
}
