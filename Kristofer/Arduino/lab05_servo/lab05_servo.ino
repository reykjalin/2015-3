//#include <Servo.h>
//
//Servo servo;
//
//void setup()
//{
//	servo.attach(9);
//}
//
//void loop()
//{
//	servo.write(0);
//	delay(2000);
//	servo.write(180);
//	delay(2000);
//}

int pin = 10;

void setup() {
	//pinMode(pin, OUTPUT);
	Serial.begin(9600);
	analogWrite(pin, 0);
}

void loop() {
//	for(int i = 0; i < 255; i += 20) {
//		Serial.println(i);
//		analogWrite(pin, i);
//		delay(500);
//	}
//	delay(1000);
//	for(int i = 255; i >= 0; i -= 20) {
//		Serial.println(i);
//		analogWrite(pin, i);
//		delay(500);
//	}
//	delay(1000);

	analogWrite(pin, 120);
	delay(1500);
	analogWrite(pin, 0);
	delay(1500);
}
