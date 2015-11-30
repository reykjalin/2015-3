import random
f = open('num', 'w')
for i in range(0, 100):
    for i in range(0, 10):
        #f.write('{}'.format(random.randint(0,1000000000)))
        f.write('{}'.format(random.randint(0,15)))
        f.write(' ')
    f.write('\n')
print("Done.")
