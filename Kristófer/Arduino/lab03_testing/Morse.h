/*
 * Morse.h
 *
 * --------------- SVN info ---------------------
 * $Id: Morse.h 1208 2015-09-24 15:49:21Z freyja10 $
 * $HeadURL: https://repository.cs.ru.is/svn/t-411-mech-2015/submit/lab3/freyja10-roberto12-kristofert13-stefanv13/lab03/Morse.h $
 * $LastChangedDate: 2015-09-24 15:49:21 +0000 (Thu, 24 Sep 2015) $
 * $LastChangedRevision: 1208 $
 * $LastChangedBy: freyja10 $
 * ----------------------------------------------
 */

#ifndef MORSE_H_
#define MORSE_H_

#include <Arduino.h>

class Morse {
	public:
		Morse() : morseSgnl(""), eOfCharFlag(0) { }

		// Add dot to morse signal 'morseSgnl'
		bool addDot();
		// Add dash to morse signal 'morseSgnl'
		bool addDash();
		// Setter for end of character flag 'eOfCharFlag'
		void setEOC(int value);
		// Getter for end of character flag 'eOfCharFlag'
		int eoc();

		// Reset morse signla 'morseSgnl'
		void resetSgnl();
		// Get letter from morse signal 'morseSgnl'
		char getLetter();
		char testGet(String signal);

		String getMorse(char letter);
		char getCharByIndex(int index);
	private:
		String morse[54] = { ".-", "-...", "-.-.", "-..", ".", "..-.","--.", "....","..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", 
			".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
			"..--..", ".-.-.-", "--..--", "---...", ".----.", "-....-" , "-..-." , "-.--.." ,"-.--.-", ".-..-.", "-...-" , "-.-.--" , ".--.--", ".-.-..",
			".-.-." , "-.-.-." , ".--.-.", "..--.-" };
		String legalchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890?.,:'-/()\"=!$&+;@_";
		String morseSgnl;
		int eOfCharFlag;
};

#endif /* MORSE_H_ */
