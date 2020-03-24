from math import *
def PersMult(N):
    p = 0
    while len(N)>1:
        nb = 1
        for i in range(len(N)):
            nb *=N[i]
        N = Base(10,nb)
        p +=1
    return p

def Base(b,n):
    tab = []
    while n != 0 :
        tab.append(n%b)
        n = n//b
    return tab

def PersMult1(N,k):
    p = 0
    while len(N)>1:
        nb = 1
        for i in range(len(N)):
            nb =int(nb) * N[i]
            nb = Base(k,nb)
        N = Base(k,nb)
        p +=1
    return p

def cherche(b,p):
    pers = 0
    i=0
    while pers < p:
        pers = PersMult1(Base(10,i),b)

        i+=1
    return i



tab1 = [1,0]
print(cherche(6,4))
