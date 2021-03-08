//
//  main.c
//  mostOnes
//
//  Created by 이해린 on 2021/03/08.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 8
#define COLS 8

void makeArray(int A[][COLS]){
    for (int r = 0; r < ROWS; r++){
        int count = rand() % 9;
        for (int i = 0; i < count; i++)
            A[r][i] = 1;
        for (int j = count; j < COLS; j++)
            A[r][j] = 0;
    }
}

void printArray(int A[][COLS]){
    for (int r = 0; r < ROWS; r++){
        for (int c = 0; c < COLS; c++)
            printf("%2d ", A[r][c]);
        printf("\n");
    }
    printf("\n");
}

void mostOnesButSlow(int A[][COLS]){
    int jmax = 0;
    int i, j, row;
    for (i = 0; i < ROWS; i++){
        j = 0;
        while ((j < ROWS) && (A[i][j] == 1))
            j++;
        if (j > jmax){
            row = i;
            jmax = j;
        }
    }
    printf("%d행에 %d개의 1이 최대값임\n", row, jmax);
}

int mostOnes(int A[][COLS]){
    int i=0, j=0;
    int row;
    while(1){
        while(A[i][j]==1){
            j++;
            if (j == COLS)
                return i;
        }
        row = i;
        while(A[i][j]==0){
            i++;
            if (i == COLS)
                return row;
        }
    }
}

int main(int argc, const char * argv[]) {
    int A[ROWS][COLS];
    srand(time(NULL));
    makeArray(A);
    printArray(A);
    getchar();
    
    printf("최대 1행은 %d행입니다.\n",mostOnes(A));
    return 0;
}
