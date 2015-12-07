import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# settings = {}
# settings['encoding'] = 'latin1'
# settings['sep'] = ';'
# settings['parse_dates'] = ['Date',]
# settings['dayfirst'] = True
# settings['index_col'] = 'Date'


# bikes = pd.read_csv('bikes.csv', **settings)
# # print(bikes)
# #bikes['Berri 1'].plot()
# #plt.show()

# berri_bikes = bikes[['Berri 1']].copy()
# print(berri_bikes[:10])

# berri_bikes['weekday'] = berri_bikes.index.weekday
# print(berri_bikes[:10])

# weekday_counts = berri_bikes.groupby('weekday').aggregate(sum)
# print(weekday_counts)
# weekday_counts.index = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
# print(weekday_counts)

# weekday_counts.plot(kind='bar')
# plt.show()
''' Demo 2 '''

# complaints = pd.read_csv('311-service-requests.csv')
# #print(complaints)

# print(complaints[['Complaint Type', 'Borough']][:20])
# print()
# #print(complaints['Complaint Type'].value_counts())
# print(complaints['Borough'].value_counts())

# common_complaints = complaints['Complaint Type'].value_counts()
# print()
# print(common_complaints[:10])

# # common_complaints[:10].plot(kind='bar', figsize=(15,5))
# # plt.show()

# ct = 'Noise - Street/Sidewalk'
# noise_complaints = complaints[complaints['Complaint Type'] == ct]
# # print()
# # print(noise_complaints)
# print()

# is_noise = complaints['Complaint Type'] == ct
# in_brooklyn = complaints['Borough'] == 'BROOKLYN'

# print(complaints[is_noise & in_brooklyn][:5][['Complaint Type', 'Borough', 'Descriptor']])
# print()


''' Demo 3 '''
# Look at github
