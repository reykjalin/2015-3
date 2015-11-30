f = open('randomtext', 'r')

''' Read and print multiple lines formatted correctly
for line in f:
    text += line
    print(line, end="")
print()
'''

''' Read and print multiple lines formatted correctly
text = f.read()
print(text)
print("------------")
print(type(text))
print(len(text))
'''

''' Read lines to list, print list
text = f.readlines()
print(text)
print("------------")
print(type(text))
print(len(text))
'''

# Strip whitespace from text
text = f.readlines()
for i in range(len(text)):
    text[i] = text[i].strip()
print(text)

# Join list of strings in to one string
print('------- Join --------')
nline = '\n'.join(text)
wspace = ' '.join(text)
print(nline)
print()
print(wspace)

# Split strings to list
nlist = nline.split()
wlist = wspace.split()
print('------ Śplit -------')
print(nlist)
print()
print(wlist)

f.close()
