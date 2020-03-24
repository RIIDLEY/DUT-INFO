if [ $# != 3 ]; then
  echo -e "IL NOUS FAUT 3 ARGS !"
else
  max=$1
  tab=($*)
  for (( i = 0; i < 4; i++ )); do
    if [[ $max < ${tab[$i]} ]]; then
      max=${tab[$i]}
    fi
  done
echo $max
fi
