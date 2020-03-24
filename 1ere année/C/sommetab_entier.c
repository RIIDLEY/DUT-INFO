#include <stdio.h>

int main(){
  
  int tab[5] = {1,2,3,4,5};
  int i=0;
  int somme=0;

  while (i<5){
    somme += tab[i];
    i++;
  }
    printf("%d\n", somme);
}
