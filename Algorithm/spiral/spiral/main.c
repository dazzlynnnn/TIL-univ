//
//  main.c
//  spiral
//
//  Created by 이해린 on 2021/03/16.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

void printArray(int A[][MAX], int n, int m){
    for(int i=0; i<n; i++){
        for (int j=0; j<m; j++){
            printf("%2d ",A[i][j]);
        }
        printf("\n");
    }
}

void spiral(int A[][MAX], int n, int m){
    int left=0, right=m-1;
    int top=0, bottom=n-1;
    int value=1;
    while(left<=right && top<=bottom){
        for (int j=left; j<=right; j++)
            A[top][j] = value++;
        top++;
        
        if (top<=bottom){
            for (int i=top; i<=bottom; i++)
                A[i][right] = value++;
            right--;
        }
        
        if (left<=right){
            for (int j=right; j>=left; j--)
                A[bottom][j] = value++;
            bottom--;
        }
        
        if (top<=bottom){
            for (int i=bottom; i>=top; i--)
                A[i][left] = value++;
            left++;
        }
    }
}

int main(int argc, const char * argv[]) {
    int n, m;
    int A[][MAX] = {0};

    printf("input n : ");
    scanf("%d", &n);
    printf("input m : ");
    scanf("%d", &m);
    
    spiral(A, n, m);
    printArray(A, n, m);
    return 0;
}
