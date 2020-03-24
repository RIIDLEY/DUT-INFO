if [ -e $1  ]; then
    echo "Le fichier existe"
else
  echo "Le fichier n'existe pas"
fi
if [ -d $1  ]; then
  "c'est un répertoire"
fi
if [ -x $1  ]; then
  echo  "il est executable"
fi
