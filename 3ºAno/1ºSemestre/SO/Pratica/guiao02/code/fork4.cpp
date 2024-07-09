#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#include "delays.h"
#include "process.h"

int main(void)
{
  printf("Before the fork: PID = %d, PPID = %d\n", getpid(), getppid());

  pid_t ret = pfork();
  if (ret == 0)
  {
    execl("./child", "./child", NULL);      // substitui completamente o processo pelo ficheiro ./child e as proximas linhas não são executadas
    printf("why doesn't this message show up?\n");
    return EXIT_FAILURE;
  }
  else
  {
    printf("I'm the parent: PID = %d, PPID = %d\n", getpid(), getppid());
    usleep(100000);  
    pwait(NULL);
  }

  return EXIT_SUCCESS;
}
