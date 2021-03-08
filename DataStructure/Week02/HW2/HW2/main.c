#include <stdio.h>

void myName(void);
void iterative(int);
void recursive(int);

int main(void) {
    myName();
    
    int n; //양의 정수 입력받을 변수 선언
    printf("양의 정수 입력: ");
    scanf("%d", &n); //양의 정수 입력받음
    printf("반복함수호출: ");
    iterative(n); //반복함수 iterative 호출
    printf("\n");
    printf("재귀함수호출: ");
    recursive(n); //재귀함수 recursive 호출
    printf("\n");
    return 0;
}

void iterative(n){ //반복함수
    for (int i=n; i>=0; i--){ //n부터 0까지 1씩 감소하면서 출력
        printf("%d ",i);
    }
}

void recursive(n){ //재귀함수
    if (n>=0){ //recursive(-1)이 되면 멈춤
        printf("%d ",n);
        recursive(n-1); //n-1를 인자로 해서 자신을 다시 호출
    }
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
