#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char* argv[])
{
 pid_t mojpid, x;
 mojpid = getpid();
 printf("[%u]: Uruchamiam ls -l -a\n", mojpid);
 x = fork();
 if (x == 0)
 {
 if (execl("/bin/ls", "ls", "-l", "-a", NULL) == -1)
 {
 printf("Uruchomienie ls nie powiodlo sie\n");
 }
 }
 else
 {
 waitpid(x, NULL, 0);
 printf("[%u]: ls -l -a zakonczony\n", mojpid);
 }
 return 0;
}
