# Filter out numbers that are odd, only display even numbers from fib
fib = [0,1,1,2,3,5,8,13,21,34,55]
result = filter(lambda x: x % 2 == 0, fib)
print(list(result))

# Filter out all numbers where 3 isn't the last digit, only display numbers where 3 IS the last digit
print(list(filter(lambda x: str(x)[-1] == '3', range(0,100))))

# Use lambda function and map to store resaults
F = map(lambda t: (9/5)*t+32, [0,37,100,200])
print(list(F))

# Alternative map method
g = lambda t: (9/5) * t + 32
p = [0,37,100,200]
F = map(g, p)
print(list(F))
