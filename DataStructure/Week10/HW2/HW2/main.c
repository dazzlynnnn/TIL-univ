#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_ELEMENT 200

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

typedef struct{
    int key;
}element;

typedef struct{
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;

HeapType* create(){
    return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h){
    h->heap_size = 0;
}

bool same_value(HeapType* h, element item){
    for (int k=1; k<=h->heap_size; k++){
        if (h->heap[k].key==item.key) return true; //같은 값을 찾으면 true 반환
    }
    return false; //같은 값이 없으면 false 반환
}

void insert_max_heap(HeapType* h, element item){ //item 노드를 max heap에 추가하는 과정
    if (same_value(h, item)) printf("same value exists\n");
    else{
        int i;
        i = ++(h->heap_size); //노드 추가 후 증가된 말단노드 인덱스를 i에 대입
        while((i != 1) && (item.key > h->heap[i/2].key)){ //트리를 거슬러 올라가면서 부모 노드 key값과 비교
            h->heap[i] = h->heap[i/2]; //추가된 노드 key값보다 작은 경우 부모 노드를 내림
            i/=2; //인덱스를 새로운 위치(부모)로 이동
        }
        h->heap[i] = item; //최종 결정된 위치에 새로운 노드를 insert
    }
}

int find_index(HeapType* h, element item){
    for (int k=1; k<=h->heap_size; k++){
        if (h->heap[k].key==item.key) return k; //같은 값을 찾으면 index 반환
    }
    return 0; //찾지 못하면 0 반환
}

void delete_item(HeapType* h, element item){
    if(!same_value(h,item)) printf("value is not in heap\n");
    else{
        int index = find_index(h, item);
        int parent = index, child = index+1; //삭제할 노드 다음 노드부터 삭제할 노드와 비교 시작
        element temp = h->heap[h->heap_size--]; //삭제할 노드를 temp에 대입하고 heap_size값 감소
        while (child <= h->heap_size){ //최대 말단까지 트리를 내려가면서 자식노드 key값과 temp key값 비교
            if ((child < h->heap_size) && (h->heap[child].key < h->heap[child+1].key))
                //sibling이 있을 때 둘 중 큰 값 찾기
                child++; //sibling이 비교대상 노드가 됨 (subtree 선택)
            if (temp.key >= h->heap[child].key) break; //자식노드보다 신규노드 key가 크면 위치 확정되어 반복 종료
            h->heap[parent] = h->heap[child]; //자식노드 key가 더 크면 parent 노드에 child 노드 복사
            parent = child; //parent 인덱스를 child 인덱스로 변경
            child *= 2; //child 인덱스는 그 아래 child로 변경
        }
        h->heap[parent] = temp; //확정위치(parent)에 신규노드 insert
    }
}

int main(void) {
    myName();
    
    char a = '\0';
    int i = 0;
    
    element item;
    HeapType *heap = create();
    init(heap);

    while(1){
        printf("* Input Operation I(Insert) D(Delete) X(Exit) : ");
        scanf(" %c", &a);
        switch(a){
            case 'i': case 'I':
                printf("Input value to insert : ");
                scanf("%d",&i);
                item.key = i;
                insert_max_heap(heap, item);
                break;
            case 'd': case 'D':
                printf("Input value to delete : ");
                scanf("%d",&i);
                item.key = i;
                delete_item(heap, item);
                break;
            case 'p': case 'P':
                for (int k=1; k<=heap->heap_size; k++)
                    printf("%d ",heap->heap[k].key);
                printf("\n");
                break;
            case 'x': case 'X':
                exit(0);
            default:
                printf("Wrong Input\n");
                break;
        }
    }
    return 0;
}
