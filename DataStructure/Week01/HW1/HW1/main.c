#include <stdio.h>
int main(void) {
    printf("=================\n학과: 사이버보안전공\n학번: 1971083\n성명: 이해린\n=================\n");
    int a;
    while(1){
        int sum=0; //합 저장 변수
        printf("\nInput an integer\n");
        scanf("%d", &a); //정수 a를 입력받음
        if (a>0){
            for (int i=0; i<a; i++){ //0부터 a까지 반복
                if (i%2!=0 && i%5!=0){ //홀수도 아니고 5의 배수도 아니면
                    sum+=i; //sum에 i값을 더함
                }
            }
            printf("Sum of odd numbers which is not the multiples of 5 between 1 and %d is %d\n", a, sum); //합 출력
        }
        else break; //0 이하의 값을 입력했을 때 while문 break
    }
    
    printf("Program finished\n\n");
    return 0;
}
