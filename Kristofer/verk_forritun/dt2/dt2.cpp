#include <iostream>

using namespace std;

bool same(int x, int y) {
    return x == y;
}

int readReverse(int x) {
    int reversed = 0;
    while(x >= 10) {
        reversed *= 10;
        reversed += x % 10;;
        x /= 10;
    }
    reversed *= 10;
    reversed += x;
    return reversed;
}

int readNr() {
    int n;
    cin >> n;
    return n;
}

void print(int x) {
    if(same(x, readReverse(x))) {
        cout << x << " is a palindrome number" << endl;
    } else {
        cout << x << " is not a palindrome number" << endl;
    }
}

bool isPrime(int x) {
    if(x <= 0) {
        return false;
    }
    for(int i = 2; i < x / 2 + 1; i++) {
        if(x % i == 0) {
            return false;
        }
    }
    return true;
}

int getPrimeFactor(int x) {
    if(!isPrime(x)) {
        for(int i = 2; i < x / 2 + 1; i++) {
            if(x % i == 0) {
                return i;
            }
        }
    }
    return x;
}

int main() {
    //Dæmi 1
    int chkPal;
    chkPal = readNr();
    print(chkPal);

    // Dæmi 2
    /*int n;
    cin >> n;

    if(isPrime(n)) {
        cout << n;
    } else {
        cout << getPrimeFactor(n);
        while (getPrimeFactor(n) > 1) {
            n /= getPrimeFactor(n);
            if(getPrimeFactor(n) != 1) {
                cout << ", " << getPrimeFactor(n);
            }
        }
    }
    cout << endl;*/
    return 0;
}


