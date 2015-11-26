/**
*	Lab02:		Soda dispenser
*	Authors:	Kristófer R. Þorláksson
*				Stefán Ó. Valdimarsson
*	Subject:	T411-MECH, Mechatronics 1
*	Due date:	2015/09/14
*	
*	Descr:		Simulates a soda dispenser. Interface has 6 buttons, 4 for ISK currency
*				going from coins 5 ISK to 100 ISK, 1 button for dispensing and 1 button
*				for a debugging mode.
*				When soda is dispensed the change is displayed, and an LED blinks 3 times.
*				After that relevant dispenser values are reset.
*				Debug mode displays analog value read from button input and the name of
*				the relevant button.
*
*	References:	Arduino examples for Analog input and the LiquidCrystal library.
*				Analog input: https://www.arduino.cc/en/Tutorial/AnalogInput
*				LiquidCrystal library: https://www.arduino.cc/en/Tutorial/HelloWorld
*/

#include <LiquidCrystal.h>

int btns = A5, ledpin = 13;
int last, lasttime, money;
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void blinkled();
void debug();

void setup() {
  	// Configure input and output
	pinMode(btns, INPUT);
	pinMode(ledpin, OUTPUT);
	digitalWrite(ledpin, LOW);
	money = 0;
	// LCD disp has 16 columns, 2 lines
  	lcd.begin(16,2);
  	lcd.print("Money:");
}

void loop() {
	int readbtns = analogRead(btns);

	// If input from buttons has changed significantly, check state
	if(last <= readbtns - 20 || last >= readbtns + 20) {
		// Choose button based on analog values
		if(readbtns > 50 && readbtns <= 130) {
			money += 5;
		} else if(readbtns > 130 && readbtns <= 210) {
			money += 10;
		} else if(readbtns > 470 && readbtns <= 550) {
			money += 50;
		} else if(readbtns > 640 && readbtns <= 720) {
			money += 100;
		} else if(readbtns > 880 && readbtns <= 970) {
			// Dispense if money >= 250
			if(money >= 250) {
				money -= 250;
				lcd.clear();
				lcd.print("Dispensing soda...");
				lcd.setCursor(0,1);
				lcd.print("Change: ");
				lcd.print(money);

				blinkled();
				
				lcd.clear();
				lcd.print("Money:");
				money = 0;
			} else {
				lcd.clear();
				lcd.print("Not enough money");
				// Blocking code so you can see the message
				delay(2000);
				lcd.clear();
				lcd.print("Money:");
			}
			
		} else if(readbtns > 970 && readbtns <= 1023) {
			// Enter debug mode
			debug();
			lcd.clear();
			lcd.print("Money:");
		}
	}

	// Make sure to write in line nr. 2 and print amount of money.
	// last = readbtns to check change in inputs
	lcd.setCursor(0,1);
	lcd.print(money);
	last = readbtns;
	readbtns = 0;
}

// Blinks LED 3 times
void blinkled() {
	for(int i = 0; i < 3; i++) {
		digitalWrite(ledpin, HIGH);
		delay(300);
		digitalWrite(ledpin, LOW);
		delay(300);
	}
}

// Debug mode
void debug() {
	lasttime = millis();
	
	int readbtns;

	// While buttons are being pressed, print analog values for buttons
	while(millis() - lasttime < 5000) {
		lcd.clear();
		lcd.print("Debug Mode");
		lcd.setCursor(0,1);
		readbtns = analogRead(btns);
		if(readbtns > 50 && readbtns <= 130) {
			lcd.print("Btn1: ");
			lasttime = millis();
		} else if(readbtns > 130 && readbtns <= 210) {
			lcd.print("Btn2: ");
			lasttime = millis();
		} else if(readbtns > 470 && readbtns <= 550) {
			lcd.print("Btn3: ");
			lasttime = millis();
		} else if(readbtns > 640 && readbtns <= 720) {
			lcd.print("Btn4: ");
			lasttime = millis();
		} else if(readbtns > 880 && readbtns <= 970) {
			// button #5
			lcd.print("Btn5: ");
			lasttime = millis();
		} else if(readbtns > 970 && readbtns <= 1023) {
			// button #6
			lcd.print("Btn6: ");
			lasttime = millis();
		}

		lcd.print(readbtns);
		readbtns = 0;
	}
}