#include <stdio.h>
#define MAX 100

void myName(void);
void elementGeneration(int* arr, int *a);
void elementInsertion(int* arr, int *a);
void elementDeletion(int* arr, int *a);
void elementPrint(int* arr, int *a);
//함수 모두 main에서 선언한 변수 a의 값을 수정하기 위해서 인자를 포인터로 설정

int main(void) {
    myName();

    int A[MAX]; //일차원 정수 배열 A를 크기 100으로 선언
    int a=0; //원소 개수 입력받을 정수 선언
    int n=-1; //operation 입력받을 정수 선언
    elementGeneration(A, &a);
    while(1){ //무한루프
        printf("\n\nChoose operation:\n1.insertion  2.deletion  3.output  0:program end\n");
        scanf("%d",&n);
        //입력받은 operation에 따라 다른 함수 호출
        if (n==1) elementInsertion(A, &a);
        else if (n==2) elementDeletion(A, &a);
        else if (n==3) elementPrint(A, &a);
        else if (n==0) break;
        else printf("Wrong Input"); //1,2,3,0 이외의 숫자를 입력했을 때
    }
    return 0;
}

void elementGeneration(int* arr, int* a){ //array 정보 입력
    printf("How many numbers? ");
    scanf("%d", a); //배열 크기 입력 받음
    printf("Input %d numbers\n", *a);
    for(int i=0;i<*a;i++){ //배열 크기 만큼 원소 입력 받음
        scanf("%d",arr+i);
    }
    elementPrint(arr, a); //array 출력 함수 호출
}

void elementInsertion(int* arr, int* a){ //새로운 element 정보 입력
    int loc=0, val=0;
    printf("Input location and value to insert\n");
    scanf("%d", &loc); scanf("%d", &val); //새로운 element를 삽입할 위치와 값 입력받음
    if (loc<1 || (*a+1)<loc){ //삽입할 수 있는 범위를 벗어나면
        printf("Choose between 1 and %d",*a+1);
    }
    else{
        for (int i = *a-1 ; i >= loc-1 ; i--){ //배열 뒤에서부터 삽입할 위치까지 인덱스 한 자리씩 뒤로 이동
            arr[i+1]=arr[i];
        }
        arr[loc-1]=val; //삽입할 위치에 값을 대입
        (*a) += 1; //배열 크기 1 증가
        elementPrint(arr, a); //array 출력 함수 호출
    }
}

void elementDeletion(int* arr, int* a){ //element 삭제
    int loc=0;
    printf("Input location to delete\n");
    scanf("%d", &loc); //element를 삭제할 위치 입력받음
    if (loc<1 || (*a+1)<loc){ //위치에 element가 없으면
        printf("No element in location %d",loc);
    }
    else{
        for (int i=loc-1;i<=*a-1;i++){ //삭제할 위치부터 배열 끝까지 뒤 인덱스의 원소를 끌어다가 대입함
            arr[i]=arr[i+1];
        }
        (*a) -= 1; //배열 크기 1 감소
        elementPrint(arr, a); //array 출력 함수 호출
    }
}

void elementPrint(int* arr, int *a){ //array 출력
    printf("Array: ");
    for(int i=0;i<*a;i++){ //배열 길이만큼 반복문 돌림
        printf("%3d",*(arr+i));
    }
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
