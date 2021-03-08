#include <stdio.h>

void myName(void);
double iterative(int);
double recursive(int);

int main(void) {
    myName();
    int n; //양의 정수 입력받을 변수 선언
    while(1){
        printf("양의 정수 입력: ");
        scanf("%d", &n); //양의 정수 입력받음
        if (n<=0) break; //n이 0이하의 값이면 무한루프 break
        
        printf("Result from iterative: %.2f\n",iterative(n)); //반복함수 호출 및 출력
        printf("Result from recursive: %.2f\n",recursive(n)); //재귀함수 호출 및 출력
    }
    return 0;
}

double iterative(n){ //반복함수
    double result = 0;
    for (int i=n; i>0; i--){ //n부터 1까지 1씩 감소하는 반복문
        result += 1/(double)i; //기존 result에 1/n 더해서 저장
    }
    return result;
}

double recursive(n){ //재귀함수
    if (n>0){ //recursive(0)이 아니면
        return recursive(n-1) + 1/(double)n; //인자를 n-1으로 해서 자신을 다시 호출
    }
    else return 0; //recursive(0)이면
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
