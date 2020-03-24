#include <stdio.h>
#include <math.h>

  int airrectangle(int l, int L){
    int somme = 0;
    somme = L * l;
    printf("Air : %d\n",somme);
  }

  int airdisque(int r){
    float somme = 0;
    somme = M_PI * r * r;
    printf("Air : %f\n",somme);
  }

  int sommetab(int tab[], int taille){
    int i=0;
    int somme=0;
    while (i<taille){
      somme += tab[i];
      i++;
    }
      printf("%d\n", somme);
  }

  int tab2(int tab1[], int tab2[], int taille1, int taille2){
    return tab1[0]==tab2[0] || tab1[taille1-1]==tab2[taille2-1];
  }

  int bindec(int a){
    int s = 0;
    int v = 1;
    while (a!=0) {
      s += a%10*v;
      a /=10;
      v <<= 1;
    }
    return s;
  }

  int add(int a, int b){
    return a+b;
  }

  int addp(int *a, int *b){
    return *a+*b;
  }

int main(){
  //int tab[5] = {1,2,3,4,5};
  //int tab1[5] = {1,5,45,2,5};
  //printf("%d\n",tab2(tab,tab1,5,5) );
  //printf("%d\n",bindec(1111));
  //int a = sizeof(tab1)/4;
  //printf("%d\n", a );
  int a = 10;
  int b = 10;
  printf("%p\n",&a );
  printf("%d\n",a );

  int *p=&a;

}
