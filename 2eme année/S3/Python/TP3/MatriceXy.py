#!/usr/bin/python
# -*- coding: utf-8-*-

#####################################################################
#																	#
#				BIBLIOTHEQE DE CALCUL MATRICIELLE					#
#																	#
#####################################################################

#importation de la bibliothèque de calcul matricielle
from FractionXy import *

#Dans cette bibliothèque, une matrice est un tableau (=dictionnaire)
#à deux entrées. Le premier indice est pour la ligne et la seconde pour la colonne.
#Toutes les fonction de cette bibliothèque doivent commencer par Mat

#LES FONCTIONS MARQUEES (faite) SONT FAITES.

#Renvoie True si A est une matrice (faite)
def MatIs(A) :
	try :
		n=len(A)
		m=len(A[0])
		i=0
		while(i<n) :
			j=0
			while(j<m) :
				if(A[i][j]) : x=0	#On essaye d'acceder à la case mais peut importe ce qu'on fait
				j=j+1
			i=i+1
	except :
		return False
	return True

#Matrice nulle à n ligne et m colonne (faite)
def MatZero(n, m=-1) :
	try :
		n=int(n)
		m=int(m)
	except :
		return MatZero(1,1)

	if(n<=0) : return MatZero(1,1)
	if(m<=0) : return MatZero(n,n)

	res=dict()
	i=0
	while(i<n) :
		res[i]=dict()
		j=0
		while(j<m) :
			res[i][j]=0
			j=j+1
		i=i+1
	return res

#Affiche La matrice (faite)
def MatAff(M) :
	if(not(MatIs(M))) :
		return MatAff(MatZero(1))

	n=len(M)
	m=len(M[0])

	res=""
	i=0
	while(i<n) :
		j=0
		while(j<m) :
			res+=FracAff(M[i][j])
			if(j<m-1) : res+='\t'
			j=j+1
		res+='\n'
		i=i+1
	return res


#Matrice identité
def MatId(n) :
	res=MatZero(n)
	i=0
	while(i<n):
		res[i][i]=1
		i+=1
	return res

#Renvoie la somme de A et B
def MatAdd(A, B) :
	if(len(A)!=len(B) or len(A[0])!=len(B[0])):
		return False
	n=len(A)
	m=len(A[0])
	res=MatZero(n,m)
	i=0
	while(i<n):
		j=0
		while(j<m):
			res[i][j]=FracAdd(A[i][j], B[i][j])
			j+=1
		i+=1
	return res

#Renvoie le produit de la matrice A par le nombre réel X
def MatProdX(A, X) :
	n=len(A)
	res=MatZero(n)
	i=0
	while(i<n):
		j=0
		while(j<n):
			res[i][j]=FracProd(A[i][j], X)
			j+=1
		i+=1
	return res

#Renvoie l'opposé de la matrice A
def MatOpp(A) :
	n=len(A)
	res=MatZero(n)
	i=0
	while(i<n):
		j=0
		while(j<n):
			res[i][j]=FracOpp(A[i][j])
			j+=1
		i+=1
	return res

#Renvoie la différence de A et B
def MatSous(A,B) :
	if(len(A)!=len(B) or len(A[0])!=len(B[0])):
		return False
	n=len(A)
	m=len(A[0])
	res=MatZero(n,m)
	i=0
	while(i<n):
		j=0
		while(j<n):
			res[i][j]=FracSous(A[i][j], B[i][j])
			j+=1
		i+=1
	return res

#Renvoie le produit A*B
def MatProd(A, B) :
	if(len(A[0])!=len(B)):
		return False
	n=len(A)
	m=len(B[0])
	o=len(A[0])
	res=MatZero(n,m)
	i=0
	while(i<n):
		j=0
		while(j<m):
			k=0
			add=0
			while(k<o):
				add=FracAdd(FracProd(A[i][k],B[k][j]), add)
				k+=1
			res[i][j]=add
			j+=1
		i+=1
	return res

#Renvoie la matrice transposée
def MatTransp(A) :
	n=len(A)
	m=len(A[0])
	res=MatZero(m,n)
	i=0
	while(i<m):
		j=0
		while(j<n):
			res[i][j]=A[j][i]
			j+=1
		i+=1
	return res

#Renvoie le mineur
def MatMineur(A,p,q) :
	n=len(A)
	m=len(A[0])
	if(p>n or q>m):
		return False
	res=MatZero(n-1, m-1)
	i=0
	iRes=0
	while(i<n):
		if(i!=p):
			j=0
			jRes=0
			while(j<m):
				if(j!=q):
					res[iRes][jRes]=A[i][j]
					jRes+=1
				j+=1
			iRes+=1
		i+=1
	return res

#Calcul le déterminant de A
def MatDet(A) :
	if(len(A)!=len(A[0])):
		return False
	n=len(A)
	if(n==2):
		res = FracSous(FracProd(A[0][0], A[1][1]), FracProd(A[0][1],A[1][0]))
	else:
		res=0
		i=0
		while(i<n):
			mul=A[i][0]
			if(i%2==1):
				mul=FracOpp(mul)
			mat=MatMineur(A,i,0)
			if(len(mat)==2):
				res=FracAdd(FracProd(mul, FracSous(FracProd(mat[0][0],mat[1][1]), FracProd(mat[0][1], mat[1][0]))), res)
			else:
				res=FracAdd(FracProd(mul, MatDet(mat)), res)
			i+=1
	return res


