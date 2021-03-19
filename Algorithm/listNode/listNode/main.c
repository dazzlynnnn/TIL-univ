//
//  main.c
//  listNode
//
//  Created by 이해린 on 2021/03/19.
//

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct ListNode{
    int data;
    struct ListNode* link;
}ListNode;

typedef struct{
    ListNode* head;
}LinkedListType;

//일반 메소드
void init(LinkedListType* L){
    L->head = NULL;
}

bool isEmpty(LinkedListType* L){
    if (L->head == NULL)
        return true;
    else
        return false;
}

int size(LinkedListType* L){
    int size=0;
    for (ListNode* p = L->head; p!=NULL; p=p->link)
        size++;
    return size;
}

void printList(LinkedListType* L){ //Iterator elements() 대신
    for (ListNode* p = L->head; p!=NULL; p=p->link)
        printf("[%d] -> ", p->data);
    printf("NULL\n");
}

//접근 메소드
int get(LinkedListType* L, int pos){
    if (pos<0 || size(L)<=pos){
        printf("invalidRankException...\n");
        exit(1);
    }
    ListNode* p = L->head;
    for(int i=0; i<pos; i++)
        p = p->link;
    return p->data;
}

//갱신 메소드
void set(LinkedListType* L, int pos, int item){
    if (pos<0 || size(L)<=pos){
        printf("invalidRankException...\n");
        exit(1);
    }
    ListNode* p = L->head;
    for(int i=0; i<pos; i++)
        p = p->link;
    p->data = item;
}

void addFirst(LinkedListType* L, int item){
    ListNode* node = (ListNode*)malloc(sizeof(ListNode));
    node->data = item;
    node->link = L->head;
    L->head = node;
}

void add(LinkedListType* L, int pos, int item){
    if (pos<0 || size(L)<pos){
        printf("invalidRankException...\n");
        exit(1);
    }
    if (pos==0) return(addFirst(L, item));
    ListNode* node = (ListNode*)malloc(sizeof(ListNode));
    ListNode* before = L->head;
    for (int i=0; i<pos-1; i++)
        before = before->link;
    node->data = item;
    node->link = before->link;
    before->link = node;
}

void addLast(LinkedListType* L, int item){
    return add(L, size(L), item);
}

int removeFirst(LinkedListType* L){
    if (isEmpty(L)){
        printf("emptyListException...\n");
        exit(1);
    }
    ListNode* node = L->head;
    int item = node->data;
    L->head = node->link;
    free(node);
    return item;
}

int remove1(LinkedListType* L, int pos){ //함수명 중복으로 remove1으로 메소드 생성했습니다
    if (isEmpty(L)){
        printf("emptyListException...\n");
        exit(1);
    }
    else if (pos<0 || size(L)<=pos){
        printf("invalidRankException...\n");
        exit(1);
    }
    if (pos==0) return removeFirst(L);
    ListNode* before = L->head;
    for (int i=0; i<pos-1; i++)
        before = before->link;
    ListNode* node = before->link;
    int item = node->data;
    before->link = node->link;
    free(node);
    return item;
}

int removeLast(LinkedListType* L){
    return remove1(L, size(L)-1);
}

int main(int argc, const char * argv[]) {
    
    LinkedListType list;
    init(&list);
    
    addFirst(&list, 10); printList(&list);
    addFirst(&list, 20); printList(&list);
    add(&list, 0, 30); printList(&list);
    add(&list, 0, 40); printList(&list);
    add(&list, 4, 50); printList(&list);
    addLast(&list, 60); printList(&list);
    addLast(&list, 70); printList(&list);

    removeFirst(&list); printList(&list);
    remove1(&list, 0); printList(&list);
    remove1(&list, 4); printList(&list);
    remove1(&list, 2); printList(&list);

    int pos, item;
    printf("\n몇 번 노드의 값을 변경할까요? : ");
    scanf("%d",&pos);
    printf("%d번 노드의 값을 몇으로 변경할까요? : ", pos);
    scanf("%d",&item);
    set(&list, pos, item);
    printList(&list);
    printf("\n몇 번 노드의 값을 반환할까요? : ");
    scanf("%d",&pos);
    printf("%d번 노드의 값은 %d\n", pos, get(&list, pos));
    printf("\n리스트의 크기는 %d입니다.\n", size(&list));
    return 0;
}
