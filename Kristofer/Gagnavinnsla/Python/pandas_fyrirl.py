import numpy as np
import pandas as pd


d = {'Austin':800, 'Boston': None, 'Chicago': 800, 'New York':1300, 'Portland':800, 'San Fransisco':1100}
print(d)
cities = pd.Series(d)
print(cities)

data = {}
data['Movie'] = ['Alien', 'Se7en', 'Taxi', 'Ran']
data['Year'] = [1979, 1995, 1998, 1985]
data['Dir'] = ['Scott', 'Fincher', 'Besson', 'Kurosawa']
data['Rating'] = [8.5, 8.7, 6.9, 8.3]
print(data)
m = pd.DataFrame(data, columns = ['Year', 'Movie', 'Dir', 'Rating'])
print(m)

m.to_csv('csv_pd_test.csv')

print(m[ m.Year == 1985 ])

d = pd.read_csv('csv_pd_test.csv')
print(d)
d.drop('Unnamed: 0')
print(d)
