//
//  main.c
//  quickSort
//
//  Created by 이해린 on 2021/04/19.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 15
#define SWAP(x, y, t) ((t)=(x), (x)=(y), (y)=(t))

int partition(int list[], int left, int right, int k){
    int pivot, temp, low, high;
    
    pivot = list[k];
    SWAP(list[k], list[right], temp);
    
    low = left-1;
    high = right;
    
    do{
        do
            low++;
        while(list[low]<pivot);
        do
            high--;
        while(list[high]>pivot);
        if (low<high)
            SWAP(list[low], list[high], temp);
    }while (low<high);
    
    SWAP(list[low], list[right], temp);
    return low;
}


void quickSort(int list[], int left, int right){
    if(left<right){
        int k = rand()%(right-left) + left + 1;
        int q = partition(list, left, right, k);
        quickSort(list, left, q-1);
        quickSort(list, q+1, right);
    }
}



int main(int argc, const char * argv[]) {
    int list[MAX_SIZE];
    srand((int)time(NULL));
    for (int i=0; i<MAX_SIZE; i++)
        list[i] = rand()%100;
    for (int i=0; i<MAX_SIZE; i++)
        printf("[%d] ", list[i]);
    printf("\n\n"); getchar();
    
    quickSort(list, 0, MAX_SIZE-1);
    for (int i=0; i<MAX_SIZE; i++)
        printf("[%d] ", list[i]);
    printf("\n");
    return 0;
}
