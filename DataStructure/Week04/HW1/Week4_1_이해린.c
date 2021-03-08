#include <stdio.h>
#include <stdlib.h>

//typedef
typedef int element;
typedef struct ListNode { //정수를 입력할 떄마다 생성되는 노드
    element data; //입력한 정수 데이터
    struct ListNode* link; //다음 노드 주소
} ListNode;
typedef struct ListType { //연결 리스트 헤더 노드
    int size; //노드 개수
    ListNode* head; //연결 리스트 처음 노드 주소
    ListNode* tail; //연결 리스트 마지막 노드 주소
} ListType;

//필요한 함수 선언
void myName(void);
void error(const char* message);
ListType* create(void);
void insert(ListType* list, element val);
void print_list(ListType* list);
int max_list(ListType* list);
int min_list(ListType* list);

//메인 함수
int main(void) {
    myName();
    int input = 0; //정수 입력받을 변수 선언 및 초기화
    ListType* list = create(); //
    
    while(1){
        printf("Input an integer to add<0 to quit>: ");
        scanf("%d",&input);
        if (input==0) break; //사용자가 0을 입력하면 노드 추가 종료
        insert(list, input);
    }
    printf("\n<List>\n");
    print_list(list);
    printf("\nMax: %d  Min: %d\n",max_list(list), min_list(list));
    free(list);
    return 0;
}

ListType* create(void){ //연결 리스트 정보를 저장하는 헤더 노드 생성하는 함수
    ListType* list = (ListType*)malloc(sizeof(ListType)); //헤더 노드 생성 후 메모리 동적 할당
    if (list == NULL) error("memory allocation error\n"); //메모리 할당 실패
    list->size = 0;
    list->head = NULL;
    list->tail = NULL;
    return list; //메모리 할당, 멤버 초기화된 노드 리턴
}

void insert(ListType* list, element val){ //리스트 마지막에 insert하는 함수
    ListNode* node = (ListNode*)malloc(sizeof(ListNode)); //추가할 노드 생성 후 메모리 동적 할당
    if (node == NULL) error("memory allocation error\n"); //메모리 할당 실패
    node->data = val; //사용자가 입력한 값을 노드의 data에 대입
    node->link = NULL; //마지막에 추가하는 노드이므로 링크는 NULL
    if (list->head == NULL) //list가 비어 있으면 새로운 노드 node가 유일한 노드가 됨
        list->head = list->tail = node; //list의 head도, tail도 node를 가리키게 함
    else { //list에 기존 노드가 있으면
        list->tail->link = node; //list의 맨 마지막 노드가 새 노드 node를 가리키게 함
        list->tail = node; //list의 맨 마지막 노드를 node로 설정
    }
    list->size++; //list의 노드 개수 하나 추가
}

void print_list(ListType* list){ //리스트 출력 함수
    ListNode* node = list->head; //node가 리스트의 첫 노드를 가리키게 함
    for (int i=0; i<list->size; i++){ //노드 개수만큼 반복
        printf("%d  ", node->data);
        node = node->link; //node가 다음 노드를 가리키게 함
    }
}

int max_list(ListType* list){ //최댓값 찾는 함수
    ListNode* node = list->head; //node가 리스트의 첫 노드를 가리키게 함
    int result = node->data; //결과 저장할 정수 변수 첫 노드의 data값으로 초기화
    for (int i=0; i<list->size; i++){ //노드 개수만큼 반복
        if (node->data > result) result = node->data; //현재 최댓값보다 큰 값이면 최댓값 바꿈
        node = node->link; //node가 다음 노드를 가리키게 함
    }
    return result;
}

int min_list(ListType* list){ //최솟값 찾는 함수
    ListNode* node = list->head; //node가 리스트의 첫 노드를 가리키게 함
    int result = node->data; //결과 저장할 정수 변수 첫 노드의 data값으로 초기화
    for (int i=0; i<list->size; i++){ //노드 개수만큼 반복
        if (node->data < result) result = node->data; //현재 최솟값보다 작은 값이면 최솟값 바꿈
        node = node->link; //node가 다음 노드를 가리키게 함
    }
    return result;
}

void error(const char* message){ //error 처리 함수
    fprintf(stderr,"%s\n",message); //error message 출력
    exit(1); //프로그램 종료
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}
