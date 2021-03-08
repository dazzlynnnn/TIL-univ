#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode{ //단순연결리스트
    int data;
    struct ListNode* link;
} ListNode;

ListNode* insert_first(ListNode* head, int num){ //맨앞에 노드를 추가하는 함수
    ListNode* newnode = (ListNode*)malloc(sizeof(ListNode)); //새로운 노드 생성
    newnode->data = num; //새로운 노드의 값 저장
    newnode->link = head; //새로운 노드가 기존의 head를 가리킴
    head = newnode; //새로운 노드가 기존의 head가 됨
    return head; //새로운 head 리턴
}

void insert(ListNode* p, int num){ //p 뒤에 새로운 노드를 추가하는 함수
    ListNode* newnode = (ListNode*)malloc(sizeof(ListNode)); //새로운 노드 생성
    newnode->data = num; //새로운 노드의 값 저장
    newnode->link = p->link; //새로운 노드가 기존의 p가 가리키던 노드를 가리킴
    p->link = newnode; //기존의 p는 새로운 노드를 가리킴
}

ListNode* insert_sort(ListNode* head, int num){ //리스트 내의 숫자들이 항상 오름차순을 유지할 수 있도록 적절히 insert하는 함수
    if(head == NULL || head->data > num) head = insert_first(head,num); //리스트가 비어 있거나 새로 입력되는 숫자가 가장 작은 경우
    else{
        for (ListNode* p = head; p != NULL; p=p->link){ //head부터 링크를 증가시키며 값을 비교하여 insert할 위치(p 다음)을 찾음
            if (p->link == NULL){ //p가 가리키는 노드가 없을 때 새로 입력되는 숫자가 가장 마지막에 insert
                insert(p, num);
                break;
            }
            else if (p->link->data > num){ //p가 가리키는 노드의 값이 새로 입력되는 숫자보다 클 때 p 뒤에 새로운 숫자 insert
                insert(p, num);
                break;
            }
        }
    }
    return head;
}

void print_list(ListNode* head){ //head부터 링크로 연결된 노드의 data를 계속 출력
    for (ListNode* p = head; p != NULL; p = p->link) printf("%3d ->", p->data);
    printf("   NULL\n");
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

int main(void) {
    myName();
    ListNode* head = NULL;
    int n = 0;
    printf("Input data to insert to linkedlist<0 to quit>\n");
    while(1){
        scanf("%d",&n);
        if (n==0) break;
        head = insert_sort(head, n);
        print_list(head);
    }
    print_list(head);
    return 0;
}
