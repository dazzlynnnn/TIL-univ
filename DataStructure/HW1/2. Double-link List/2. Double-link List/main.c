#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct dListNode { //이중원형연결리스트 노드 구조
    element data;
    struct dListNode* llink; //왼쪽 노드 link
    struct dListNode* rlink; //오른쪽 노드 link
} dListNode;

//필요한 함수 선언
void init(dListNode* head);
void dinsert(dListNode* node, element val);
void print_dlist(dListNode* head);
void print_dlist_reverse(dListNode* head);
void myName(void);


int main(void) {
    myName();
    dListNode* head = (dListNode*)malloc(sizeof(dListNode));
    init(head); //head 노드 초기화
    
    int i=-1;
    printf("Input data in dual linkedlist<0 to quit>\n");
    while(1){
        scanf("%d",&i);
        if (i==0) break; //0 입력할 때까지 양의 정수 입력받음
        dinsert(head,i);
    }
    print_dlist(head);
    printf("Print the list in reverse order\n");
    print_dlist_reverse(head);
    free(head);
    return 0;
}

void init(dListNode* head) { //이중원형연결리스트 초기화
    head->llink = head;
    head->rlink = head;
}

void dinsert(dListNode* head, element val){ //새로운 데이터를 리스트의 마지막(헤드노드의 왼쪽)에 추가
    dListNode* newnode = (dListNode*)malloc(sizeof(dListNode)); //새로운 노드 생성
    newnode->data = val; //값 저장
    newnode->llink = head->llink; //새로운 노드의 llink는 헤드 노드의 llink가 가리키는 노드를 가리킴
    head->llink->rlink = newnode; //헤드 노드의 llink의 rlink가 가리키는 노드는 새로운 노드가 됨
    newnode->rlink = head; //새로운 노드의 rlink는 헤드 노드를 가리킴
    head->llink = newnode; //헤드 노드의 llink는 새로운 노드를 가리킴
    
}

void print_dlist(dListNode* head){ //리스트를 순서대로 출력하는 함수
    dListNode* p = NULL;
    for (p=head->rlink; p!=head; p=p->rlink){ //헤드 노드의 오른쪽으로 옮겨 가면서 data 출력
        printf("  %d   ", p->data);
        if (p->rlink==head) break;
        printf("<->");
    }
    printf("\n");
}

void print_dlist_reverse(dListNode* head){ //리스트를 역순으로 출력하는 함수
    dListNode* p = NULL;
    for (p=head->llink; p!=head; p=p->llink){ //헤드 노드의 왼쪽으로 옮겨 가면서 data 출력
        printf("  %d   ", p->data);
        if (p->llink==head) break;
        printf("<->");
    }
    printf("\n");
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
