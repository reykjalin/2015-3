# If statement
name = "Kristofer"
year = 2000

if(year < 2000):
    print("{} is less than 2000".format(year))
elif year > 2000 or year == 2000:                 # Note: logical operators use words
    print("{} is greater than 2000".format(year))
else:
    print("I have no idea what happened...")
# If statement

print()

# While loops
i = 0
while i < 10:
    print(i)
    i += 1


while True:
    text = input("Magic word? ")
    if text.lower() == 'please':
        print("YOU DID IT!")
        break;
    else:
        print('nope, try again...')
# While loops

print()

# For loops
for i in [1, 2, 3, 4, 5]:
    print(i)

for i in range(10):
    print(i, end = ' ')
print()

for i in range(4,10):
    print(i, end = ' ')
print()

a = 23
for i in range(10, a):
    print(i, end = ' ')
print()

for i in "testing":
    print(i)

for i in ['hello', 24, '?', 'y u do dis?', 423]:
    print(i)
# For loops
