#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "quick_sort.h"
#define SIZE 100

typedef struct{
    int key;
    int index;
}itable;

int list[SIZE];
itable index_list[SIZE];

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

int seq_search(int key, int low, int high){
    for (int i = low; i<=high; i++){
        if (list[i]==key)
            return i;
    }
    return -1; //탐색 실패
}

int index_search(int key, int index_size){
    int i, low, high;
    if (key<list[0] || key>list[SIZE-1]) return -1; //범위 밖인 경우 종료
    for (i = 0; i<index_size; i++){
        if (index_list[i].key <= key && index_list[i+1].key >key) break; //해당 키가 포함된 위치 찾기
    }
    if (i==index_size) //index 위치 출력
        printf("index location: %d\n",i-1);
    else
        printf("index location: %d\n",i);
    if (i == index_size) { //마지막까지 i가 증가된 경우 마지막 index 구간에 key 포함된 경우
        low = index_list[i-1].index;
        high = SIZE;
    }
    else { //특정 index i ~ i+1 사이에 key 포함된 경우
        low = index_list[i].index;
        high = index_list[i+1].index;
    }
    return seq_search(key, low, high);
}

int main(void) {
    myName();
    srand((unsigned)time(NULL));
    int interval=0, key=0;
    for (int i=0; i<SIZE; i++) //난수를 size만큼 생성해서 list 만들기
        list[i] = rand()%1000; //난수의 범위 : 0~999
    for (int i=0; i<SIZE; i++){
        if(i%10==0) putchar('\n');
        printf("%4d",list[i]);
    }
    
    printf("\n\n<정렬결과>\n");
    quick_sort(list, 0, SIZE); //quick 정렬 호출
    for (int i=0; i<SIZE; i++){
        if(i%10==0) putchar('\n');
        printf("%4d",list[i]);
    }
    
    printf("\n\nInput index interval(1~100): ");
    scanf("%d",&interval);
    int index_size = SIZE/interval; //interval에 따라 index_size 결정
    if (index_size * interval < SIZE) ++index_size;
    for (int i=0; i<index_size; i++){ //index_list에 index, key값 입력
        index_list[i].index = i*interval;
        index_list[i].key = list[i*interval];
    }
    
    printf("\n\n<Index table>\n"); //index_list 출력
    for (int i=0; i<index_size; i++){
        printf("%3d: %3d\n",i,index_list[i].key);
    }
    
    printf("\n\nInput key to search: ");
    scanf("%d",&key); //탐색할 키값 입력받음
    printf("\n<indexed_search 결과>\n");
    int pos = index_search(key, index_size);
    if (pos != -1) //탐색에 성공했을 때
        printf("%d is found in position %d\n", key, pos);
    else printf("search failed\n"); //탐색에 실패했을 때
    return 0;
}
