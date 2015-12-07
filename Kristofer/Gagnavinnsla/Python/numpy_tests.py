import numpy as np

a = np.arange(15).reshape(3,5)
print(a)

print(a.shape)
print(a.ndim)
print(a.size)
print(a.dtype)
print(type(a))


a = np.array([[2,3,4],[1,2,1]])
print(a)

a = np.zeros((4,6), dtype = int)
print(a)
print(a.dtype)
a.dtype = 'int32'
print(a.dtype)

a = np.ones([3,3,3])
print(a)
print(a.size)
print(a.dtype)
print(a.shape)

# Start at 10, go to 30, use every fifth number
a = np.arange(10,30,5)
print(a)

# Safer to use linspace when you want a specific number of elements
a = np.arange(0.,1.,0.01)
print(a)
print(a.size)
a = np.linspace(0,1,100)
print(a)
print(a.size)

print(np.sin(a))

a = np.zeros((3,4,5))
print(a)

# np.set_printoptions(threshold = 'nan') # Allow printing of huge matrices

b = np.arange(4)
print(b)
#c = a - b
#print(c)
b = b ** 2
print(b)

print(10*np.sin(a))
print(a < 35)

a = np.linspace(1,10,5)
b = np.linspace(10,100,5)
c = a * b                       # Elementwise
print(c)
c = np.dot(a,b)
print(c)                        # Dot product

a = np.linspace(1,10,3)
b = np.linspace(1,100,3)
c = np.cross(a,b)
print(c)


a = np.array(((2,3),(3,5)))
b = np.array(((1,2),(5,-1)))
print(a*b)                      # Elementwise multiplication

a = np.matrix(((2,3),(3,5)))
b = np.matrix(((1,2),(5,-1)))
print(a*b)                      # Dot product

a = np.ones((3,2), dtype = int)
print(a)
a += 1
print(a)
a *= 2
print(a)

a = np.ones([1,1,3])
print(a)
b = np.linspace(0, np.pi, 3)
print(b)
c = a + b
print(c)
print(c.dtype)
d = np.exp(c*1j)
print(d)
print(d.dtype)


a = np.random.random((2,3))
print(a.sum())
print(a.min())
print(a.max())
print(a.std())

a = np.arange(12).reshape(3,4)
print(a)
print(a.sum())
print(a.sum(axis=0))
print(a.std(axis=0))
print(a.sum(axis=1))
print(a.std(axis=1))

b = np.arange(3)
print(b)
print(np.exp(b))
print(np.sin(b))

a = np.arange(10)**3
print(a)
print(a[2])
print(a[2:5])
print(a[2:9:3])
print(a[::-1])
print(a[-3])

def f(x,y):
    return 10*x + y

b = np.fromfunction(f, (6,4), dtype=int)
print(b)

print(b[0:3,:])
print(b[0:3,-2:])
print(b[:,2])
print(b[-1])
print(b[-1,:])

for i in b:
    print(i)
for i in b.flat:
    print(i, end='-')

print()
a = np.floor(10*np.random.random((3,4)))
print(a)

a.resize(6,2)
print(a)
a.transpose
print(a)

a = np.floor(10*np.random.random((2,12)))
print(a)
a = np.hsplit(a,3)
print(a)

a = np.arange(12)
print(a)
b = a
print(b)
print(b is a)
b.shape = 3,4
print(b)
print(a)
c = a.view()
print(c is a)
print(c.base is a)
print(c.flags.owndata)

print(c)
print(a)
c.shape = 2,6
print(c)
print(a)
c[0,4] = 1234
print(c)
print(a)
