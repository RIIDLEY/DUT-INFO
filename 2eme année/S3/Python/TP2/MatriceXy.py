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
	if(not(MatIs(M))) : return MatAff(MatZero(1))

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
#Made by me
def MatId(n) :
	res=MatZero(n)
	for i in range(n):
		res[i][i]=1
	return res

#Renvoie la somme de A et B
#Made by me
def MatAdd(A, B) :
	if not(len(A)==len(B)) :
		return "Pas possible car dimension différentes"
	else :
		n=len(A)
		res=MatZero(n)
		for i in range(n):
			for j in range(n):
				res[i][j]=A[i][j]+B[i][j]

		return res

#Renvoie le produit de la matrice A par le nombre réel X
def MatProdX(A, X) :
	n=len(A)
	res=MatZero(n)
	for i in range(n):
		for j in range(n):
			res[i][j]=A[i][j]*X

	return res

#Renvoie l'opposé de la matrice A
def MatOpp(A) :
	n=len(A)
	res=MatZero(n)
	for i in range(n):
		for j in range(n):
			res[i][j]=-res[i][j]
	return res

#Renvoie la différence de A et B
def MatSous(A,B) :
	if not(len(A)==len(B)) :
		return "Pas possible car dimension différentes"
	else :
		n=len(A)
		res=MatZero(n)
		for i in range(n):
			for j in range(n):
				res[i][j]=A[i][j]-B[i][j]
	return res

#Renvoie le produit A*B

def MatProd(A, B) :
	nA=len(A[0]) # nb colones A
	nB=len(B) # nb lignes B

	if nA!=nB:
		return "Impossible"
	else :
		for i in range(nA):
			for j in range(nB):
				temp=0
				for k in range(len(nA)):
					temp+=A[i+k]*B[j+k]
				res[i][j]=temp

	return res

#Renvoie la matrice transposée
def MatTransp(A) :
	res=MatZero(n)
	return res

#Renvoie le mineur
def MatMineur(A,p,q) :
	res=MatZero(n)
	return res

#Calcul le déterminant de A
def MatDet(A) :
	return 0

#Renvoie la matrice des cofacteurs de A
def MatCofact(A) :
	res=MatZero(n)
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




M=MatId(3)
#print(MatAff(M))



#Pour les test
M1=MatZero(3,2)
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
	if(not(MatIs(M))) : return MatAff(MatZero(1))

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
#Made by me
def MatId(n) :
	res=MatZero(n)
	for i in range(n):
		res[i][i]=1
	return res

#Renvoie la somme de A et B
#Made by me
def MatAdd(A, B) :
	if not(len(A)==len(B)) :
		return "Pas possible car dimension différentes"
	else :
		n=len(A)
		res=MatZero(n)
		for i in range(n):
			for j in range(n):
				res[i][j]=A[i][j]+B[i][j]

		return res

#Renvoie le produit de la matrice A par le nombre réel X
def MatProdX(A, X) :
	n=len(A)
	res=MatZero(n)
	for i in range(n):
		for j in range(n):
			res[i][j]=A[i][j]*X

	return res

#Renvoie l'opposé de la matrice A
def MatOpp(A) :
	n=len(A)
	res=MatZero(n)
	for i in range(n):
		for j in range(n):
			res[i][j]=-res[i][j]
	return res

#Renvoie la différence de A et B
def MatSous(A,B) :
	if not(len(A)==len(B)) :
		return "Pas possible car dimension différentes"
	else :
		n=len(A)
		res=MatZero(n)
		for i in range(n):
			for j in range(n):
				res[i][j]=B[i][j]-A[i][j]
	return res

#Renvoie le produit A*B

def MatProd(A, B) :
	nA=len(A[0]) # nb colones A
	nB=len(B) # nb lignes B

	if nA!=nB:
		return "Impossible"
	else :
		res=MatZero(len(A),len(B[0]))
		for i in range(len(A)):
			for j in range(len(B[0])):
				temp=0
				for k in range(len(B)):
					temp+=A[i][k]*B[k][j]
				res[i][j]=temp

	return res

