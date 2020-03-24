#include <stdio.h>
#define N 5 //variable N=5
int main(){
  int tab[N];
  int i=0;
  int somme=0;
  int p;
  int min;
  int max;

  while(i<N){
    scanf("%d",&p); //rentre valeur dans le tableau
    tab[i]= p;
    somme = somme + tab[i]; //somme du tableau
    i++;
  }
max=tab[0];
min=tab[0];
i=0;
    while(i<N){ //calcule du min
      if(min>tab[i]){
        min=tab[i];
      }
      i++;
      }
i=0;
      while(i<N){ //calcule du max
        if(max<tab[i]){
          max=tab[i];
        }
        i++;
        }

      printf("somme %d\n",somme);
      printf("minimum %d\n",min);
      printf("maximum %d\n",max );
    }
