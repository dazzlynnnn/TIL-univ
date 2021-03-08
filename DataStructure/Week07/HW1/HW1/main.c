#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef int element;
typedef struct QueueNode{
    element data;
    struct QueueNode* link;
} QueueNode;

typedef struct {
    QueueNode* front, * rear; //front 노드와 rear 노드 저장
}LinkedQueueType;

void error(const char* message){
    fprintf(stderr,"%s\n", message);
    exit(1);
}

void init_queue(LinkedQueueType* q){ //큐 초기화 (F(0)와 F(1)의 값을 미리 넣어 놓음)
    QueueNode* f_0 = (QueueNode*)malloc(sizeof(QueueNode)); //새 노드 동적할당
    QueueNode* f_1 = (QueueNode*)malloc(sizeof(QueueNode)); //새 노드 동적할당
    f_0->data = 0;
    f_1->data = 1;
    f_0->link = f_1;
    f_1->link = NULL;
    q->front = f_0;
    q->rear = f_1;
}

bool is_empty(LinkedQueueType* q){
    return (q->front == NULL); //front가 NULL이면 empty
}

void enqueue(LinkedQueueType* q, element item){
    QueueNode* temp = (QueueNode*)malloc(sizeof(QueueNode)); //새 노드 동적할당
    temp->data = item; //데이터 저장
    temp->link = NULL; //링크는 NULL
    if (is_empty(q)){ //큐가 empty면 새로 추가된 node가 front이자 rear
        q->front = temp;
        q->rear = temp;
    }
    else{ //큐가 empty가 아닌 경우
        q->rear->link = temp; //기존의 rear가 새로 추가된 노드 temp를 가리키게 함
        q->rear = temp; //새로 추가된 노드 temp가 rear가 됨
    }
}

element dequeue(LinkedQueueType* q){
    if (is_empty(q)) error("queue is empty");
    element data;
    QueueNode* temp = q->front; //기존의 front가 가리키던 노드 위치를 저장해놓고
    data = temp->data; //기존의 front가 가리키던 노드의 값을 리턴하기 위헤 data 변수에 저장
    q->front = q->front->link; //기존의 front가 가리키던 노드가 새로운 front가 됨
    if (q->front == NULL) q->rear = NULL; //노드가 한 개 있던 경우라면 queue를 공백으로 만들어줌
    free(temp); //기존 front 노드 메모리 반환
    return data; //dequeue 된 data값 리턴
}

element peek(LinkedQueueType* q){
    if (is_empty(q)) error("queue is empty");
    return q->front->data; //peek한 data값 리턴
}

void print_fib(LinkedQueueType* q, int fib){
    init_queue(q);
    for (int i=0; i<=fib; i++){
        printf("%5d",peek(q));
        enqueue(q, dequeue(q)+peek(q)); //맨 앞 값을 dequeue한 값과 그 이후헤 peek한 값을 더해서 rear에 enqueue
    }
    printf("\n");
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
    int fib = 0;
    LinkedQueueType q;
    printf("Input a fibonicci location : ");
    scanf("%d", &fib);
    print_fib(&q, fib);
    return 0;
}
