#include <stdio.h>
#define ROWS 4
#define COLS 3
//row, column 수 지정

void myName(void);
void matrixInput(int x[ROWS][COLS]);
void matrixPrint(int x[ROWS][COLS]);
void matrixAdd(int x[ROWS][COLS], int y[ROWS][COLS], int z[ROWS][COLS]);

int main(void) {
    myName();

    int A[ROWS][COLS], B[ROWS][COLS], C[ROWS][COLS];
    printf("Input values for %dX%d matrix A\n",ROWS, COLS);
    matrixInput(A);
    printf("Input values for %dX%d matrix B\n",ROWS, COLS);
    matrixInput(B);
    puts("<A>");
    matrixPrint(A);
    puts("<B>");
    matrixPrint(B);
    puts("<A+B>");
    matrixAdd(A,B,C);
    matrixPrint(C);
    
    return 0;
}

void matrixInput(int x[ROWS][COLS]){ //인자로 받은 배열에 행렬 원소 입력받는 함수
    for(int i=0;i<ROWS;i++){ //row 별 반복
        for(int j=0;j<COLS;j++){ //coulumn 별 반복
            scanf("%d",&x[i][j]);
        }
    }
}

void matrixPrint(int x[ROWS][COLS]){ //인자로 받은 배열을 행렬 형태로 출력하는 함수
    for(int i=0;i<ROWS;i++){ //row 별 반복
        for(int j=0;j<COLS;j++){ //coulumn 별 반복
            printf("%3d",x[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

void matrixAdd(int x[ROWS][COLS], int y[ROWS][COLS], int z[ROWS][COLS]){
    //인자로 받은 x, y 배열의 인덱스가 같은 원소끼리 더해서 배열 z에 대입하는 함수
    for(int i=0;i<ROWS;i++){//row 별 반복
        for(int j=0;j<COLS;j++){//coulumn 별 반복
            z[i][j]=x[i][j]+y[i][j]; //덧셈연산 후 대입
        }
    }
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

