name = input("Hi, what's your name? ") # Space so there's a space after the question mark
year = int(input("What year is it? ")) # Type cast to int to get a number
pi = float(input("What is pi? ")) # Type cast to float

print("Hello {}!".format(name))
print("The year is {}.".format(year))
print("PI is {}".format(pi))
