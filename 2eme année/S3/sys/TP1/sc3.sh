if [ $# != 2 ]; then
  echo -e "   Ce script qui s'appelle $0 n'a pas assez d'argument, il nous en faut 2 ! \\n"
else
  echo $(($1 + $2))
fi
