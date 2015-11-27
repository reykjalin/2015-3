def message():
    print("This is a message")
    print("in a simple function")
def sum(a,b):
    result = a + b
    return result
def get_two_numbers():
    num1 = int(input("First number: "))
    num2 = int(input("Second number: "))
    return num1, num2


print("jeij")
message()
print(sum(3, 4))

print()

x, y = get_two_numbers()
x, y = y, x # Swap x and y
print(sum(x, y))

print()

x = input("First text: ")
y = input("Second text: ")
print(sum(x, y))



