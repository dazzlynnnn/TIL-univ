//
//  main.c
//  hanoi
//
//  Created by 이해린 on 2021/03/15.
//

#include <stdio.h>
#include <stdlib.h>

void hanoi(int n, char from, char aux, char to){
    if (n==1)
        printf("Disk %d : Move from %c to %c\n", n, from, to);
    else{
        hanoi(n-1, from, to, aux);
        printf("Disk %d : Move from %c to %c\n", n, from, to);
        hanoi(n-1, aux, from, to);
    }
}

int main(int argc, const char * argv[]) {
    hanoi(4, 'A', 'B', 'C');
    return 0;
}