#Renvoie la matrice des cofacteurs de A
def MatCofact(A) :
	if(len(A) != len(A[0])):
		return False
	else:
		n=len(A)
		res=MatZero(n)
		i=0
		while(i < n):
			j = 0
			while(j < n):
				res[i][j]=FracProd(MatDet(MatMineur(A,i,j)), (-1)**(i+j))
				j += 1
			i += 1
		return res

#Renvoie la matrice inverse (faite)
def MatInv(A) :
	if(not(MatIs(A))) : return "NaN"
	n=len(A)
	m=len(A[0])
	if(m!=n) : return "NaN"

	d=MatDet(A)
	if(d==0) : return "NaN"

	return MatProdX(MatTransp(MatCofact(A)), FracInv(d))

#Renvoie le résultat de A^p | p pouvant être négatif
def MatPuiss(A,p) :
	return A


#Pour les test
"""
M=MatZero(3)
M[0][0]=2
M[0][1]=0
M[0][2]=-1

M[1][0]=1
M[1][1]=1
M[1][2]=0

M[2][0]=2
M[2][1]=0
M[2][2]=1

print("M=\n"+MatAff(M))
print("Id3=\n"+MatAff(MatId(3)))
print("M+Id3=\n"+MatAff(MatAdd(M, MatId(3))))
print("M²=\n"+MatAff(MatProd(M,M)))
print("Id3-M=\n"+MatAff(MatSous(MatId(3),M)))
print("La transposée de M est \n"+MatAff(MatTransp(M)))
print("Le mineur M1,2 \n"+MatAff(MatMineur(M,0,1)))
print("Le mineur M2,2 \n"+MatAff(MatMineur(M,1,1)))
print("det(M)="+FracAff(MatDet(M)))

M2=MatZero(3)
M2[0][0] = 3
M2[0][1] = 4
M2[0][2] = 5

M2[1][0] = -1
M2[1][1] = 3
M2[1][2] = 6

M2[2][0] = 3
M2[2][1] = 4
M2[2][2] = -5

print("M2=\n"+MatAff(M2))
print("det(M2)="+FracAff(MatDet(M2)))
print("comatrice M2="+MatAff(MatCofact(M2)))
print("L'inverse de M est\n"+MatAff(MatInv(M)))
print("M*M^{-1}=\n"+MatAff(MatProd(M,MatInv(M))))
print("M^{-1}*M=\n"+MatAff(MatProd(MatInv(M),M)))
#"""
"""
M3 = MatZero(5)
M3[0][0] = 3
M3[0][1] = 4
M3[0][2] = 5
M3[0][3] = 2
M3[0][4] = 5

M3[1][0] = -1
M3[1][1] = 3
M3[1][2] = 6
M3[1][3] = 5
M3[1][4] = 3

M3[2][0] = 3
M3[2][1] = 4
M3[2][2] = -5
M3[2][3] = 4
M3[2][4] = 2

M3[3][0] = 3
M3[3][1] = 7
M3[3][2] = -5
M3[3][3] = 2
M3[3][4] = 5

M3[4][0] = 2
M3[4][1] = 7
M3[4][2] = -5
M3[4][3] = 5
M3[4][4] = 5

print("M3=\n"+MatAff(M3))
print("det(M3)="+FracAff(MatDet(M3)))



A = MatZero(7)
A[0][0] = 1
A[0][1] = 1
A[0][2] = 1


A[1][0] = 1
A[1][1] = 1
A[1][2] = 1
A[1][3] = 1
A[1][4] = 1
A[1][5] = 1
A[1][6] = 1

A[2][0] = -1
A[2][1] = 2
A[2][3] = 1
A[2][4] = 1
A[2][5] = 1
A[2][6] = 1

A[3][1] = 1
A[3][2] = 1
A[3][3] = 2
A[3][4] = -1
A[3][5] = 2
A[3][6] = -1

A[4][0] = 1
A[4][1] = 2
A[4][2] = 2
A[4][3] = 2
A[4][5] = 2

A[5][1] = 1
A[5][2] = 1
A[5][3] = 1
A[5][5] = -1


A[6][1] = 1
A[6][2] = 1
A[6][3] = 2
A[6][5] = 2
A[6][6] = 1

print("A=\n"+MatAff(A))
print("Det(A)="+str(FracAff(MatDet(A)))+". Le determinent de A est different de 0, A est donc inversible.")
print("\nA^(-1)=\n"+str(MatAff(MatInv(A))))

B = MatZero(7,1)
B[0][0]=-1
B[1][0]=2
B[2][0]=-4
B[3][0]=8
B[4][0]=-16
B[5][0]=32
B[6][0]=-64

print("\nX=A^(-1)*B\nX=\n"+str(MatAff(MatProd(MatInv(A), B))))
"""
