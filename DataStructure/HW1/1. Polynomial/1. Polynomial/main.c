#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct ListNode { //다항식 항마다 생성되는 노드
    int coef; //계수
    int expon; //차수
    struct ListNode* link; //다음 연결리스트 주소
} ListNode;

typedef struct ListType { //다항식 정보 포함하는 노드
    int size; //다항식의 항수
    ListNode* head; //다항식 처음 노드 주소
    ListNode* tail; //다학식 마지막 노드 주소
} ListType;

//필요한 함수 선언
void error(const char* message);
void myName(void);
ListType* create(void);
void insert_last(ListType* p, int coef, int expon);
void poly_print(ListType* p);
void poly_cal(ListType* p, int x);

int main(void) {
    myName();
    ListType* p;
    p = create();
    printf("Input coef and exponent of polynomial<마지막항: exponent를 0으로 입력>\n");
    int coef=-1, expon=-1, x=0;
    while(1){
        scanf("%d",&coef); //계수 입력받음
        scanf("%d",&expon); //차수 입력받음
        insert_last(p, coef, expon);
        if (expon==0) break; //마지막 항
    }
    poly_print(p);
    
    printf("Input the value x: ");
    scanf("%d",&x);
    poly_cal(p,x);
    
    free(p);
    return 0;
}

ListType* create(void){ //다항식 정보를 저장하는 노드 생성
    ListType* p = (ListType*)malloc(sizeof(ListType));
    p->head = NULL;
    p->tail = NULL;
    p->size = 0;
    return p;
}

void insert_last(ListType* p, int coef, int expon){ //리스트 마지막에 항 추가
    ListNode* tmp = (ListNode*)malloc(sizeof(ListNode)); //추가할 노드 동적할당
    if (tmp == NULL) error("memory allocation error\n"); //메모리할당 실패
    tmp->coef = coef; //임시노드에 계수 대입
    tmp->expon = expon; //임시노드에 차수 대입
    tmp->link = NULL; //마지막에 추가하므로 임시노드가 가리키는 링크는 NULL
    if(p->tail == NULL) //빈 리스트면 새로운 노드가 유일한 노드가 됨
        p->head = p->tail = tmp;
    else{ //기존 노드가 있으면
        p->tail->link = tmp; //다항식 리스트의 맨 마지막에 새 노드 추가
        p->tail = tmp; //다항식 마지막 항의 정보를 새 노드 주소로 수정
    }
    p->size++; //다항식 항의 개수가 하나 증가
}

void poly_print(ListType* p){ //다항식 출력하는 함수
    ListNode* node = p->head; //다항식의 처음 원소를 가리키는 주소
    printf("<Polynomial>\n");
    for (int i=0; i<p->size-1; i++){ //마지막 항을 별도로 출력하기 위해 size 이용
        printf("%dx^%d + ", node->coef, node->expon);
        node = node->link; //node 변수가 다음 노드 가리킴
    }
    printf("%dx^%d\n\n", node->coef, node->expon); //마지막 항 출력
}

void poly_cal(ListType* p, int x){
    ListNode* node = p->head; //다항식의 처음 원소를 가리키는 주소
    int result = 0;
    for (int i=0; i<p->size; i++){ //마지막 항을 별도로 출력하기 위해 size 이용
        result += (node->coef) * (pow(x,node->expon));
        node = node->link; //node 변수가 다음 노드 가리킴
    }
    printf("Result of polynomial with x: %d\n", result); //결과 출력
}

void error(const char* message){
    fprintf(stderr, "%s\n", message);
    exit(1);
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
