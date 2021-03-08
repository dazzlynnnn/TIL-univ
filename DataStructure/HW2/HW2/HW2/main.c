#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100

typedef struct TreeNode{
    char key[MAX];
    struct TreeNode *left, *right;
}TreeNode;

TreeNode* new_node(char item[]){
    TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
    strcpy(node->key,item); node->left = node->right = NULL;
    return node; //새로 생성된 노드 반환
}
TreeNode* insert_node (TreeNode* node, char key[]){
    if (node==NULL) return new_node(key); //노드가 NULL이면 insert 된 새로운 노드 반환
    if (strcmp(key,node->key) < 0) //key가 node->key보다 알파벳순으로 앞일 경우
        node->left = insert_node(node->left, key);
    else if (strcmp(key,node->key) > 0) //key가 node->key보다 알파벳순으로 뒤일 경우
        node->right = insert_node(node->right, key);
    return node; //수정된 root 포인터 반환
}

TreeNode* init_node(TreeNode* node){ //초기값 설정 함수
    node = insert_node(node, "apple");
    node = insert_node(node, "banana");
    node = insert_node(node, "blueberry");
    node = insert_node(node, "kiwi");
    node = insert_node(node, "orange");
    node = insert_node(node, "pear");
    return node;
}

TreeNode* min_value_node(TreeNode* node){ //가장 왼쪽의 단말 노드 찾기(최소값)
    TreeNode* current = node;
    while(current->left!=NULL) current = current->left; //계속 왼쪽 child 찾아내려감
    return current;
}
TreeNode* delete_node(TreeNode* root, char key[]){ //key값 노드 삭제하고 새로운 root 반환
    if (root==NULL) return root;
    else if (strcmp(root->key,key)>0) //왼쪽 subtree에서 key값을 찾아 삭제하도록 재귀호출
        root->left = delete_node(root->left, key); //새로운 left child로 변경
    else if (strcmp(root->key,key)<0) //오른쪽 subtree에서 key값을 찾아 삭제하도록 재귀호출
        root->right = delete_node(root->right, key); //새로운 right child로 변경
    else{ //delete하고자 하는 key를 찾았을 때
        if (root->left==NULL){ //leaf노드거나 child를 하나 갖는 노드일 경우
            TreeNode* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right==NULL){
            TreeNode* temp = root->left;
            free(root);
            return temp;
        }
        TreeNode* temp = min_value_node(root->right); //child가 둘 다 있는 경우 가장 가까운 key값 갖는 노드 찾기
        strcpy(root->key,temp->key); //가장 가까운 key 값을 삭제할 위치에 복사
        root->right = delete_node(root->right, temp->key); //복사된 값을 갖고 있던 노드 삭제
    }
    return root; //새로운 root 반환
}

TreeNode* search_node(TreeNode* node, char key[]){
    if (node==NULL) return NULL; //탐색 실패
    if (strcmp(key,node->key)==0) return node; //탐색 성공
    else if (strcmp(key,node->key)<0) return search_node(node->left, key); //left subtree에서 다시 검색
    else return search_node(node->right, key); //right subtree에서 다시 검색
}

void print_node(TreeNode* node){ //inorder로 출력
    if(node){
        print_node(node->left);
        printf("%s\n",node->key);
        print_node(node->right);
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
    
    int i=0, k=0;
    char w[MAX];
    TreeNode* node = NULL;
    node = init_node(node);
    
    while(k==0){
        w[0]='\0';
        printf("\n* Choose operation <1.insert 2.delete 3.search 4.print 5.exit> : ");
        scanf("%d",&i);
        switch (i) {
            case 1:
                getchar();printf("Enter a word:");
                scanf("%s",w);getchar();
                insert_node(node,w);break;
            case 2:
                getchar();printf("Enter a word to delete:");
                scanf("%s",w);getchar();
                delete_node(node,w);break;
            case 3:
                getchar();printf("Enter a word:");
                scanf("%s",w);getchar();
                if (search_node(node,w)) printf("%s is found\n",w);
                else printf("%s is not found\n",w);break;
            case 4:
                print_node(node);break;
            case 5:
                printf("Program finished\n");
                k=-1;break;
            default:
                printf("Wrong input\n");break;
        }
    }
    return 0;
}
