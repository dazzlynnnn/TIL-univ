//
//  main.c
//  mergeSort
//
//  Created by 이해린 on 2021/04/19.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 15
int sorted[MAX_SIZE];

void merge(int list[], int left, int mid, int right){
    int i=left;
    int j=mid+1;
    int k=left;
    int l;
    
    while(i<=mid && j<=right){
        if (list[i]<=list[j])
            sorted[k++]=list[i++];
        else
            sorted[k++]=list[j++];
    }
    if (i>mid)
        for(l=j; l<=right; l++)
            sorted[k++] = list[l];
    else
        for(l=i; l<=mid; l++)
            sorted[k++] = list[l];
    
    for (l=left; l<=right; l++)
        list[l] = sorted[l];
}

void mergeSort(int list[], int left, int right){
    int mid;
    if (left < right){
        mid = (left + right)/2;
        mergeSort(list, left, mid);
        mergeSort(list, mid+1, right);
        merge(list, left, mid, right);
    }
}


int main(int argc, const char * argv[]) {
    int list[MAX_SIZE];
    srand((int)time(NULL));
    for (int i=0; i<MAX_SIZE; i++){
        list[i] = rand()%100;
        for (int j=0; j<i; j++)
            if (list[i]==list[j])
                i--;
    }
    
    for (int i=0; i<MAX_SIZE; i++)
        printf("[%d] ", list[i]);
    printf("\n"); getchar();
    
    mergeSort(list, 0, MAX_SIZE);
    
    for (int i=0; i<MAX_SIZE; i++)
        printf("[%d] ", list[i]);
    printf("\n\n"); getchar();
}
