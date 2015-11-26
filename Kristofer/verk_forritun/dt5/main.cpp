#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>
using namespace std;

void openFile(ifstream& InStream);
string getData(ifstream& InStream);
void write2File(ostream& Out, string output, int TrackNr);
void openwritefile(ofstream& Outstream, string thefilename);
string makeSpace(string input);
int getTrackNr(string input);
string getRidOfTrackNr(string input);
string upperCase(string input);

const string FILENAME = "C:/Users/Bubbi/Desktop/songlist.txt";
const string OUTFILENAME = "C:\\Users\\Bubbi\\Desktop\\prettysonglist.txt";
const int SIZEARRAY = 10;

int main()
{
    ifstream InStream;
    ofstream OutStream;
    openFile(InStream);
    openwritefile(OutStream, OUTFILENAME);
    string arr[SIZEARRAY];
    string locVar;
    string output;
    int NumberOfDigits = 0;
    int pos = 0;
    int pos2 = 0;
    int trackNr[SIZEARRAY];

    for(int i = 0; i < SIZEARRAY; i++)
    {
        arr[i] = getData(InStream);
    }

    for(int i = 0; i < SIZEARRAY; i++)
    {
        locVar = arr[i];
        if(locVar[0] == '/' && locVar[1] == '/')
        {
            OutStream << locVar << endl;
        }
        else
        {
            trackNr[i] = getTrackNr(locVar);
            locVar = getRidOfTrackNr(locVar);
            locVar = makeSpace(locVar);
            locVar = upperCase(locVar);
            locVar = locVar.substr(0, locVar.length()-3) + "mp3";
            arr[i] = locVar;
        }
    }
    for(int i = 1; i < SIZEARRAY; i++)
    {
        write2File(OutStream, arr[i], trackNr[i]);
    }

}


void openFile(ifstream& InStream)
{
    InStream.open(FILENAME.c_str());
    if(InStream.fail())
    {
        cout << "Gooooodaaaaaaam " << endl;
        exit(-1);
    }
}

void openwritefile(ofstream& OutStream, string thefilename)
{
    OutStream.open(thefilename.c_str());
    if (OutStream.fail())
    {
        cout << "can't open the file: " << thefilename << endl;
        exit(1);
    }
}

string getData(ifstream& InStream)
{
    string theReturn;
    getline(InStream, theReturn);
    return theReturn;
}

void write2File(ostream& Out, string output, int TrackNr)
{
    Out << TrackNr  << " - "<< output << endl;
}

string makeSpace(string input)
{
    int pos = input.find('_');
    while(pos >= 0)
    {
        input[pos] = ' ';
        pos = input.find('_');
    }
    return input;
}
int getTrackNr(string input)
{
    int pos = 0;
    int trackNr;
    while(isdigit(input[pos]))
    {
        pos++;
    }
    trackNr = atoi(input.substr(0,pos).c_str()); // atoi change str to int

   return trackNr;

}

string getRidOfTrackNr(string input)
{
    int pos = 0;
    int pos2 = 0;

    while(isdigit(input[pos]))
    {
        pos++;
    }
    pos2 = input.find_first_not_of("_-., ", pos);
    input = input.substr(pos2, input.length());
    return input;

}

string upperCase(string input)
{
    input[0] = toupper(input[0]);
    int pos = input.find_first_of(" ,-()\"", 0);
    while(pos >= 0)
    {
        input[pos + 1] = toupper(input[pos + 1]);
        pos = input.find_first_of(" ,-()\"", pos+1);
    }

    return input;
}
