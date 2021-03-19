//
//  main.c
//  arrayList
//
//  Created by 이해린 on 2021/03/19.
//

#include <stdio.h>
#include <stdlib.h>

#define SIZE 100

typedef struct{
    int V[SIZE];
    int n;
}ArrayList;

void init(ArrayList* L){
    L->n = 0;
}

void traverse(ArrayList* L){
    for (int i=0; i<L->n; i++){
        printf("[%d] ", L->V[i]);
    }
    printf("\n");
}

void add(ArrayList* L, int pos, int item){
    if (L->n==SIZE){
        printf("fullListException\n");
        exit(1);
    }
    if (!(0<=pos&&pos<=L->n)){
        printf("invalidPosException\n");
        exit(1);
    }
    
    for (int i=L->n-1; i>=pos; i--)
        L->V[i+1] = L->V[i];
    L->V[pos] = item;
    L->n++;
}

int remove1(ArrayList* L, int pos){
    if (L->n==0){
        printf("emptyListException\n");
        exit(1);
    }
    if (!(0<=pos&&pos<=L->n)){
        printf("invalidPosException\n");
        exit(1);
    }
    int item = L->V[pos];
    for (int i=pos+1; i<=L->n-1; i++)
        L->V[i-1] = L->V[i];
    L->n--;
    return item;
}


int main(int argc, const char * argv[]) {
    ArrayList list;
    
    init(&list);
    add(&list, 0, 10); traverse(&list);
    add(&list, 0, 20); traverse(&list);
    add(&list, 1, 30); traverse(&list);
    add(&list, 1, 40); traverse(&list);
    add(&list, 3, 50); traverse(&list);

    getchar();
    remove1(&list, 1); traverse(&list);
    remove1(&list, 2); traverse(&list);

    return 0;
}
