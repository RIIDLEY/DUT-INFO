#!/usr/bin/python
# -*- coding: utf-8-*-

#####################################################
#													#
#		Bibliothèque de travail sur les graphes		#
#													#
#####################################################
from random import uniform, randint
from MatriceXy import *

#Ne pas oublier que dans tout le programme, les valeurs utilisées sont des fractions 
#Ainsi on n'écrira pas if(G[i][j]!=0) mais plutôt if(FracComp(G[i][j], 0)!=0)...

#Affiche un grpahe (FAIT)
def GrapheAff(G) :
	try : n=len(G)
	except : n=0
	
	if(n==0) :
		 return "Le graphe est vide"
		
		
	res=""
	res+='    |\t'
	j=0
	while(j<n) :
		res+='x'+str(j+1)+'\t'
		j+=1
	res+='\n'
	j=0
	while(j<n) :
		res+='---------'
		j+=1
	res+='\n'
	i=0
	while(i<n) :
		j=0
		res+='x'+str(i+1)+'  |\t'
		while(j<n) :
			try : res+=FracAff(G[i][j])
			except : res=res+"?"
			res=res+'\t'
			j=j+1
		if(i<n-1) : res=res+'\n'
		i=i+1
	return res

#Retourne le stable sandard à n sommets (FAIT)
def GrapheZero(n) :
	return MatZero(n)
	
#Renvoie un graphe de taille n généré au hasard avec une densié d de 1 - cas orienté (FAIT)
def GrapheAlea_or(n, d=0.5) :
	try : 
		n=int(n)
		d=float(d)
	except : 
		n=0
		d=0.5
	
	res=dict()
	i=0
	while(i<n) :
		res[i]=dict()
		j=0
		while(j<n) :
			res[i][j]=0
			if(uniform(0,1)<d) : res[i][j]=FracUn()
			j+=1
		i+=1
	return res

#Renvoie un graphe de taille n généré au hasard avec une densié d de 1 - cas non orienté (FAIT)
def GrapheAlea_non_or(n, d=0.5) :
	try : 
		n=int(n)
		d=float(d)
	except : 
		n=0
		d=0.5
	
	res=GrapheAlea_or(n, 0)
	i=0
	while(i<n) :
		j=i+1
		while(j<n) :
			if(uniform(0,1)<d) : 
				res[i][j]=FracUn()
				res[j][i]=res[i][j]
			j+=1
		i+=1
	return res
	
#Renvoie un graphe valué de taille n généré au hasard avec une densié d de 1 
#Les variables a, b et den permettent de spécifier que la valuation est entre a/den et b/den - cas orienté (FAIT)
def GrapheAleaVal_or(n, d=0.5, a=1, b=9, den=1) :
	try : 
		n=int(n)
		d=float(d)
		a=int(a)
		b=int(b)
		den=int(den)
	except : 
		n=0
		d=0.5
		a=1
		b=9
		den=1
	if(b<a) : return GrapheAleaVal_or(n, d, b, a, den)
	if(den<1) : return GrapheAleaVal_or(n, d, a, b, 1)
	res=GrapheZero(n)
	i=0
	while(i<n) :
		j=0
		while(j<n) :
			if(uniform(0,1)<d) : 
				x=dict()
				x[0]=randint(a, b)#Numérateur
				x[1]=randint(1, den)#Dénominateur
				x=FracSimplif(x)
				res[i][j]=x
			j+=1
		i+=1
	return res

#Renvoie un graphe valué de taille n généré au hasard avec une densié d de 1
#Les variables a, b et den permettent de spécifier que la valuation est entre a/den et b/den - cas orienté (FAIT)
def GrapheAleaVal_non_or(n, d=0.5, a=1, b=9, den=1) :
	try : 
		n=int(n)
		d=float(d)
		a=int(a)
		b=int(b)
		den=int(den)
	except : 
		n=0
		d=0.5
		a=1
		b=9
		den=1
	if(b<a) : return GrapheAleaVal_non_or(n, d, b, a, den)
	if(den<1) : return GrapheAleaVal_non_or(n, d, a, b, 1)
	res=GrapheZero(n)
	i=0
	while(i<n) :
		j=i+1
		while(j<n) :
			if(uniform(0,1)<d) : 
				x=dict()
				x[0]=randint(a, b)#Numérateur
				x[1]=randint(1, den)#Dénominateur
				x=FracSimplif(x)
				res[i][j]=x
				res[j][i]=x
			j+=1
		i+=1
	return res

