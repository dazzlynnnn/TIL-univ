//
//  main.c
//  bubbleSort
//
//  Created by 이해린 on 2021/03/29.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 6
#define SWAP(x, y, t) ((t) = (x), (x) = (y), (y) = (t))

void bubble_sort(int list[], int n){
    int temp;
    printf("정렬할 원소 : ");
    for (int i=0; i<n; i++)
        printf("%3d ", list[i]);
    printf("\n\n< < < < < 버블 정렬 수행 > > > > >\n");
    for (int i=n-1; i>0; i--){ //제일 큰 걸 맨 뒤로 보내고 앞으로 쌓아감
        printf("\n %2d단계 > ", n-i);
        for (int j=0; j<i; j++)
            if (list[j]>list[j+1])
                SWAP(list[j], list[j+1], temp);
        for (int t=0; t<n; t++)
            printf("%3d ", list[t]);
    }
}

int main(int argc, const char * argv[]) {
    int list[MAX_SIZE];
    srand((int)time(NULL));
    
    for (int i=0; i<MAX_SIZE; i++){
        list[i] = rand() % 100;
        for (int j=0; j<i; j++)
            if(list[i]==list[j])
                i--;
    }
    
    bubble_sort(list, MAX_SIZE);

    return 0;
}
