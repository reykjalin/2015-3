#include <iostream>

using namespace std;

int main() {
    // Verk 1
    /*int a,b,c;
    bool match = false;
    cin >> a >> b >> c;

    if(a + b == c) {
        cout << a << " + " << b << " = " << c << endl;
        match = true;
    }
    if (a - b == c) {
        cout << a << " - " << b << " = " << c << endl;
        match = true;
    }
    if (a * b == c) {
        cout << a << " * " << b << " = " << c << endl;
        match = true;
    }
    if(b != 0 && a / b == c) {
        cout << a << " / " << b << " = " << c << endl;
        match = true;
    }
    if(b != 0 && a % b == c) {
        cout << a << " % " << b << " = " << c << endl;
        match = true;
    }
    if(!match) {
        cout << "no match" << endl;
    }*/

    // Verk 2

    int sec, min, hrs, days, yrs;
    cin >> sec;

    // set sec
    min = sec / 60;
    sec %= 60;
    // set min
    hrs = min / 60;
    min %= 60;
    // set hrs
    days = hrs / 24;
    hrs %= 24;
    // set days
    yrs = days / 365;
    days %= 365;

    // print
    if(yrs > 0) {
        cout << yrs;
        if(yrs == 1) {
            cout << " year" << endl;
        } else {
            cout << " years" << endl;
        }
    } if(days > 0) {
        cout << days;
        if(days == 1) {
            cout << " day" << endl;
        } else {
            cout << " days" << endl;
        }
    } if(hrs > 0) {
        cout << hrs;
        if(hrs == 1) {
            cout << " hour" << endl;
        } else {
            cout << " hours" << endl;
        }
    } if(min > 0) {
        cout << min;
        if(min == 1) {
            cout << " minute" << endl;
        } else {
            cout << " minutes" << endl;
        }
    } if(sec > 0) {
        cout << sec;
        if(sec == 1) {
            cout << " second" << endl;
        } else {
            cout << " seconds" << endl;
        }
    }

    return 0;
}
