#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100

typedef char element;
typedef struct stack {
    element data[MAX];
    int top;
}StackType;

void symmetric_array(char* arr){ //배열을 이용해서 문자열이 대칭인지 체크하는 함수
    int r=1; //결과값
    for (int i=0; i<strlen(arr); i++){ //인덱스 하나하나 앞과 뒤를 비교
        if (arr[i]!=arr[strlen(arr)-i-1]){ //비대칭인 경우
            r=0; break;
        }
    }
    if (r==1) printf("대칭<배열>\n");
    else printf("비대칭<배열>\n");
}

void init_stack(StackType* s){ //스택 초기화 함수
    s->top = -1;
}

element pop(StackType *s){
    if (s->top==-1){
        printf("Stack empty");
        exit(1);
    }
    else return s->data[(s->top)--]; //top의 데이터를 리턴한 후 1 감소
}

void push(StackType* s, element item){
    if(s->top==(MAX-1)) printf("Overflow");
    else s->data[++(s->top)]=item; //top 1 증가 후 해당 위치에 데이터 저장
}

void symmetric_stack(char* arr){ //스택을 이용해서 문자열이 대칭인지 체크하는 함수
    StackType* s = (StackType*)malloc(sizeof(StackType)); //스택 생성
    char ch;
    int r=1; //결과값
    init_stack(s);
    for (int i=0; i<strlen(arr) ;i++){ //문자열을 앞에서부터 스택에 push
        ch = arr[i];
        push(s,ch);
    }
    for (int i=0; i<strlen(arr) ;i++){
        if (pop(s)!=arr[i]){ //pop 한 게(역순) arr 문자열이랑 다르면 비대칭
            r=0; break;
        }
    }
    if (r==1) printf("대칭<스택>\n");
    else printf("비대칭<스택>\n");
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
    char arr[MAX];
    
    while(1){
        printf("\n알파벳으로 구성된 문자열 입력\n");
        scanf("%s",arr);
        if (arr[0]=='0') break;
        symmetric_array(arr);
        symmetric_stack(arr);
    }
    return 0;
}
