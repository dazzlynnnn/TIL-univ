//
//  main.c
//  bdayCake
//
//  Created by 이해린 on 2021/03/21.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef struct ListNode{
    int elem;
    struct ListNode* next;
}ListNode;

void buildArrayList(int A[], int n){
    for (int i=0; i<n; i++)
        A[i] = i+1;
}

void printArrayList(int A[], int num){
    for (int i=0; i<num; i++)
        printf("%2d", A[i]);
    printf("\n");
}

ListNode* buildLinkedList(int n){
    ListNode* p = (ListNode*)malloc(sizeof(ListNode));
    ListNode* L = p;
    p->elem = 1;
    for (int i=2; i<=n; i++){
        p->next = (ListNode*)malloc(sizeof(ListNode));
        p = p->next;
        p->elem = i;
    }
    p->next = L;
    return L;
}

void printLinkedList(ListNode* L, int n){
    for (ListNode* p = L; n>0; p=p->next){
        printf("[%d] -> ", p->elem);
        n--;
    }
    printf("...back to first node\n");
}

int runSimulation1(int A[], int n, int k){ //배열 ver_1
    int r=0, i;
    int num = n;
    while(n>1){
        i=0;
        while(i<k){
            r = (r+1)%num;
            if (A[r]!=0)
                i++;
        }
        A[r] = 0;
        n--;
        while(A[r]==0)
            r = (r+1)%num;
        printArrayList(A, num);
    }
    return A[r];
}

int runSimulation2(int A[], int n, int k){ //배열 ver_2
    int r=0;
    while(n>1){
        r = (r+k) % n;
        for (int i=r; i<n; i++){
            A[i] = A[i+1];
        }
        A[n--] = 0;
        printArrayList(A, n);
    }
    return A[0];
}

int runSimulation3(ListNode* L, int n, int k){ //원형연결리스트 
    ListNode* p = L;
    while(p!=p->next){
        for (int i=1; i<k; i++)
            p = p->next;
        ListNode* pnext = p->next;
        p->next = p->next->next;
        free(pnext);
        p = p->next;
        printLinkedList(p, --n);
    }
    return p->elem;
}

int candle(int n, int k){
    ListNode* L = buildLinkedList(n);
    return runSimulation3(L, n, k);
}

int main(int argc, const char * argv[]) {
    int n, k;
    printf("초의 개수를 입력해 주세요 : ");
    scanf("%d",&n);
    printf("건너뛸 초의 개수를 입력해 주세요 : ");
    scanf("%d", &k);
    printf("\n");
    
    printf("\n마지막에 꺼지는 초는 %d번 초입니다.\n",candle(n,k));
    return 0;
}
