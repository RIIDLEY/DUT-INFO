#include <unistd.h>

char *str="Bonjour\n";

int main(){
  write(1,str,8);
  return(0);



}
