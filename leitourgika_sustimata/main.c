#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

void createP2Children(pid_t p2);

int main() {
    pid_t p0, p1, p2 ;

    p0 = fork();
    if (p0 == 0) {
        //child
        printf("P1 process | PID: %d, PPID: %d\n", getpid(), getppid());
    } else {
        p1 = fork();
        if (p1 == 0) {
            //children
            printf("P2 process | PID: %d, PPID: %d\n", getpid(), getppid());
            createP2Children(p2);
        } else {
            //parent
            waitpid(p1,NULL,0);
            printf("P0 process | PID: %d, PPID: %d\n", getpid(), getppid());
            execlp("ps","ps",NULL);
        }
    }
}

/**
 * @code [pid_t]
 * @param [p2]
 * Loops three times & creates 3 children for P2 Process
 */

void createP2Children(pid_t p2){
    for (int i = 3; i < 6; i++) {
        p2 = fork();
        waitpid(p2,NULL,0);
        if (p2 == 0) {
            //children
            printf("P%d process | PID: %d, PPID: %d\n", i, getpid(), getppid());
            exit(0);
        }
    }
}