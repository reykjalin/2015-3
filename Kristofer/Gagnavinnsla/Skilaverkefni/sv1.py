import numpy as np

# Check if all entries from file are numbers
def isAllNum(text):
    for i in text:
        if not i.isnumeric():
            return False
    return True

# Change a list of string to numbers
def strToNum(numlist):
    for i in range(0, len(numlist)):
        numlist[i] = int(numlist[i])
    return numlist

# Calculate standard deviation
def stddev(numbers):
    avg = np.average(numbers)
    std = 0
    for i in numbers:
        std += (i - avg) ** 2
    std /= len(numbers) - 1
    return np.sqrt(std)

# Take list of strings, make everything lowercase
def lowerlist(txtlist):
    text = ' '.join(txtlist)
    text = text.lower()
    return text.split()

# Create a dictionary object with words and how often they occur
def wordCount(txtlist):
    count = {}
    for word in txtlist:
        if word not in count:
            count[word] = 1
        else:
            count[word] += 1
    return count

# Get the 5 most occurred words
def getMostOccurred(txtlist):
    wcount = wordCount(txtlist)

    # Dictionary sort by value from: https://www.python.org/dev/peps/pep-0265/
    items = [(v, k) for k, v in wcount.items()]
    items.sort()
    items.reverse()
    items = [(k, v) for v, k in items]
    
    retlist = items[0:5]
    return retlist

# Get name of file to read from
fname = input("Type filename: ")
f = open(fname, 'r')
text = f.read()
# Split input from file, make a list
inplist = text.split()

if isAllNum(inplist):
    # Change input list to numbers and calculate relevant information
    inplist = strToNum(inplist)
    print("min = {}".format(np.min(inplist)))
    print("max = {}".format(np.max(inplist)))
    print("average = {}".format(np.average(inplist)))
    print("median = {}".format(np.median(inplist)))
    print("stddev = {}".format(stddev(inplist)))
else:
    # Change to lowercase, and use set to find unique words
    txtlist = lowerlist(inplist)
    inpset = set(txtlist)
    print("Number of unique words: {}".format(len(inpset)))
    
    # Get five most occurred words, see relevant functions.
    mostoccurred = getMostOccurred(txtlist)
    print("Five most occurred words, from most occured to least occured:")
    for i in mostoccurred:
        print(i[0])
