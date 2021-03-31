//
//  main.c
//  shell_sort
//
//  Created by 이해린 on 2021/03/31.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 11
#define SWAP(x, y, t) ((t) = (x), (x) = (y), (y) = (t))

void inc_insertion_sort(int list[], int first, int last, int gap){
    int i, j, key;
    for (i=first+gap; i<=last; i+=gap){
        key = list[i];
        for (j=i-gap; j>=first && list[j]>key; j-=gap)
            list[j+gap] = list[j];
        list[j+gap] = key;
    }
}

void shell_sort(int list[], int n){
    int i, gap;
    for (gap = n/2; gap > 0; gap = gap/2){
        if (gap % 2 == 0)
            gap++; //홀수의 성능이 더 좋음
        for (i=0; i<gap; i++)
            inc_insertion_sort(list, i, n-1, gap);
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
    
    for (int i=0; i<MAX_SIZE; i++)
        printf("%d ", list[i]);
    printf("\n");
    
    shell_sort(list, MAX_SIZE);
    
    for (int i=0; i<MAX_SIZE; i++)
        printf("%d ", list[i]);
    printf("\n");
    return 0;
}
