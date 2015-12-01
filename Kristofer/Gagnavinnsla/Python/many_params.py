def fun(*args):
    s = 0
    for i in args:
        s += i
    return s

print(fun(1,3,2))
print(fun(1,2))
