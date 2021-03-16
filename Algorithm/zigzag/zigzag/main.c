//
//  main.c
//  zigzag
//
//  Created by 이해린 on 2021/03/16.
//

#include <stdio.h>
#include <stdlib.h>

#define SIZE 5

void printArray(int A[][SIZE]){
    for(int i=0; i<SIZE; i++){
        for (int j=0; j<SIZE; j++){
            printf("%2d ",A[i][j]);
        }
        printf("\n");
    }
    
}

void zigzag(int A[][SIZE]){
    int value = 1;
    for (int i=0; i<SIZE; i++){
        if (i%2==0){
            for (int j=0; j<SIZE; j++)
                A[i][j] = value++;
        }
        else{
            for (int j=SIZE-1; j>=0; j--)
                A[i][j] = value++;
        }
    }
}

int main(int argc, const char * argv[]) {
    int A[SIZE][SIZE] = {0};
    zigzag(A);
    printArray(A);
    return 0;
}
