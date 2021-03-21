//
//  main.c
//  queueNode
//
//  Created by 이해린 on 2021/03/19.
//

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct QueueNode{
    int data;
    struct QueueNode* link;
}QueueNode;

typedef struct{
    QueueNode* front;
    QueueNode* rear;
}LinkedQueue;

bool is_empty(LinkedQueue* queue){
    return queue->front==NULL;
}

void init(LinkedQueue* queue){
    queue->front = queue->rear = NULL;
}

void enqueue(LinkedQueue* queue, int data){
    QueueNode* temp = (QueueNode*)malloc(sizeof(QueueNode));
    temp->data = data;
    temp->link = NULL;
    if (is_empty(queue)){
        queue->front = temp;
        queue->rear = temp;
    }
    else{
        queue->rear->link = temp;
        queue->rear = temp;
    }
}

int dequeue(LinkedQueue* queue){
    QueueNode* temp = queue->front;
    int data;
    if (is_empty(queue)){
        fprintf(stderr, "Queue is empty\n");
        exit(1);
    }
    else {
        data = temp->data;
        queue->front = temp->link;
        if (queue->front ==NULL)
            queue->rear = NULL;
        free(temp);
        return data;
    }
}

void print_queue(LinkedQueue* queue){
    QueueNode* p;
    for (p=queue->front; p!=NULL; p=p->link)
        printf("|%d| -> ", p->data);
    printf("|NULL|\n");
}

int main(int argc, const char * argv[]) {
    LinkedQueue queue;
    init(&queue);
    
    enqueue(&queue, 10); print_queue(&queue);
    enqueue(&queue, 20); print_queue(&queue);
    enqueue(&queue, 30); print_queue(&queue);
    getchar();
    dequeue(&queue); print_queue(&queue);
    dequeue(&queue); print_queue(&queue);
    dequeue(&queue); print_queue(&queue);

    return 0;
}
