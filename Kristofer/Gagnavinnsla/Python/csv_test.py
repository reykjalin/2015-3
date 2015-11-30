# Reading CSV files test
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

data = pd.read_csv('data.csv', sep=';', encoding='iso8859_10') # iso8859_10
#print(data.loc['Háskólinn í Reykjavík'])

# data.index to get indexes for data frame
#print(data.index)
print(data.index.values)
