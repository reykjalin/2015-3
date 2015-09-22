/* songlist.txt
//Liars - They Threw Us All in a Trench and Stuck a Monument on Top
1.grown_men_don't_fall_in_the_river,_just_like_that.MP3
2.mr_your_on_fire_mr.MP3
3.loose_nuts_on_the_veladrome.MP3
4.the_garden_was_crowded_and_outside.MP3
5.tumbling_walls_buried_me_in_the_debris.MP3
6.nothing_is_ever_lost_or_can_be_lost_my_science_friend.MP3
7.we_live_ne_of_compton.MP3
8.why_midnight_walked_but_didn't_ring_her_bell.MP3
9.this_dust_makes_that_mud.MP3
*/

/* prettysonglist.txt
//Liars - They Threw Us All in a Trench and Stuck a Monument on Top
01 - Grown Men Don't Fall In The River, Just Like That.mp3
02 - Mr Your On Fire Mr.mp3
03 - Loose Nuts On The Veladrome.mp3
04 - The Garden Was Crowded And Outside.mp3
05 - Tumbling Walls Buried Me In The Debris.mp3
06 - Nothing Is Ever Lost Or Can Be Lost My Science Friend.mp3
07 - We Live Ne Of Compton.mp3
08 - Why Midnight Walked But Didn't Ring Her Bell.mp3
09 - This Dust Makes That Mud.mp3
*/
#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include <cstdlib>
using namespace std;

int main() {
  ifstream inputfile;
  ofstream outputfile;
  
  string songtitle, tmpstr;
  int tracknr;
  long pos;
  
  inputfile.open("/Users/eyjo/Desktop/songlist.txt");
  if (inputfile.fail()) {
    cout << "can't open file\n";
    exit(1);
  }
  outputfile.open("/Users/eyjo/Desktop/prettysonglist.txt");
  if (inputfile.fail()) {
    cout << "can't open file\n";
    exit(2);
  }
  
  while (!inputfile.eof()) {
    getline(inputfile, songtitle);
    while (songtitle[0] == '/' && songtitle[1] == '/'
           && !inputfile.eof()) {
      outputfile << songtitle << endl;
      getline(inputfile, songtitle);
    }

    int i = 0;
    while (isdigit(songtitle[i]))
      i++;
    
    tracknr = atoi(songtitle.substr(0,i).c_str());
    
    pos = songtitle.find_first_not_of("_-., ", i);
    songtitle = songtitle.substr(pos,songtitle.length());
    
    pos = songtitle.find('_');
    while (pos >= 0) {
      songtitle[pos] = ' ';
      pos = songtitle.find('_');
    }
    
    songtitle[0] = toupper(songtitle[0]);
    
    pos = songtitle.find_first_of(" ,-()\"", 0);
    while (pos >= 0) {
      songtitle[pos+1] = toupper(songtitle[pos+1]);
      pos = songtitle.find_first_of(" ,-()\"", pos+1);
    }
    
    songtitle = songtitle.substr(0, songtitle.length()-3) + "mp3";
    
    if (tracknr < 10)
      outputfile << "0";
    outputfile << tracknr << " - " << songtitle << endl;
  }
  
  inputfile.close();
  outputfile.close();
  
  return 0;
}