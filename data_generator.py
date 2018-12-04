import csv

import random


song_arr = ['Blues', 'Country Music', 'Hip Hop', 'Jazz', 'R&B', 'Pop', 'Rock', 'Folk',
            'Dance Music', 'Electronic Music', 'Opera', 'World Music']


def x(a,b):
    return list(range(a,b))


l = [x(50,60),x(60,80),x(90,100),x(90,100),x(90,100),x(90,100),x(90,100),x(90,100),x(90,100),x(90,100),x(90,100),x(90,100)]


y = 0
for j in song_arr:
    for i in range(10000):
        print(j+","+ str(random.choice(l[y])))
    y+=1