#Désorientation de graphe 
#En cas d'un arc entre x et y avec une valuation et un arc entre y et x avec une autre valuation
#Alors on devra créer une arête entre x et y avec comme valuation le max entre les deux premières
def Graphe_Des_or(G):
	try : n=len(G)
	except : n=0
	A=GrapheZero(n)
	return A
	
#Retourne la clique orienté à n sommet
def K_or(n) :
	G=GrapheZero(n)
	return G

#Retourne la clique non orienté à n sommets (FAIT)
def K_non_or(n) :
	return Graphe_Des_or(K_or(n))
	
#Retourne la chaine orienté à n sommets
def C_or(n) :
	G=GrapheZero(n)
	return G

#Retourne la clique non orienté à n sommets (FAIT)
def C_non_or(n) :
	return Graphe_Des_or(C_or(n))
		
#Retourne le cycle orienté à n sommets
def Z_or(n) :
	G=GrapheZero(n)
	return G

#Retourne la clique non orienté à n sommets (FAIT)
def Z_non_or(n) :
	return Graphe_Des_or(Z_or(n))
	
#Renvoie True s'il existe un chemin de longueur l entre les sommets a et b
def existeChemin(G, l, a, b) :
	return False

#Renvoie le demi-degré exérieur
def demi_deg_ext(x, G) :
	return -1

#Renvoie le demi-degré intérieur (FAIT)
def demi_deg_int(x,G):
	return demi_deg_ext(x, MatTransp(G))

#Renoie true s'il existe un circuit eulérienne cas orienté
def existeCircuitEulerien_or(G) :
	return True

#Renoie true s'il existe un circuit eulérienne cas non orienté
def existeCircuitEulerien_non_or(G) :
	return True

#Renoie true s'il existe une chaine eulérienne cas orienté
def existeChaineEulerien_or(G) :
	return False

#Renoie true s'il existe une chaine eulérienne cas non orienté
def existeChaineEulerien_non_or(G) :
	return False

#Renvoie un tableau avec les sommet classé dans l'ordre décroissant des degrés (FAIT)
def classementSommet(G):
	try : n=len(G)
	except : return dict()
	
	D=Graphe_Des_or(G)
	
	#Initialisation
	res=dict()
	i=0
	while(i<n) :
		res[i]=i
		i+=1
	
	#Algo de tri (tri par bulle)
	i=0
	while(i<n) :
		j=i+1
		while(j<n):
			if(demi_deg_int(res[i], D)<demi_deg_int(res[j], D)) :
				tmp=res[i]
				res[i]=res[j]
				res[j]=tmp
			j+=1
		i+=1
	return res
	
#Renvoie un tableau des couleurs des sommets
def Graphe_Brelaz(G) :
	try : n=len(G)
	except : return dict()
	
	D=Graphe_Des_or(G)
	
	#On met 0 pour dire que c'est pas colorer
	i=0
	couleur=dict()
	while(i<n) :
		couleur[i]=0
		i+=1
	
	return couleur

#Renvoie un tableau de Dijkstra :
#	- la case "DMIN" est distance la plus courte partant de a pour atteindre le sommet a - '-1' pour un sommet intouchable
#	- la case "SPRO" est le numéro du sommet le plus proche - '-1' pour un sommet intouchable
def Graphe_Dijkstra(G, a) :
	res=dict()
	res["DMIN"]=dict()
	res["SPRO"]=dict()
	try : n=len(G)
	except : return res
	
	#Initialisation
	i=0
	while(i<n) :
		res["DMIN"][i]=-1
		res["SPRO"][i]=-1
		i+=1
	if(a>n) : return res
	
	return res

#TESTS	
n=5
G1=GrapheAlea_or(n)
G2=GrapheAleaVal_or(n, 0.75, 2, 3, 9)
print("G1 = ")
print(GrapheAff(G1))
print("G2 = ")
print(GrapheAff(G2))
print("|G2| = ")
print(GrapheAff(Graphe_Des_or(G2)))
print(existeCircuitEulerien_or(G1))
print(existeChemin(G1, 2, 0, n-1))
print(existeChaineEulerien_non_or(Graphe_Des_or(G1)))
print(Graphe_Brelaz(G2))
print(Graphe_Dijkstra(Graphe_Des_or(G2), 0))