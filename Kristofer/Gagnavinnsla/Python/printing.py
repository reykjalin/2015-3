print("Hello World!")
print("Hello " + "World!") # concatenate strings with plus
print("Hello", "World!") # , puts a seperator, defaults to space
print("Hello", "World", end="!\n") # use end to put something at the end, newline has to be added manually
print("Hello", "World!", sep="<--X-->") # sep sets a custom seperator
print()
a = 'A'
b = 42
c = 'Nothing'
d = 53
print("a: {}, b: {}, c: {}, d: {}".format(a,b,c,d)) # use format to insert variables, variables appear where instead of {} in order
print("{3} {1} {0} {2} {3} {2}".format('d', a, 'b', b)) # use format to insert in specific order

print()
print()

# Lists work like pointers using call-by-reference in C++
a = ['a', 'b']
b = a
print(a)
print(b)
b[0] = 'c'
print(b)
print(a)
# Lists work like pointers using call-by-reference in C++

print()
print()

# Change to string
a = 42
print(type(a))
a = '{}'.format(a)
print(a)
print(type(a))
# Change to string
