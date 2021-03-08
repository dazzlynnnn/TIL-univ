#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 100
#define INF 1000L

typedef struct GraphNode{
    int vertex;
    int weight;
    struct GraphNode *link; //다음 노드를 가리키는 link
} GraphNode;

typedef struct GraphType{
    int n; //vertex의 개수
    GraphNode *adj_list[MAX_VERTICES]; //vertex 개수 크리의 포인터배열
} GraphType;

void init(GraphType* g){ //그래프 초기화 함수
    g->n = 0; //노드 수 0으로 초기화
    for (int i=0; i<MAX_VERTICES; i++)
        g->adj_list[i] = NULL; //모든 vertex NULL로 초기화
}

void insert_vertex(GraphType* g, int v){ //vertex insertion 연산
    if (g->n+1 > MAX_VERTICES){
        fprintf(stderr, "그래스: 정점의 개수 초과\n");
        return;
    }
    else g->n++; //vertex 개수 증가
}

void insert_edge(GraphType* g, int u, int v, int w){ //edge insertion 연산
    if (u >= g->n || v>= g->n){
        fprintf(stderr, "그래프: 정점 번호 오류\n");
        return;
    }
    GraphNode* node1 = (GraphNode*)malloc(sizeof(GraphNode)); //추가되는 vertex 생성
    node1->vertex = v;
    node1->weight = w;
    node1->link = g->adj_list[u]; //해당 vertex 인접리스트의 맨 앞에 insert
    g->adj_list[u] = node1;
    
    GraphNode* node2 = (GraphNode*)malloc(sizeof(GraphNode)); //추가되는 vertex 생성
    node2->vertex = u;
    node2->weight = w;
    node2->link = g->adj_list[v]; //해당 vertex 인접리스트의 맨 앞에 insert
    g->adj_list[v] = node2;
}

int found[MAX_VERTICES]; //선택된 vertex의 집합
int distance[MAX_VERTICES]; //spanning tree 내의 vertex에서 각 vertex까지의 distance

int choose(int distance[], int n, int found[]){ //sp 집합으로부터 가장 짧은 distance를 갖는 vertex 반환
    int i, min, minpos;
    min = INF;
    minpos = -1;
    for (i=0; i<n; i++){
        if (distance[i] < min && !found[i]){
            min = distance[i]; //아직 선택 안 된 최소거리 vertex 찾기
            minpos = i;
        }
    }
    return minpos;
}

void print_status(GraphType* g){
    static int step = 1;
    printf("STEP %d: \n", step++);
    printf(" distance: ");
    for (int i=0; i < g->n; i++){
        if (distance[i] == INF)
            printf(" * ");
        else
            printf("%2d ",distance[i]);
    }
    printf("\n found:    ");
    for (int i=0; i < g->n; i++)
        printf("%2d ", found[i]);
    printf("\n\n");
}

void shortest_path(GraphType* g, int start){
    int i, u, w;
    for (i=0; i < g->n; i++){
        found[i] = FALSE; //빈 vertex 집합으로 초기화
        GraphNode* p = NULL;
        for (p=g->adj_list[start]; p!=NULL; p=p->link){ //adj_list[start]를 하나하나 검사해서
            if (p->vertex==i){ //i와 vertex가 같으면 (start vertex와 i vertex가 인접해있으면)
                distance[i] = p->weight; //start vertex로부터의 wight를 distance에 저장
                break;
            }
            else //start vertex와 i vertex가 인접해있지 않으면
                distance[i] = INF; //무한대 저장
        }
    }
    found[start] = TRUE; //start vertex 방문 표시
    distance[start] = 0;
    
    printf("<Shortest Path - Dijkstra 결과>\n");
    for (i=0; i < g->n-1; i++){ //start 제외하고 나머지 n-1개 vertex만 체크
        print_status(g);
        u = choose(distance, g->n, found); //남은 vertex 중 distance가 가장 짧은 vertex
        found[u] = TRUE; //해당 vertex u를 집합에 추가
        for (w=0; w < g->n; w++){ //선택 안 된 모든 vertex w의 distance값 update
            GraphNode* p = NULL;
            if (!found[w]){
                for (p=g->adj_list[u]; p!=NULL; p=p->link){ //adj_list[u]를 하나하나 검사해서
                    if (p->vertex==w){ //w와 vertex가 같으면 (u vertex와 w vertex가 인접해있으면)
                        if (distance[u] + p->weight < distance[w]){ //원래의 distance보다 u를 거쳐서 w로 가는 거리가 짧으면
                            distance[w] = distance[u] + p->weight; //u를 거쳐서 w로 가는 값으로 새로 update
                            break;
                        }
                    }
                }
            }
        }
    }
    print_status(g);
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
    GraphType* g;
    g = (GraphType*)malloc(sizeof(GraphType));
    init(g);
    for (int i=0; i<7; i++)
        insert_vertex(g,i);
    insert_edge(g,0,1,7);
    insert_edge(g,0,4,3);
    insert_edge(g,0,5,10);
    insert_edge(g,1,2,4);
    insert_edge(g,1,3,10);
    insert_edge(g,1,4,2);
    insert_edge(g,1,5,6);
    insert_edge(g,2,3,2);
    insert_edge(g,3,4,11);
    insert_edge(g,3,5,9);
    insert_edge(g,3,6,4);
    insert_edge(g,4,6,5);
    shortest_path(g, 0);
    return 0;
}
