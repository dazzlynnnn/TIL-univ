#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//typedef
typedef int element;
typedef struct StackNode { //스택노드 구조체
    element data; //2진수값
    struct StackNode* link; //다음 노드 주소
} StackNode;
typedef struct LinkedStackType { //스택 top 노드 주소
    StackNode *top;
} LinkedStackType;

//필요한 함수 선언
void myName(void);
void init(LinkedStackType*);
void error(const char*);
bool is_empty(LinkedStackType*);
element pop(LinkedStackType*);
void push(LinkedStackType*, element);
void print_stack(LinkedStackType*);
void stack_bin(element, LinkedStackType*);

int main(void) {
    myName();
    element i=0; //십진수 입력 받을 변수
    LinkedStackType s; //동적 스택 헤드포인터 선언
    while(1){
        printf("십진수 입력<종료: 0 이하 입력>\n");
        scanf("%d",&i);
        if (i<=0) break; //0 이하 입력하면 반복문 종료
        stack_bin(i, &s);
    }
    return 0;
}

void init(LinkedStackType* s){ //스택 초기화 함수
    s->top = NULL; //초기에는 빈 스택
}
void error(const char X[]){ //오류 핸들링 함수
    fprintf(stderr, X);
}
bool is_empty(LinkedStackType* s){ //스택이 비었는지 확인하는 함수
    return (s->top ==NULL); //top이 NULL이면(빈 스택) true 반환
}
element pop(LinkedStackType* s){
    if (is_empty(s)){ //스택이 빈 경우 pop을 하지 않고 종료
        error("Stack empty");
        exit(1);
    }
    else {
        StackNode* temp = s->top;   //포인터 temp가 삭제할 노드를 가리킴
        element data = temp->data;  //반환할 값을 저장
        s->top = s->top->link;      //top이 가리키던 원소가 가리키는 link가 새로운 top이 됨
        free(temp);                 //삭제된 노드가 사용하던 메모리 반환
        return data;                //top이 기존에 가리키던 원소값 반환
    }
}
void push(LinkedStackType* s, element i){
    StackNode* temp = (StackNode*)malloc(sizeof(StackNode)); //새로 추가할 노드 생성
    temp->data = i;         //데이터 저장
    temp->link = s->top;    //새로 생성된 노드의 link가 기존의 top을 가리킴
    s->top = temp;          //새로 생성된 노드가 새로운 top이 됨
}
void print_stack(LinkedStackType* s){
    for (StackNode* p = s->top; p!=NULL; p=p->link){
        printf("%d",p->data); //top에서부터 링크를 이동하면서 NULL이 아닐 동안 출력
    }
}
void stack_bin(element i, LinkedStackType* s){ //십진수를 이진수로 변환한 결과를 출력하는 함수
    init(s); //스택 초기화
    element r; //나머지를 저장할 변수
    while(1){
        r=i%2; i=i/2; //2진수 계산
        push(s, r); //2진수 push
        if (i==0) break; //나누어지는 수가 0이 되면 반복문 종료
    }
    printf("이진수 표현: ");
    print_stack(s); //2진수 pop하면서 print
    printf("\n\n");
}
void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
