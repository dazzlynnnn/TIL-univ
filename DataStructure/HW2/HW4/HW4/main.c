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

int partition(int list[], int left, int right){
    int pivot = list[left];
    printf("\n* pivot: %d",pivot); //pivot값 출력
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

    return high; //pivot 위치 반환
}

void quick_sort(int list[], int left, int right){
    if(left<right){
        int p = partition(list, left, right); //partition 호출해서 pivot 찾기
        quick_sort(list, left, p-1); //pivot 중심으로 pivot 바로 앞까지 재귀호출
        quick_sort(list, p+1, right); //pivot 중심으로 pivot 다음부터 끝까지 재귀호출
    }
}

int median_of_three(int list[], int left, int right){ //리스트의 첫번째 수, 마지막 수, 중간에 위치한 수 중 median 값을 구하는 함수
    int a = list[left], b = list[(left+right)/2], c = list[right];
    if (a<=b){
        if (b<=c) return (left+right)/2;
        else if (a<=c) return right;
        else return left;
    }
    else{
        if (a<=c) return left;
        else if (b<=c) return right;
        else return (left+right)/2;
    }
}

int median_partition(int list[], int left, int right){
    int pivot = list[median_of_three(list,left,right)];
    printf("\n* pivot: %d",pivot); //pivot값 출력
    int temp, low, high;
    low = left-1;
    high = right+1;
    do{
        do
            low++;
        while (list[low] < pivot); //left 요소부터 증가하면서 pivot 값 이상인 요소 찾기
        do
            high--;
        while (list[high] > pivot); //right 부터 줄여가면서 pivot 값 이하인 요소 찾기
        if (low<high) SWAP(list[low], list[high], temp); //두 요소 switch
    }while (low<high); //low, high가 교차할 때까지 반복
    SWAP(list[median_of_three(list,left,right)], list[high], temp); //pivot을 중앙에 위치시킴
    return high; //pivot 위치 반환
}

void median_quick_sort(int list[], int left, int right){
    if(left<right){
        int p = median_partition(list, left, right); //median_partition 호출해서 pivot 찾기
        median_quick_sort(list, left, p-1); //pivot 중심으로 pivot 바로 앞까지 재귀호출
        median_quick_sort(list, p+1, right); //pivot 중심으로 pivot 다음부터 끝까지 재귀호출
    }
}

int main(void) {
    myName();

    int list[50];
    int n=0;
    printf("Input size of list<1~50>:");
    scanf("%d",&n);
    printf("Input %d numbers in the list\n", n); //list값 입력받기
    for (int i=0; i<n; i++){
        scanf("%d",&list[i]);
    }
    printf("\n<<정렬 이전 상태>>\n");
    for (int i=0; i<n; i++){
        printf("%5d",list[i]);
    }
    printf("\n\n<Quick Sorting>");
    quick_sort(list, 0, n-1);

    printf("\n<Result>\n");
    for (int i=0; i<n; i++){
        printf("%5d",list[i]);
    }
    printf("\n");
    
    printf("\n\n<Quick Sorting<Median of three>>");
    median_quick_sort(list, 0, n-1);

    printf("\n<Result>\n");
    for (int i=0; i<n; i++){
        printf("%5d",list[i]);
    }
    printf("\n");
    
    return 0;
}
