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
	return G

#Fait apparaitre un zéro par colonne
def Apparition0Colonne(G) : 
	return G

#Renvoie True si l'algorithme Hongrois est fini
def FinAlgoHongrois(SELECTION) : 
	return True
	
#Initialisation de la variable SELECTION
def InitSELECTION(G) :
	return dict()

#On initialise la variable COUVERTURE
def InitCOUVERTURE(G, SELECTION) :
	return dict()

#Séléctionne les 0
def SectionDes0(G, SELECTION) :
	return

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
print("Exemple du cours")
ExempleDuCours()

print("Autre exemple")
ExempleAuHasard(7)

#Problème des voeux en S4
from ExtractVoeux import *
MatAff(VOEUX)