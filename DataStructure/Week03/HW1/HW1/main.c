#include <stdio.h>
void myName(void);
void func_recursive(char*);

int main(void) {
    myName();
    char X[100];
    printf("Input string\n");
    gets_s(X);
    puts("변경전:");
    puts(X);
    puts("변경후:");
    func_recursive(X); //재귀함수 호출
    printf("\n");
    return 0;
}

void func_recursive(char *arr){ //재귀함수 정의
    if (*(arr)!='\0'){ //인자로 받은 포인터변수 arr이 가리키는 위치에 저장된 값이 null이 아닌 경우
        func_recursive(arr+1); //인자에 1을 더해 배열의 다음 문자를 가리키게 함
        printf("%c",*(arr)); //문자 출력
    }
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
