#!/bin/bash

echo -e  \\n  \\t On d�clare la variable locale v1 \\n
v1=quelque_chose
echo -e  \\t  La valeur de v1 est :  $v1 \\n

echo -en  \\t  Entrez la nouvelle valeur de v1 :
read v1 #input
while [[ -z $v1 ]]; do  # tant que v1  est vide
	echo  -e  \\t La valeur de v1 est vide \\n
	echo -e  \\t Comme preuve je vous l\'affiche : $v1 \\n
	echo -en  \\t  Entrez la nouvelle valeur de v1 :
	read v1
done

echo   "  Nouvelle valeur de v1 : $v1 "
