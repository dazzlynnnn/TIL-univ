//
//  main.c
//  buildHeap
//
//  Created by 이해린 on 2021/04/11.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_ELEMENT 100

struct Heap{
    int H[MAX_ELEMENT];
    int n;
}_Heap;

void downHeap(int i){
    if (i*2 > _Heap.n) return;
    if (_Heap.H[i] < _Heap.H[i*2] || _Heap.H[i] < _Heap.H[i*2+1]){
        if (_Heap.H[i*2] > _Heap.H[i*2+1]){
            int temp;
            temp = _Heap.H[i];
            _Heap.H[i] = _Heap.H[i*2];
            _Heap.H[i*2] = temp;
            downHeap(i*2);
        }
        else{
            int temp;
            temp = _Heap.H[i];
            _Heap.H[i] = _Heap.H[i*2+1];
            _Heap.H[i*2+1] = temp;
            downHeap(i*2+1);
        }
    }
    else return;
}

void buildHeap(){
    for (int i = _Heap.n / 2; i>=1; i--)
        downHeap(i);
}

void rbuildHeap(int i){
    if (i>_Heap.n)
        return;
    if (i*2<=_Heap.n)
        rbuildHeap(i*2);
    if (i*2+1<=_Heap.n)
        rbuildHeap(i*2+1);
    downHeap(i);
}

int removeMax(){
    int key = _Heap.H[1];
    _Heap.H[1] = _Heap.H[_Heap.n--];
    downHeap(1);
    return key;
}

void inPlaceHeapSort(){
    int size = _Heap.n;
    int key;
    for (int i=0; i<size; i++){
        key = removeMax();
        _Heap.H[_Heap.n+1] = key;
    }
}

void printHeap(){
    for (int i=1; i<=_Heap.n; i++)
        printf("[%d] ", _Heap.H[i]);
    printf("\n");
}

void printArray(){
    for (int i=1; _Heap.H[i]>0; i++)
        printf("[%d] ", _Heap.H[i]);
    printf("\n");
}

int main(int argc, const char * argv[]) {
    _Heap.n = 0;
    srand((int)time(NULL));
    printf("입력할 원소의 개수 : ");
    scanf("%d", &_Heap.n);
    for (int i=1; i<=_Heap.n; i++)
        _Heap.H[i] = rand() % 100;
    buildHeap();
    printHeap();
    getchar();
    inPlaceHeapSort();
    printArray();
    return 0;
}