#Renvoie la matrice transposée
def MatTransp(A) :
	n=len(A)
	res=MatZero(n)
	for i in range(n):
		for j in range(len(A[i])):
			res[i][j]=A[j][i]
	return res

#Renvoie le mineur
def MatMineur(A,p,q) :
	res=MatZero(len(A)-1)

	for i in range(len(A)):
		for j in range(len(A[i])):
			if i<p and j<q:
				res[i][j]=A[i][j]
			elif i>p and j<q:
				res[i-1][j]=A[i][j]
			elif i<p and j>q:
				res[i][j-1]=A[i][j]
			elif i>p and j>q:
				res[i-1][j-1]=A[i][j]
	return res

#Calcul le déterminant de A
def MatDet(A) :

	return 0

#Renvoie la matrice des cofacteurs de A
def MatCofact(A) :
	res=MatZero(n)
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

'''
print(MatAff(M))
print("Le mineur M1,2 \n"+MatAff(MatMineur(M,1,1)))
#M=MatId(3)
#print(MatAff(M))



#Pour les test
M1=MatZero(2,3)

M1[0][0]=1
M1[0][1]=2
M1[0][2]=0

M1[1][0]=4
M1[1][1]=3
M1[1][2]=-1


M2=MatZero(3,2)

M2[0][0]=5
M2[0][1]=1

M2[1][0]=2
M2[1][1]=3

M2[2][0]=3
M2[2][1]=4

print(MatAff(MatProd(M1,M2)))
'''

'''
print(MatAff(M),"\n + \n",MatAff(MatId(3)),"\n = \n",MatAff(MatAdd(M,MatId(3))))
print(len(M.keys()))
print(len(M[0].keys()))
print(MatAff(MatProdX(MatId(3),2)))

print("M=\n"+MatAff(M))
print("Id3=\n"+MatAff(MatId(3)))
print("M+Id3=\n"+MatAff(MatAdd(M, MatId(3))))
print("Id3-M=\n"+MatAff(MatSous(MatId(3),M)))
print("La transposée de M est \n"+MatAff(MatTransp(M)))
print("Le mineur M1,2 \n"+MatAff(MatMineur(M,0,1)))
print("Le mineur M2,2 \n"+MatAff(MatMineur(M,1,1)))
print("det(M)="+FracAff(MatDet(M)))
print("L'inverse de M est\n"+MatAff(MatInv(M)))
print("M*M^{-1}=\n"+MatAff(MatProd(M,MatInv(M))))
print("M^{-1}*M=\n"+MatAff(MatProd(MatInv(M),M)))
'''
'''
M[0][0]=2
M[0][1]=0

M[1][0]=1
M[1][1]=1

M[2][0]=2
M[2][1]=0



M2=MatZero(2,3)

M[0][0]=2
M[0][1]=0
M[0][2]=-1

M[1][0]=1
M[1][1]=1
M[1][2]=0
'''

'''
print(MatAff(M),"\n + \n",MatAff(MatId(3)),"\n = \n",MatAff(MatAdd(M,MatId(3))))
print(len(M.keys()))
print(len(M[0].keys()))
print(MatAff(MatProdX(MatId(3),2)))

print("M=\n"+MatAff(M))
print("Id3=\n"+MatAff(MatId(3)))
print("M+Id3=\n"+MatAff(MatAdd(M, MatId(3))))
print("Id3-M=\n"+MatAff(MatSous(MatId(3),M)))
print("La transposée de M est \n"+MatAff(MatTransp(M)))
print("Le mineur M1,2 \n"+MatAff(MatMineur(M,0,1)))
print("Le mineur M2,2 \n"+MatAff(MatMineur(M,1,1)))
print("det(M)="+FracAff(MatDet(M)))
print("L'inverse de M est\n"+MatAff(MatInv(M)))
print("M*M^{-1}=\n"+MatAff(MatProd(M,MatInv(M))))
print("M^{-1}*M=\n"+MatAff(MatProd(MatInv(M),M)))
'''
