#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typedef struct {
    int front;
    int rear;
    element data[MAX_QUEUE_SIZE];
} QueueType;

void init_queue(QueueType* q){ //큐 초기화
    q->front=0;
    q->rear=0;
}

bool is_full(QueueType* q){
    return ((q->rear+1) % MAX_QUEUE_SIZE == q->front); //rear를 증가시킨 값이 front와 같으면 full
}

bool is_empty(QueueType* q){
    return (q->front == q->rear); //front와 rear가 같으면 empty
}

void enqueue(QueueType* q, element item){
    if (is_full(q)) printf("queue is full\n"); //큐가 포화 상태이면
    else{
        q->rear = (q->rear+1)%MAX_QUEUE_SIZE; //rear를 증가시킴
        q->data[q->rear] = item; //증가된 rear 위치에 값 대입
    }
}

element dequeue(QueueType* q){
    if (is_empty(q)){ //큐가 비어 있으면
        printf("queue is empty");
        return 0;
    }
    else{
        q->front = (q->front+1)%MAX_QUEUE_SIZE;
        return q->data[q->front];
    }
}

void print_queue(QueueType* q){
    if(!is_empty(q)){ //큐에 데이터가 있으면
        printf("Queue<front:%d, rear: %d> = ", q->front, q->rear); //front와 rear 위치 출력
        int i = q->front; //i는 현재의 front부터 시작
        do{
            i=(i+1)%MAX_QUEUE_SIZE; //front+1부터 출력 (front는 비어있음)
            printf("%3d |", q->data[i]);
            if (i == q->rear) break; //증가시킨 위치가 rear와 동일하면 다 출력한 것이므로 종료
        } while (i != q->front); //최대 한바퀴 돌아서 front 위치까지 다시 돌아오면 종료
    }
    else printf("queue is empty");
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
    QueueType q;
    init_queue(&q);
    int i = 0, element = 0;
    char c = '\0';
    while(i==0){
        printf("\n원하는 작업<E/e:enqueue, D/d:dequeue, P/p:output, 0:quit>: ");
        scanf("%c",&c);
        getchar();
        
        switch(c){
            case 'e': case 'E':
                printf("정수입력: ");
                scanf("%d",&element);
                enqueue(&q, element);
                getchar();
                break;
            case 'd': case 'D':
                printf("%3d\n",dequeue(&q));
                break;
            case 'p': case 'P':
                print_queue(&q);
                break;
            case '0': i++; break;
            default: printf("Wrong input\n"); break;
        }
    }
    printf("현재 원소 갯수는: %d\n",(q.rear-q.front+MAX_QUEUE_SIZE)%MAX_QUEUE_SIZE);
    print_queue(&q);
    return 0;
}
