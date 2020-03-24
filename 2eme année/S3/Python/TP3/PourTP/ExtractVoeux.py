#Extraction des données depuis un fichier test.
def ExtractVoeux(txt) : 
	try :
		f=open(txt, "r")
		X=f.read()
		f.close()
	except :
		return
		
	voeux=dict() 
	
	n=len(X)
	i=0
	
	#Supression des espaces ou saut de ligne en trop au début
	while(i<n and (X[i]==' ' or X[i]=='\t' or X[i]=='\n')) :
		i=i+1
	
	TestFinMat=False
	l=0	#Indice de ligne
	while(i<n and not(TestFinMat)) :
		voeux[l]=dict()
		TestFinLigne=False
		c=0	#Indice de colonne
		while(i<n and not(TestFinLigne)) :
			x=""
			while(i<n and X[i]!=' ' and X[i]!='\t' and X[i]!='\n') :
				x=x+X[i]
				i=i+1
			
			#Formatage
			try :
				if(float(x)-int(x)==0) : 
					voeux[l][c]=int(x)
				else : 
					voeux[l][c]=float(x)
			except :
				voeux[l][c]=" "
			
			#Suppression des espaces ou tabulations inutiles
			while(i<n and (X[i]==' ' or X[i]=='\t')) :
				i=i+1
			
			#Si saut de ligne alors nouvelle ligne, sinon nouvelle colonne
			if(i<n and X[i]=='\n') :
				TestFinLigne=True
				l=l+1
				i=i+1
			else :
				c=c+1
			
	return voeux

VOEUX = ExtractVoeux("VoeuxS4.txt")