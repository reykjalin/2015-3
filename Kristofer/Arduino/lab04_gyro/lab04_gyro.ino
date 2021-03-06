#include <MPU6050.h>
#include <math.h>
#include "Wire.h"
#include <LiquidCrystal_I2C.h>


// class default I2C address is 0x68
// specific I2C addresses may be passed as a parameter here
// AD0 low = 0x68 (default for InvenSense evaluation board)
// AD0 high = 0x69
MPU6050 accelgyro;
//MPU6050 accelgyro(0x69); // <-- use for AD0 high
LiquidCrystal_I2C lcd(0x27, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE);

int16_t ax, ay, az;
double g, xg, yg, zg;
int aPin = 0;
const int mid = 512;

////The setup function is called once at startup of the sketch
void setup()
{
	// join I2C bus (I2Cdev library doesn't do this automatically)
	Wire.begin();

	// initialize serial communication
	// (38400 chosen because it works as well at 8MHz as it does at 16MHz, but
	// it's really up to you depending on your project)
	Serial.begin(9600);
	lcd.begin(16,2);
	lcd.clear();

	// initialize device
	Serial.println("Initializing I2C devices...");
	accelgyro.initialize();

	// verify connection
	Serial.println("Testing device connections...");
	Serial.println(accelgyro.testConnection() ? "MPU6050 connection successful" : "MPU6050 connection failed");
}


// The loop function is called in an endless loop
void loop()
{
	/**
	 * Gyroscope, tilt sensor
	 */
	accelgyro.getAcceleration(&ax, &ay, &az);

	g = sqrt((double)ax*ax + (double)ay*ay + (double)az*az);
	xg = acos((double)ax / g) * 180.0 / PI;
	yg = acos((double)ay / g) * 180.0 / PI;
	zg = acos((double)az / g) * 180.0 / PI;

	Serial.print("g: "); Serial.println(g);
	Serial.print("xg: "); Serial.println(xg);
	Serial.print("yg: "); Serial.println(yg);
	Serial.print("zg: "); Serial.println(zg);
	Serial.println("");

	lcd.setCursor(0,0);
	lcd.print("xg: "); lcd.print((int)(xg + 0.5)); lcd.print("  ");
	lcd.setCursor(9,0);
	lcd.print("yg: "); lcd.print((int)(yg + 0.5)); lcd.print("  ");
	lcd.setCursor(0,1);
	lcd.print("zg: "); lcd.print((int)(zg + 0.5)); lcd.print("  ");

	/**
	 * Potentiometer, degrees from zero pos
	 */
	int read = analogRead(aPin);
	Serial.print("analog val: "); Serial.println(read);

	double deg = (read - 160) * 180.0/(875.0 - 160) - 90;
	if(deg < 0) {
		deg += 360;
	}

	Serial.print("rd: "); Serial.println(deg);
	lcd.print("rd: "); lcd.print(deg); lcd.print("  ");

	delay(100);
}
