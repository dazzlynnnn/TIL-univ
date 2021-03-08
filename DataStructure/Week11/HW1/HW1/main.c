#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_VERTICES 50
#define MAX_STACK_SIZE 50

typedef struct GraphType { //그래프 구조체 정의
    int n; //vertex의 수
    int adj_mat[MAX_VERTICES][MAX_VERTICES];
} GraphType;

typedef struct StackType { //스택 구조체 정의
    int data[MAX_STACK_SIZE];
    int top;
} StackType;

void init_stack(StackType* s){s->top = -1;} //스택 초기화 함수
bool is_full(StackType* s){return (s->top == (MAX_STACK_SIZE - 1));} //top이 최대면 true 반환
bool is_empty(StackType* s){return (s->top ==-1);}//top이 -1이면(빈 스택) true 반환
int pop(StackType* s){
    if (is_empty(s)){
        fprintf(stderr, "Stack empty");
        exit(1);
    }
    else return s->data[(s->top)--]; //top이 가리키는 원소값 반환 후 top 위치 조정(top--)
}
void push(StackType* s, int item){
    if (is_full(s)) {
        fprintf(stderr, "Overflow");
        exit(1);
    }
    else s->data[++(s->top)] = item; //top을 1 증가 후 해당 위치에 원소값 저장
}

void init_graph(GraphType* g){ //그래프 초기화 함수
    int r, c;
    g->n = 0;
    for (r=0; r<MAX_VERTICES; r++){
        for(c=0; c<MAX_VERTICES; c++){
            g->adj_mat[r][c] = 0; //모든 원소 0으로 초기화
        }
    }
}
void insert_vertex(GraphType* g, int v){ //vertex insertion 연산
    if (g->n + 1 > MAX_VERTICES){
        fprintf(stderr, "그래프: 정점의 개수 초과\n");
        return;
    }
    else g->n++; //vertex 개수 증가
}
void insert_edge(GraphType* g, int start, int end){ //edge insertion 연산
    if (start >= g->n || end>= g->n){
        fprintf(stderr, "그래프: 정점 번호 오류\n");
        return;
    }
    g->adj_mat[start][end] = 1;
}
void init_visited(int* v){ //전역변수 visited 초기화 함수
    for (int i=0; i<MAX_VERTICES; i++)
        v[i] = false;
}

void print_adj_mat(GraphType* g){ //출력 함수
    printf("<Graph Matrix>\n");
    int r,c;
    for (r=0; r<g->n; r++){
        for (c=0; c<g->n; c++)
            printf("%2d", g->adj_mat[r][c]);
        printf("\n");
    }
}

int visited[MAX_VERTICES];
void dfs_recursive(GraphType* g, int v){ //재귀 이용 DFS
    int w;
    visited[v] = true; //dfs 시작된 vertex는 방문한 것으로 표시
    printf("vertex%d  ",v); //방문한 vertex 출력
    for (w=0; w<g->n; w++){ //해당 vertex의 row값을 하나씩 검사해서
        if (g->adj_mat[v][w] && !visited[w]) //특정 vertex값이 1인데 아직 방문 안 했으면
            dfs_recursive(g, w);
    }
}
void dfs_stack(GraphType* g, int v){ //스택 이용 DFS
    StackType* s = (StackType*)malloc(sizeof(StackType)); //스택 생성
    init_stack(s);
    push(s, v); //초기 입력값 push
    while (!is_empty(s)){ //스택이 비면 종료
        v = pop(s);
        if (!visited[v]){ //v가 방문되지 않았으면
            visited[v] = true; //v를 방문되었다고 표시
            printf("vertex%d  ",v); //방문한 vertex 출력
            for (int u=0; u<g->n; u++){
                if (g->adj_mat[v][u] && !visited[u]) //u가 아직 방문되지 않았으면
                    push(s, u); //스택에 push
            }
        }
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
    GraphType* g = (GraphType*)malloc(sizeof(GraphType));
    init_graph(g);
    for (int i=0; i<6; i++)
        insert_vertex(g, i);
    insert_edge(g, 0, 2);
    insert_edge(g, 0, 4);
    insert_edge(g, 1, 5);
    insert_edge(g, 2, 1);
    insert_edge(g, 2, 3);
    insert_edge(g, 4, 5);
    print_adj_mat(g);
    
    init_visited(visited);
    printf("\n<Depth First Search-recursive>\n");
    dfs_recursive(g, 0);
    init_visited(visited);
    printf("\n\n<Depth First Search-stack>\n");
    dfs_stack(g, 0);
    printf("\n\n");
    return 0;
}
