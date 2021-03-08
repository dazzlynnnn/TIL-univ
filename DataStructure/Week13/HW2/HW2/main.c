#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>
#define BUCKETS 10
#define MAX_QUEUE_SIZE 10
#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t)) //switch 위한 매크로

typedef int element;
typedef struct {
    int front;
    int rear;
    element data[MAX_QUEUE_SIZE];
}QueueType;

void init_queue(QueueType* q){ //큐 초기화
    q->front=-1;
    q->rear=-1;
}

bool is_full(QueueType* q){
    return (q->rear == MAX_QUEUE_SIZE - 1); //rear값이 MAX_QUEUE_SIZE 보다 1 작으면 full
}

bool is_empty(QueueType* q){
    return (q->front == q->rear); //front와 rear가 같으면 empty
}

void enqueue(QueueType* q, element item){
    if (is_full(q)){
        printf("queue is full\n"); //큐가 포화 상태이면
        return;
    }
    else q->data[++q->rear] = item; //rear를 증가시키고 값 대입
}

element dequeue(QueueType* q){
    if (is_empty(q)){ //큐가 비어 있으면
        printf("queue is empty");
        return -1;
    }
    else return q->data[++(q->front)]; //front를 증가시키고 증가된 front가 가리키는 값 반환
}

void print_queue(QueueType* q){
    for (int i=0; i<MAX_QUEUE_SIZE; i++){
        if (i > q->front && i <= q->rear) printf("%5d |", q->data[i]);
    }
    printf("\n");
}

void print_bucket(QueueType* q){
    printf("\n");
    for (int i=0; i<BUCKETS; i++){ //bucket 상태 출력
        printf("[%d]",i);
        print_queue(&q[i]);
    }
}
void radix_sort(int list[], int n){
    int i, b, d, factor = 1;
    QueueType queues[BUCKETS]; //bucket 수만큼의 queue가 추가로 필요
    for (b=0; b<BUCKETS; b++) init_queue(&queues[b]); //큐들의 초기화(index 0~9까지)
    for (d=0; d<n; d++) { //자리수가 낮은 것부터 높은 순으로
        for (i=0; i<10; i++) //데이터들을 자리수에 따라 큐에 입력
            enqueue(&queues[(list[i] / factor) % 10], list[i]); //모든 리스트 요소를 해당 queue에 insert
        print_bucket(queues);
        for (b=i=0; b<BUCKETS; b++){ //bucket에서 꺼내어 list에 순서대로 insert
            while (!is_empty(&queues[b]))
                list[i++] = dequeue(&queues[b]);
        }
        factor *= 10; //그 다음 높은 자리수로 이동
    }
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}


int main(void) {
    myName();
    int list[10];
    int i, n=0;
    srand((unsigned int)time(NULL));

    printf("자리수입력(1~4):");
    scanf("%d", &n);
    for (i=0; i<10; i++){ //난수 10개 생성
        list[i] = rand() % (int)(pow(10,n));
    }
    
    printf("\n<Before sorting>\n");
    for (i=0; i<10; i++){
        printf("%d ",list[i]);
    }
    printf("\n");
    
    radix_sort(list,n); //자리수를 인자로 넣음
    
    printf("\n<After Radix Sorting>\n");
    for (i=0; i<10; i++){
        printf("%d ",list[i]);
    }
    printf("\n");
    
    return 0;
}
