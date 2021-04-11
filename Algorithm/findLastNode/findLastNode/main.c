//
//  main.c
//  findLastNode
//
//  Created by 이해린 on 2021/04/12.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_ELEMENT 100

typedef struct {
    int H[MAX_ELEMENT];
    int n;
} HeapType;

typedef struct {
    int S[MAX_ELEMENT];
    int top;
} StackType;

void initHeap(HeapType *h){
    h->n = 0;
}

void initStack(StackType *s){
    s->top = -1;
}

void push(StackType *s, int key){
    if (s->top == (MAX_ELEMENT-1)){
        printf("Overflow\n");
        return;
    }
    else s->S[++(s->top)] = key;
}

int pop(StackType *s){
    if (s->top == -1){
        printf("Stack Empty\n");
        exit(1);
    }
    else return s->S[(s->top)--];
}

void upHeap(HeapType *h){
    int i = h->n;
    int key = h->H[i];

    while((i!=1) && (key < h->H[i/2])){
        h->H[i] = h->H[i/2];
        i /= 2;
    }
    h->H[i] = key;
}

void insertItem(HeapType *h, int key){
    h->n++;
    h->H[h->n] = key;
    upHeap(h);
}

void printHeap(HeapType *h){
    for (int i=1; i<= h->n; i++)
        printf("[%d] ", h->H[i]);
    printf("\n");
}

void binaryExpansion(int i, StackType *s){
    while(i>=2){
        push(s, i%2);
        i /= 2;
    }
    push(s, i);
    return;
}

int findLastNode(HeapType *v, int n){
    int bit;
    int i=1;
    StackType stack;
    initStack(&stack);
    binaryExpansion(n, &stack);
    pop(&stack);
    while(stack.top!=-1){
        bit = pop(&stack);
        if (bit==0)
            i = i*2;
        else
            i = i*2+1;
    }
    return v->H[i];
}

int main(int argc, const char * argv[]) {
    srand((int)time(NULL));
    int n;
    HeapType heap;
    initHeap(&heap);
    
    printf("입력할 원소의 개수 : ");
    scanf("%d", &n);
    for (int i=0; i<n; i++)
        insertItem(&heap, rand()%100);
    printHeap(&heap);
    printf("마지막 노드 : %d\n", findLastNode(&heap, n));
    
    return 0;
}
