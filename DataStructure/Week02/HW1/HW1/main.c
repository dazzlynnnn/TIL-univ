#include <stdio.h>

void myName(void);
void bin(int n);

int main(void) {
    myName();
    
    int n; //십진수 입력받을 변수 선언
    printf("양의정수 입력: ");
    scanf("%d",&n); //십진수 입력받음
    printf("십진수 %d의 이진표현: ", n);
    bin(n); //10진수를 2진수로 변환해서 출력해주는 함수 bin 호출
    printf("\n");
    return 0;
}

void bin(int n){
    int result[100]; //이진값을 저장할 배열 선언
    int i = 0; //인덱스 변수 선언
    do{
        result[i++] = n%2; //result 배열에 나머지를 넣은 후 인덱스 1 증가
        n = n/2; //n값을 몫으로 변경
    } while(n>0); //n이 0이 될 때까지 반복

    for (int j=i-1; j>=0; j--){ //배열 역순으로 출력하기 위한 반복문
        printf("%d", result[j]);
    }
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
