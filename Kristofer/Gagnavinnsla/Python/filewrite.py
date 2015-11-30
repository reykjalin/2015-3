import random # For random numbers

f = open('randomnumbers.txt', 'w')

for i in range(100):
    f.write('{}\n'.format(random.randint(1,6)))

f.close()
