i=5
while [[ $i != 0  ]]; do
  printf  $i","
  i=$(($i-1))
done
echo -e \\n
