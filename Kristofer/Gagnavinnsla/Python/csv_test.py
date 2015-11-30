import csv

csvlist = []
with open('data.csv', newline = '') as csvfile:
    csvr = csv.reader(csvfile, delimiter = ';')
    for row in csvr:
#        print(' '.join(row))
        csvlist.append(row)
csvlist.remove(csvlist[1]) # Removed empty line

# Remove unnecessary lines
title = csvlist[0]
headers = csvlist[1]
csvlist.remove(csvlist[0])
csvlist.remove(csvlist[0])

schlist = []
subjlist = []
for i in range(0, len(csvlist)): # Range from line 2 because first 2 lines are headers
    schlist.append(csvlist[i][1])
    subjlist.append(csvlist[i][2])

# School list set up
schlist = set(schlist)
schlist = list(schlist)
schlist.sort()
# for i in schlist:
#     print(i)

# Subject list setup
subjlist = set(subjlist)
subjlist = list(subjlist)
subjlist.sort()
# for i in subjlist:
#    print(i)

print(csvlist)
