#!/usr/bin/python
# -*- coding: utf-8-*-

#####################################################
#													#
#		Programmation de l'algorithme Hongrois		#
#													#
#####################################################
from GrapheXy import *

#Ne pas oublier que dans tout le programme, les valeurs utilisées sont des fractions

#SELECTION est une matrice avec des true et des false indiquant si les 0 sont séléctionnés ou non
#MARQUAGE est une matrice avec des true et des false indiquant les zéros marqués ou non
#COUVERTURE est un tableau asociation avecu dexu case :
#	* une case 'LIG' qui est un tableau de true ou false indiquant si la ligne en question est couverte ou non
#	* une case 'COL' qui est un tableau de true ou false indiquant si la colonne en question est couverte ou non


#Les coordonnée d'un nombre (eg 0) dans une matrice est un tableau ou le premier indice est la ligne et le second la colonne

#Fait apparaitre un zéro par ligne
def Apparition0Ligne(G) :
	n = len(G)
	res = MatZero(n)
	i=0
	while (i < n):
		m = G[i][0]
		j=0
		while (j < n):
			if (G[i][j] < m):
				m = G[i][j]
			j += 1
		j=0
		while (j < n):
			res[i][j] = G[i][j] - m
			j += 1
		i+=1
	return res

#Fait apparaitre un zéro par colonne
def Apparition0Colonne(G) :
	G = MatTransp(Apparition0Ligne(G))
	G = Apparition0Ligne(G)
	return MatTransp(G)

#Renvoie True si l'algorithme Hongrois est fini
def FinAlgoHongrois(SELECTION) :
	n = len(SELECTION)
	compteur=0
	i=0
	while (i < n):
		j=0
		while (j < n):
			if SELECTION[i][j] == True:
				compteur += 1
			j += 1
		i += 1
	return compteur == n

#Initialisation de la variable SELECTION
def InitSELECTION(G) :
	n = len(G)
	res = dict()
	i=0
	while (i < n):
		res[i] = dict()
		j = 0
		while (j < n):
			res[i][j] = False
			j += 1
		i += 1
	return res

#On initialise la variable COUVERTURE
def InitCOUVERTURE(G, SELECTION) :
	
	return dict()

#Séléctionne les 0
def SectionDes0(G, SELECTION) :
	res = MatZero()
	n = len(G)
	tab = []
	#on veut selectionner un zero par ligne et colonne
	i = 0
	while (i<n):
		j=0
		while (j<n):
			if (G[i][j]==0):
			#on doit verifier que il n'y a pas de True sur la ligne ou la colonne
				l = 0
				while (l<len) :
					if (SELECTION[i][l]==False and SELECTION[l][j]==False):
						i+=1
					else
						if (l == n):
							SELECTION[i][j] = True
			j+=1
		i+=1
	return res
#renvoie les coordonnées d'un zéro non couvert
#{0:-1, 0:-1} si c'est pas possible
def ZeroNonCouvert(G, COUVERTURE) :
	return dict()

#On initialise la variable de marquage
def InitMarquage(G) :
	return dict()

#On marque le 0 dont les coordonées sont passées en paramètre
#La fonction renvoie les coordonnées du 0 sélectionné sur la même ligne que ZERO
#Renvoie {0:-1, 0:-1} si c'est pas possible
def marquage(ZERO, MARQUAGE, SELECTION) :
	return dict()


#Applique la numérotation des 0
#La valeur de retour est une matrice avec des -1 partout et on remplace
#les coordonée des 0 par leur numéro 0, 1, 2 etc...
def numerotation(INIT, SELECTION, MARQUAGE) :
	return ditc()

#Les éléments de la matrice numérotation avec un numéro paise passe à sectionné et les autre à non sélectionné
def	MajSELECTION(SELECTION, NUMEROTATION) :
	return

#Dans G on ajoute le minimum parmis les coef non couvert aux lignes couvertes et on le soustrait aux colonnes non couvertes
def MajG(G, COUVERTURE) :
	return G

#Algorithme hongrois
#Valeur de retour est un tableau ou la case i vaut j si l'affectation de i est j
def AlgoHongois(G) :
	return dict()

#Donne la valeur d'une affectation passé en paramètre
def ValeurAffectation(G, AFFECTATION) :
	try :
		n=len(G)
		if(n!=len(AFFECTATION)) : return -1
	except : return -1

	res=0
	i=0
	while(i<n):
		res=FracAdd(res, G[i][AFFECTATION[i]])
		i+=1
	return res

def ExempleDuCours() :
	n=5
	G=GrapheZero(n)
	G[0][0]=9
	G[0][1]=8
	G[0][2]=6
	G[0][3]=4
	G[0][4]=6

	G[1][0]=3
	G[1][1]=6
	G[1][2]=6
	G[1][3]=7
	G[1][4]=4

	G[2][0]=4
	G[2][1]=9
	G[2][2]=8
	G[2][3]=3
	G[2][4]=6

	G[3][0]=7
	G[3][1]=6
	G[3][2]=4
	G[3][3]=4
	G[3][4]=7

	G[4][0]=2
	G[4][1]=8
	G[4][2]=3
	G[4][3]=5
	G[4][4]=6

	print(GrapheAff(G))
	AFFECTATION = AlgoHongois(G)
	i=0
	print("Affection de valeur "+FracAff(ValeurAffectation(G, AFFECTATION))+" : ")
	while(i<n) :
		print("Tache "+str(i+1)+" : "+str(AFFECTATION[i]+1))
		i+=1

def ExempleAuHasard(n=5) :
	G=GrapheAleaVal_or(n, 1)
	print(GrapheAff(G))
	AFFECTATION = AlgoHongois(G)
	i=0
	print("Affection de valeur "+FracAff(ValeurAffectation(G, AFFECTATION))+" : ")
	while(i<n) :
		print("Tache "+str(i+1)+" : "+str(AFFECTATION[i]+1))
		i+=1

#Test
n=4
G=GrapheZero(n)
G[0][0]=4
G[0][1]=6
G[0][2]=7
G[0][3]=8

G[1][0]=2
G[1][1]=3
G[1][2]=6
G[1][3]=3

G[2][0]=1
G[2][1]=1
G[2][2]=2
G[2][3]=4

G[3][0]=3
G[3][1]=7
G[3][2]=1
G[3][3]=6

print(GrapheAff(G))
print("************************************")
print(GrapheAff(Apparition0Ligne(G)))
print("************************************")
print(GrapheAff(Apparition0Colonne(G)))
print("************************************")
print(InitSELECTION(G))
print(FinAlgoHongrois(InitSELECTION(G)))




#print("Exemple du cours")
#ExempleDuCours()

#print("Autre exemple")
#ExempleAuHasard(7)

#Problème des voeux en S4
#from ExtractVoeux import *
#MatAff(VOEUX)
