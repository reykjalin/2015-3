import csv

# Read from csv file
csvlist = []
with open('data.csv', newline = '') as csvfile:
    csvr = csv.reader(csvfile, delimiter = ';')
    for row in csvr:
        csvlist.append(row)

# Remove unnecessary lines, store headers and title
headers = csvlist[1]            # Data headers
csvlist.remove(csvlist[0])

# Sort csv list here so icelandic letters won't fuck everything up
csvlist.sort()

# Create lists with school names, subject types and subjects
schlist = []
subjtypelist = []
subjlist = []
for i in range(0, len(csvlist)):
    schlist.append(csvlist[i][0])
    subjtypelist.append(csvlist[i][1])
    subjlist.append(csvlist[i][2])


# School list set up
schlist = set(schlist)
schlist = list(schlist)
schlist.sort()
# for i in schlist:
#     print(i)

# Subject type list set up
subjtypelist = set(subjtypelist)
subjtypelist = list(subjtypelist)
subjtypelist.sort()
# for i in subjtypelist:
#     print(i)

# Subject list setup
subjlist = set(subjlist)
subjlist = list(subjlist)
subjlist.sort()
# for i in subjlist:
#   print(i)

# Set up keys
keylist = []
for i in schlist:
    for j in subjtypelist:
        for k in subjlist:
            tmptuple = (i, j, k)
            keylist.append(tmptuple)
# for i in keylist:
#     print(i)

# Create list of data
datalist = []
for i in csvlist:
    datalist.append(i[3:])
# for i in datalist:
#     print(i)

# Create dictionary with data and keys
csvdict = {}
for i in range(len(keylist)):
    csvdict[keylist[i]] = datalist[i]
# for i in keylist:
#     print(csvdict[i])

# Testing wether the data is handled correctly
# print(' '.join(csvlist[0]))
# print(' '.join(keylist[0]), ' '.join(csvdict[keylist[0]]))
# for i in range(23):
#     print(keylist[i])
# for i in range(len(keylist)):
#     test = ' '.join(keylist[i]) + ' ' + ' '.join(csvdict[keylist[i]])
#     # print('--------')
#     # print(test)
#     # print(' '.join(csvlist[i]))
#     if test != ' '.join(csvlist[i]):
#         print('--------')
#         print("Key nr. {}".format(i))
#         print(test)
#         print(' '.join(csvlist[i]))
#         print("Not the same")
