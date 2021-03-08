#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX 100

//typedef
typedef char element;
typedef struct StackNode { //스택노드 구조체
    element data; //알파벳
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
element peek(LinkedStackType*);
void push(LinkedStackType*, element);
void stack_char(element*, LinkedStackType*);

int main(void) {
    myName();
    element i[MAX]; //문자열 입력 받을 배열
    LinkedStackType s; //동적 스택 헤드포인터 선언
    while(1){
        printf("반복되는 알파벳으로 구성된 문자열 입력<종료시 \"0\" 입력>\n");
        scanf("%s",i);
        getchar();
        if (strcmp("0",&i[0])==0) break; //0 입력하면 반복문 종료
        stack_char(i, &s);
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
element peek(LinkedStackType* s){
    if (is_empty(s)){ //스택이 빈 경우 peek을 하지 않고 종료
        error("Stack empty");
        exit(1);
    }
    else return s->top->data;       //top이 가리키는 원소값 반환
}
void push(LinkedStackType* s, element i){
    StackNode* temp = (StackNode*)malloc(sizeof(StackNode)); //새로 추가할 노드 생성
    temp->data = i;         //데이터 저장
    temp->link = s->top;    //새로 생성된 노드의 link가 기존의 top을 가리킴
    s->top = temp;          //새로 생성된 노드가 새로운 top이 됨
}
void stack_char(element* i, LinkedStackType* s){ //반복되는 문자가 다수 등장하는 문자열을 간단하게 출력하는 함수
    i[strlen(i)+1]=' '; //배열 마지막 원소에 공백 입력
    init(s); //스택 초기화
    for (int a=0; a<=strlen(i); a++){ //배열 길이+1 만큼 반복
        if (is_empty(s) || i[a]==peek(s)) push(s, i[a]); //스택이 비었거나, peek(s)한 알파벳이 배열의 알파벳과 같으면 push
        else { //peek(s)한 알파벳과 배열의 알파벳이 다르면
            int cnt=0;
            char c = peek(s); //출력할 알파벳
            while(!is_empty(s)){ //스택이 빌 때까지
                pop(s);
                cnt++; //count 개수 올림
            }
            printf("%d%c", cnt, c);
            push(s, i[a]); //pop을 하고 빈 스택에 새로운 알파벳 push
        }
    }
    printf("\n\n");
}
void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
