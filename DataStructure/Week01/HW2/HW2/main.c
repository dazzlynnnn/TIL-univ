#include <stdio.h>
#include <time.h>
#include <stdbool.h>

void myName(void){
    printf("=================\n학과:사이버보안전공\n학번:1971083\n성명:이해린\n=================\n");
}

bool isPrime(int n){ //n이 소수인지 확인하는 함수
    for (int i=2; i<n; i++){ //2부터 n-1까지 반복
        if (n%i==0) return false; //i로 n이 나누어 떨어지면 false 반환
    }
    return true; //그렇지 않으면 반복문 이후 true 반환
}

int main(void) {
    myName();
    int start, stop, cnt=0;
    int n;
    
    printf("Input n: ");
    scanf("%d", &n); //n값 입력받음
    start = clock();
    for (int i=2; i<=n; i++){
        if (isPrime(i)){ //i값이 소수이면
            printf("%5d",i); //화면에 출력하고
            cnt++; //개수 1 증가
        }
    }
    putchar('\n');
    stop = clock();
    printf("start: %d \n", start);
    printf("stop: %d \n", stop);
    printf("time1: %.2f sec\n", (double)(stop-start)/CLOCKS_PER_SEC); //수행시간 출력
    printf("There are %d prime numbers\n", cnt); //n까지의 수 중 소수 개수 출력
    return 0;
}

