list1 = [0,1,2,3,4,5]
list2 = list(range(0,10))
list3 = [i**2 for i in range(0,10)]
list4 = [i**2 for i in range(10) if i % 2 == 0]
print(list1)
print(list2)
print(list3)
print(list4)

m = [[ x for x in range(5)] for y in range(5)]
print(m)

zero = [[0]*5]*5
zero2 = [[0 for x in range(5)] for y in range(5)]
print(zero)
print(zero2)

pairlist = [(x,y) for x in range(8) for y in range(8)]
print(pairlist)
