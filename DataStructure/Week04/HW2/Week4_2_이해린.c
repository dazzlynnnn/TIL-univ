#include <stdio.h>
#include <stdlib.h>

//typedef
typedef int element;
typedef struct dListNode { //정수를 입력할 떄마다 생성되는 노드
    element data; //입력한 정수 데이터
    struct dListNode* llink; //이전 노드 주소
    struct dListNode* rlink; //다음 노드 주소
} dListNode;

//필요한 함수 선언
void myName(void);
void init(dListNode* phead);
void error(const char* message);
void dinsert(dListNode* phead, element val);
void ddelete(dListNode* phead);
void print_dlist(dListNode* phead);

//메인 함수
int main(void) {
    myName();
    int input = 0; //정수 입력받을 변수 선언 및 초기화
    dListNode* head = (dListNode*)malloc(sizeof(dListNode));
    init(head); //head 노드 초기화
    
    while(1){
        printf("Input an integer to add<0 to quit>: ");
        scanf("%d",&input);
        if (input==0) break; //사용자가 0을 입력하면 노드 추가 종료
        dinsert(head, input);
    }
    print_dlist(head);
    ddelete(head);
    free(head);
    return 0;
}

void init(dListNode* phead){ //이중연결리스트 초기화 함수
    phead->rlink = phead;
    phead->llink = phead;
}

void dinsert(dListNode* phead, element val){ //head 노드 바로 다음에 새로운 노드 insert 하는 함수
    dListNode* newnode = (dListNode*)malloc(sizeof(dListNode)); //추가할 노드 생성 후 메모리 동적 할당
    if (newnode == NULL) error("memory allocation error\n"); //메모리 할당 실패
    newnode->data = val; //값 대입
    newnode->rlink = phead->rlink; //새로운 노드의 rlink는 head 노드의 rlink가 가리키는 값을 가짐
    phead->rlink->llink = newnode; //head 노드의 rlink 노드의 llink가 새로운 노드를 가리킴
    newnode->llink = phead; //새로운 노드의 llink는 head 노드를 가리킴
    phead->rlink = newnode; //head 노드의 rlink는 새로운 노드를 가리킴
}
void ddelete(dListNode* phead){ //삭제를 원하는 값을 입력받아 search하고 delete한 결과를 출력하는 함수
    int num=0; //정수 입력받을 변수 선언 및 초기화
    dListNode* remove = NULL; //검색 결과 넣을 노드 구조체 변수 선언 및 NULL로 초기화
    printf("Input a number to search and delete : ");
    scanf("%d", &num); //삭제를 원하는 값 입력받음
    for (dListNode* p=phead->rlink; p!=phead; p=p->rlink){ //head의 rlink 노드부터 하나씩 이동하면서 검색
        if (p->data == num) remove = p; //검색된 값이 있으면 remove에 검색된 노드 대입
    }
    if (remove == NULL) printf("%d is not in the list\n",num); //검색된 값이 없을 때
    else{ //검색된 값이 있을 때
        remove->llink->rlink = remove->rlink;
        //remove 노드의 왼쪽 노드의 rlink가 remove 노드의 오른쪽 노드를 가리키게 함
        remove->rlink->llink = remove->llink;
        //remove 노드의 오른쪽 노드의 llink가 remove 노드의 왼쪽 노드를 가리키게 함
        printf("%d is found and deleted\n",num);
    }
    print_dlist(phead); //삭제 완료된 리스트 출력
    free(remove);
}
void print_dlist(dListNode* phead){ //리스트 출력 함수
    printf("<List>\n");
    for (dListNode* p=phead->rlink; p!=phead; p=p->rlink){ //head의 rlink 노드부터 하나씩 이동하면서 출력
        printf("%d  ", p->data);
    }
    printf("\n");
}

void error(const char* message){ //error 처리 함수
    fprintf(stderr,"%s\n",message); //error message 출력
    exit(1); //프로그램 종료
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
