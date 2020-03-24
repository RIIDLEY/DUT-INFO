#include <stdio.h>

int main(){

  int tab[5] = {1,2,3,4,5};
  int tab1[5] = {1,5,45,2,5};

  if (tab1[0]==tab[0]){
      printf("La premiere valeur est identique \n");
  }

  if (tab1[4]==tab[4]){
      printf("La dernier valeur est identique \n");
  }

}
