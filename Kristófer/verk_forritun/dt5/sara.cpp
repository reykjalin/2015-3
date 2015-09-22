//
//  main.cpp
//  DT_05
//
//  Created by Sara Kristjansdottir on 21.9.2015.
//  Copyright (c) 2015 Sara Kristjansdottir. All rights reserved.
//


#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void openInFile(ifstream &fin, string filename);
void openOutFile(ofstream &fout, string filename);
void fillArray(string array[], int size, istream& in);
void printArray(string array[], int size, ostream & out);
void fixNumber(string &input);
void dotToDash( string &input);
void downBarToSpace( string &input);
void bigFirstLetter( string &input);
void smallMP3( string &input);
bool fixString( string &input);

const int SIZE = 10;

int main()
{
    ifstream fin;
    string filename = "/Users/sarakristjansdottir/Downloads/songlist.txt";
    openInFile(fin, filename);
    
    string fylki[SIZE];
    fillArray(fylki, SIZE, fin);
    
    for( int i = 0 ; i < SIZE ; i++)
    {
        
        if( fixString(fylki[i]) )
        {
            fixNumber(fylki[i]);
            dotToDash(fylki[i]);
            downBarToSpace(fylki[i]);
            bigFirstLetter(fylki[i]);
            smallMP3(fylki[i]);
            
        }
    }
    fin.close();
    
    ofstream fout;
    openOutFile(fout, "/Users/sarakristjansdottir/Downloads/output.txt");
    
    
    printArray(fylki, SIZE, fout);
    fout.close();
    return 0;
}

void openInFile(ifstream &fin, string filename)
{
    fin.open(filename.c_str());
    
    if(fin.fail())
    {
        cout << " tókst ekki að opna skrá "<< endl;
        exit(1);
    }
}

void openOutFile(ofstream &fout, string filename)
{
    fout.open(filename.c_str());
    
    if(fout.fail())
    {
        cout << " tókst ekki að opna skrá "<< endl;
        exit(1);
    }
}

void fillArray(string array[], int size, istream& in)
{
    string data;
    for( int i = 0; i < size; i++)
    {
        getline(in, data);
        array[i] = data;
    }
}

void printArray(string array[], int size, ostream & out)
{
    for( int i = 0; i < size; i++)
    {
        out << array[i] << endl;
    }
}

void fixNumber(string &input)
{
    unsigned long pos = 0;
    pos = input.find_first_not_of("0123456789");
    
    if( pos == 1)
    {
        input.insert(0,"0");
    }
    
}

void dotToDash( string &input)
{
    unsigned long pos = 0;
    pos = input.find_first_of(".");
    
    if( pos < input.length())
    {
        input.erase(pos, 1);
        input.insert(pos," - ");
    }
}

void downBarToSpace( string &input)
{
    unsigned long pos = 0;
    pos = input.find_first_of("_");
    
    while ( pos < input.length())
    {
        input.erase(pos, 1);
        input.insert(pos," ");
        pos = input.find_first_of("_");
    }
}

void bigFirstLetter( string &input)
{
    unsigned long pos = 0;
    pos = input.find_first_of(" ");
    
    while ( pos < input.length())
    {
        if( isalpha(input[pos +1]))
        {
            input[pos +1] = toupper(input[pos+1]);
        }
        pos = input.find_first_of(" ", pos + 1);
    }
}

void smallMP3( string &input)
{
    unsigned long pos = 0;
    
    pos = input.find("MP3");
    
    if( pos < input.length())
    {
        input.erase(pos,3);
        input.insert(pos, "mp3");
    }
}

bool fixString( string &input)
{
    if(input.length() > 1 && input[0] == '/' && input[1] == '/')
    {
        return false;
    }
    return true;
}
