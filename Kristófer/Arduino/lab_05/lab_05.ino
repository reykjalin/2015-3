#include <LiquidCrystal.h>
#include "Enums.h"

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
String inp;
String usr;


Enums SM;

void setup()
{
	lcd.begin(16,2);
	lcd.setCursor(0,0);
	Serial.begin(9600);
	SM.setState(readUsr);
	printState();
}

void loop()
{
	man_sm();
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
		default:
			break;
	}
}

void auto_sm() {
	lcd.print("Automatic state.");
}

void printState() {
	lcd.clear();
	switch(SM.getState()) {
		case readUsr:
			lcd.print("usr:");
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
			lcd.print(usr); lcd.print("             ");
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
	} else if(usr == "guest") {
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