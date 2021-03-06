#include <Wire.h>
#include <LiquidCrystal_I2C.h>
int aPin = 0;
const int mid = 512;
LiquidCrystal_I2C lcd(0x27, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE);

//The setup function is called once at startup of the sketch
void setup()
{
// Add your initialization code here
	Serial.begin(9600);
	lcd.begin(16,2);
	lcd.clear();
}

// The loop function is called in an endless loop
void loop()
{
//Add your repeated code here
	Serial.println(analogRead(aPin));



	int read = analogRead(aPin);
	double deg = (read - 160) * 180.0/(875.0 - 160) - 90;
	if(deg < 0) {
		deg += 360;
	}


	Serial.println(deg);
	lcd.print(deg);
	delay(500);
	lcd.setCursor(0,0);
}
