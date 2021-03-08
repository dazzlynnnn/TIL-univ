#include <stdio.h>
#include <stdlib.h>
#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t)) //switch 위한 매크로


void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

int partition(int list[], int left, int right, int n){
    int pivot = list[left];
    printf("\n* pivot: %d\n",pivot); //pivot값 출력
    int temp, low, high;
    low = left;
    high = right+1;
    do{
        do
            low++;
        while (list[low] < pivot); //left 다음 요소부터 증가하면서 pivot 값 이상인 요소 찾기
        do
            high--;
        while (list[high] > pivot); //right 부터 줄여가면서 pivot 값 이하인 요소 찾기
        if (low<high) SWAP(list[low], list[high], temp); //두 요소 switch
    }while (low<high); //low, high가 교차할 때까지 반복
    SWAP(list[left], list[high], temp); //pivot을 중앙에 위치시킴
    for (int i=0; i<n; i++){
        printf("%d ",list[i]);
    }
    printf("\nleft size: %d   right size: %d", abs(high-left), abs(right-high));
    return high; //pivot 위치 반환
}

void quick_sort(int list[], int left, int right, int n){
    if(left<right){
        int p = partition(list, left, right, n); //partition 호출해서 pivot 찾기
        quick_sort(list, left, p-1, n); //pivot 중심으로 pivot 바로 앞까지 재귀호출
        quick_sort(list, p+1, right, n); //pivot 중심으로 pivot 다음부터 끝까지 재귀호출
    }
}

int main(void) {
    myName();

    int list[10];
    int n=0;
    printf("Input size of list<1~10>:");
    scanf("%d",&n);
    printf("Input %d numbers in the list\n", n); //list값 입력받기
    for (int i=0; i<n; i++){
        scanf("%d",&list[i]);
    }
    printf("\n<Before sorting>\n");
    for (int i=0; i<n; i++){
        printf("%d ",list[i]);
    }
    quick_sort(list, 0, n-1, n);
    printf("\n\n<After Quick Sorting>\n");
    for (int i=0; i<n; i++){
        printf("%d ",list[i]);
    }
    printf("\n");
    
    return 0;
}
