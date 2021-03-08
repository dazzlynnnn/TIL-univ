#include <stdio.h>
#include <stdlib.h>

#define TABLE_SIZE 11

typedef struct{
    int key;
} element;

struct list{
    element item;
    struct list* link;
};

struct list* hash_table[TABLE_SIZE];

int hash_function(int key){ //module 연산 사용한 hash function
    return key % TABLE_SIZE;
}

void hash_chain_add(element item, struct list* ht[]){ //key를 hash table에 insert
    int hash_value = hash_function(item.key);
    struct list *ptr;
    struct list *node_before = NULL, *node = ht[hash_value];
    for (; node; node_before=node, node=node->link){ //해당 위치의 노드 검색
        if (node->item.key == item.key){ //같은 값이 들어 있으면
            fprintf(stderr, "%d is already stored\n", item.key);
            return;
        }
    }
    ptr = (struct list*)malloc(sizeof(struct list)); //해당 key 값이 저장되어있지 않으면
    ptr->item = item; //새로운 노드에 key와 링크 설정
    ptr->link = NULL;
    if (node_before)
        node_before->link = ptr; //마지막 위치에 추가
    else
        ht[hash_value] = ptr; //해당 위치에 노드가 없으므로 첫 노드로 연결
}

void hash_chain_delete(element item, struct list* ht[]){ //key를 hash table에서 delete
    int hash_value = hash_function(item.key);
    struct list *ptr = NULL;
    struct list *node_before = NULL, *node = ht[hash_value];
    for (; node; node_before=node, node=node->link){ //해당 위치의 노드 검색
        if (node->item.key == item.key){ //같은 값이 들어 있으면
            ptr = node; //임시 노드에 삭제할 노드 대입
            if (node_before){
                node_before->link = node->link; //node_before의 link를 삭제할 노드 다음 노드로 연결
                free(ptr); break; //memory 반환
            }
            else{ //찾은 값이 리스트의 첫번째 노드인 경우 (node_before == NULL)
                ht[hash_value] = node->link; //리스트의 첫번째 노드 수정
                free(ptr); break; //memory 반환
            }
        }
    }
    fprintf(stderr, "%d is not stored\n", item.key); //삭제할 값이 검색되지 않을 경우
}

void hash_chain_search(element item, struct list* ht[]){
    struct list* node;
    int hash_value = hash_function(item.key);
    for (node=ht[hash_value]; node; node=node->link){ //해당 위치의 노드 검색
        if (node->item.key == item.key){ //같은 값이 들어있으면
            fprintf(stderr,"%d is found at index %d\n", item.key, hash_value); //검색 성공
            return;
        }
    }
    fprintf(stderr, "%d is not in the table\n", item.key);
}

void hash_chain_print(struct list* ht[]){
    struct list* node;
    int i;
    printf("\n============================\n");
    for (i=0; i<TABLE_SIZE; i++){
        printf(" [%d] ",i);
        for(node=ht[i]; node; node=node->link)
            printf(" -%3d", node->item.key);
        printf("\n");
    }
    printf("\n============================\n");
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
    
    int i=0, k=0;
    element e;
    
    printf("Input 10 keys to add\n");
    for (int j=0; j<10; j++){
        scanf("%d", &e.key);
        hash_chain_add(e, hash_table);
    }
    hash_chain_print(hash_table);
    
    while(k==0){
        printf("\n* Choose operation (1.insert 2.delete 3.search 4.print 5.exit) : ");
        scanf("%d",&i);
        switch (i) {
            case 1:
                printf("Input data to add:");
                scanf("%d",&e.key);
                hash_chain_add(e,hash_table);
                break;
            case 2:
                printf("Input data to delete:");
                scanf("%d",&e.key);
                hash_chain_delete(e,hash_table);
                break;
            case 3:
                printf("Input data to search:");
                scanf("%d",&e.key);
                hash_chain_search(e,hash_table);
                break;
            case 4:
                hash_chain_print(hash_table);
                break;
            case 5:
                printf("\nProgram finished\n");
                k=-1;break;
            default:
                printf("Wrong input\n");break;
        }
    }
    return 0;
}
