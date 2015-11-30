
f = open('randomnumbers.txt', 'r') # r = read, w = write, a = append

t = [0] * 6

'''
# Read every line from file and show type
for line in f:
    print("----------")
    print(type(line))
    print('"{}"'.format(line))
'''

# Count occurances of numbers
for line in f:
    val = int(line)
    t[val - 1] += 1
print(t)


for i in range(6):
    print("The value {} appears {} times".format(i+1, t[i]))

f.close()
