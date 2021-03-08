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

void init_queue(LinkedQueueType* q){ //큐 초기화
    q->front = NULL;
    q->rear = NULL;
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

void print_card(LinkedQueueType* q){ //카드 출력하는 함수
    for (QueueNode* p=q->front; p!=NULL; p=p->link){
        printf("%3d |",p->data);
    }
    printf("\n");
}

int num_card(LinkedQueueType* q){ //연결리스트 시작주소를 받아 노드의 개수를 반환하는 함수
    int num=0;
    for (QueueNode* p=q->front; p!=NULL; p=p->link){
        num++;
    }
    return num;
}

void card(LinkedQueueType* q, int N){ //규칙에 의해 마지막으로 남는 카드의 번호를 찾는 함수
    for (int i=0; i<N; i++){ //1부터 N까지의 카드를 큐에 넣음
        enqueue(q, i+1);
    }
    if (is_empty(q)) error("queue empty"); //입력이 0이면 큐가 empty
    else{
        print_card(q); //처음 카드 상태 출력
        while(1){
            dequeue(q); //제일 위에 있는 카드를 버림
            print_card(q); //카드 상태 출력
            if (num_card(q)==1) break; //카드가 하나 남으면 반복문 종료
            enqueue(q,peek(q)); //peek한 맨 위 카드를 맨 아래에 추가
            dequeue(q); //아래에 똑같이 추가된 원래 카드 버림
            print_card(q); //카드 상태 출력
        }
        printf("Final element is %d\n", q->front->data); //마지막으로 남은 카드 출력
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
    int N = 0;
    LinkedQueueType q;
    printf("Input number of cards : ");
    scanf("%d", &N);
    card(&q,N);
    return 0;
}

