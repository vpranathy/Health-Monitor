#Titanic: Machine Learning from Disaster
import pandas as pd
from pandas import Series, DataFrame

titanic_df = pd.read_csv('train.csv')

#see a preview of the data
titanic_df.head()

# here Survived:
#0 = false: that passenger did not survive
#1 = true: that passenger did survive

#Sib = Sibling
#0 = false: that passenger did not have siblings on board
#1 = true: that passenger did have siblings on board

#Parch = parents and children
#0 = false: that passenger did not have parents or children on board
#1 = true: that passenger did have parents or children on board

# another way of quickly grabbing the information of this set of data
titanic_df.info()

# Basic Questions list:
# 1) Who were the passengers on the Titanic? (Ages, Gender, Class, ..etc)
# 2) What deck were the passengers on and how does that relate to their class乘客们坐在什么甲板上?这和他们的班级有什么关系
# 3) Where did the passengers come from?
# 4) Who was alone and who was with family?
# Deeper question:
# What factors helped someone survive the sinking?

import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
'exec(%matplotlib inline)'

# You need to provide variable you are assigning to. If you are plotting with one variable,
# then you should mention "kind" of plot you want.
sns.catplot(x='Sex', data=titanic_df, strip='count')
# Details on sns.factorplot: https://seaborn.pydata.org/generated/seaborn.factorplot.html

# Separate the genders by classes
sns.catplot(x='Sex', data=titanic_df, strip='count', hue='Pclass')

# Separate the classes by genders
sns.catplot(x='Pclass', data=titanic_df, strip='count', hue='Sex')


# I will say a person's age that less than 16 will be a child
def male_female_child(passenger):
    age, sex = passenger

    if age < 16:
        return 'child'
    else:
        return sex


titanic_df['person'] = titanic_df[['Age', 'Sex']].apply(male_female_child, axis=1)

# Create a new column called 'person'
# Here, ['Age','Sex'] is for passing these two columns from the original data set, [[xxx]] is passing the xxx list.
# And then, apply the function male_female_child

# Take a quick view of 20 rows of my data frame
titanic_df[0:20]

# Separate all the classes by male_female_child
sns.catplot(x='Pclass', data=titanic_df, strip='count', hue='person')

titanic_df['Age'].hist(bins=70)

titanic_df['Age'].mean()

# Get a quick overall comparison of male, female and child
titanic_df['person'].value_counts()

# I wanna analyze the relationship between sex and age
# Seaborn.FacetGrid: Subplot grid for plotting conditional relationships.
# Seaborn.FacetGrid: Allow you to do multiple plots on one figure
# Seaborn.kdeplot: Fit and plot a univariate or bivariate kernel density estimate.

fig = sns.FacetGrid(titanic_df, hue='Sex', aspect=4)
fig.map(sns.kdeplot, 'Age', shade=True)

oldest = titanic_df['Age'].max()
# Since no one can be nagative years old, so I will set the limit, the x limit from 0 to oldest
fig.set(xlim=(0, oldest))

fig.add_legend()
# And then we can get a KDE(Kernel density estimation) plot on the ages on male versus female

