#include <unistd.h>
#include <sys/types.h>
#define SP 3 /*changer pour 1, 2, 3 .... */

int main ( void ) {
char mesg[] = "ABCDEFGHIJ" ;
char *ptr;
pid_t n ;

ptr = mesg ;
n = fork() ;

while ( *ptr != '\0'){
    /*on parcourt mesg[] caractère par caractère*/
write(STDOUT_FILENO,ptr,1);
     ptr++ ;
     if (n==0) sleep(1);
     else sleep(SP);
   }
   return 0;
}
