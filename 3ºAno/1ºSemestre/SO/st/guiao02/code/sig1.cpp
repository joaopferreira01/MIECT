#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "delays.h"
#include "process.h"

#define NTIMES 10

int main(void)
{
    printf("Before the fork: PID = %d, PPID = %d\n", getpid(), getppid());

    pid_t ret = pfork();
    if (ret == 0)
    {
        printf("I'm the child: PID = %d, PPID = %d\n", getpid(), getppid());
    }
    else
    {
        printf("I'm the parent: PID = %d, PPID = %d\n", getpid(), getppid());
        usleep(20000);
        pwait(NULL); // processo pai espera q os filhos acabem
        printf("PID = %u\n", getpid());
        for (uint32_t i = 0; i < NTIMES; i++)
        {
            printf("\r%08u ", i);
            fflush(stdout);
            usleep(500000);
        }
        printf("\n");
    }

    return EXIT_SUCCESS;
}
