#include <iostream>
#include <string>

using namespace std;

const int SIZE = 100;

void readNames(string names[], int nrnames);
void selectionSort(string array[], int length);
void print(string array[], int length);

int main() {
	int n;
	string names[SIZE];

	cin >> n;
	readNames(names, n);
	selectionSort(names, n);
	print(names, n);

	return 0;
}

void readNames(string names[], int nrnames) {
	for(int i = 0; i < nrnames; i++) {
		cin >> names[i];
		// first char uppercase, rest lowercase
		for(int j = 1; j < names[i].length(); j++) {
			names[i][j] = tolower(names[i][j]);
		}
		names[i][0] = toupper(names[i][0]);
	}
}

void selectionSort(string array[], int length)
{
    int i, j, min_index;
    string min_value, tmp;

    for (i = 0; i < length; i++)
    {
        min_value = array[i];
        min_index = i;

        for (j = i+1; j < length; j++)
        {
            if (array[j] < min_value)
            {
                min_value = array[j];
                min_index = j;
            }
        }

        if (min_value < array[i])
        {
            tmp = array[i];
            array[i] = min_value;
            array[min_index] = tmp;
        }
    }
}

void print(string array[], int length) {
	string last = "";

	for (int i = 0; i < length - 1; i++) {
		if(array[i] != last && array[i] != array[length - 1]) {
			cout << array[i] << ", ";
			last = array[i];
		}
	}

	if(array[length - 1] != last) {
		cout << array[length - 1] << endl;
	}
}