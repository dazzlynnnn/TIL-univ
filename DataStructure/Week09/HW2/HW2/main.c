#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode { //트리 노드 구조
    int key;
    struct TreeNode *left, *right;
} TreeNode;

void inorder(TreeNode *root){ //중위순회 출력 함수
    if(root) {
        inorder(root->left); //왼쪽 subtree를 인자로 재귀
        printf(" [%d]",root->key);
        inorder(root->right); //오른쪽 subtree를 인자로 재귀
    }
}

TreeNode* new_node(int item){ //새로운 노드 추가 함수
    TreeNode *node = (TreeNode*)malloc(sizeof(TreeNode)); //새로운 메모리 할당
    node->key = item; //값 복사
    node->left = node->right = NULL; //child 노드를 NULL로 초기화
    return node; //새로 생성된 노드 반환
}

TreeNode* insert_node(TreeNode *root, int key){ //해당 위치 찾아서 key값 갖는 노드 insert 함수
    if(root==NULL) return new_node(key); //트리가 공백이면 insert된 새로운 노드를 반환
    if(key < root->key) root->left = insert_node(root->left, key);
    //insert 할 값이 root의 키값보다 작으면 left subtree를 root로 insert 재귀호출
    else if(key > root->key) root->right = insert_node(root->right, key);
    //insert 할 값이 root의 키값보다 크면 right subtree를 root로 insert 재귀호출
    return root; //변경된 root 포인터 반환
}

TreeNode* max_value_node(TreeNode* node){ //left subtree의 최대값 찾는 함수
    TreeNode *current = node->left;
    while(current->right!=NULL) current = current->right;
    return current;
}

TreeNode* min_value_node(TreeNode* node){ //right subtree의 최소값 찾는 함수
    TreeNode *current = node->right;
    while(current->left!=NULL) current = current->left;
    return current;
}


TreeNode* delete_node(TreeNode* root, int key){ //key가 저장된 노드를 찾아 삭제하고 새로운 root 반환
    if (root==NULL) return root;
    else if (root->key > key) //왼쪽 subtree에서 key값을 찾아 삭제하도록 재귀호출
        root->left = delete_node(root->left, key); //새로운 left child로 변경
    else if (root->key < key) //오른쪽 subtree에서 key값을 찾아 삭제하도록 재귀호출
        root->right = delete_node(root->right, key); //새로운 right child로 변경
    else{ //delete하고자 하는 key를 찾았을 때
        if (root->left == NULL){
            TreeNode *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL){
            TreeNode *temp = root->left;
            free(root);
            return temp;
        }
        if ((root->key-max_value_node(root)->key) > (min_value_node(root)->key-root->key)){
            TreeNode *temp = min_value_node(root);
            root->key = temp->key;
            root = delete_node(root->right, temp->key);
        }
        else{
            TreeNode *temp = max_value_node(root);
            root->key = temp->key;
            root = delete_node(root->left, temp->key);
        }
    }
    return root;
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

int main(void) {
    char ch = '\0';
    int n = 0;
    myName();
    
    TreeNode *root = NULL;
    root = insert_node(root, 30);
    root = insert_node(root, 20);
    root = insert_node(root, 10);
    root = insert_node(root, 45);
    root = insert_node(root, 50);
    root = insert_node(root, 60);

    printf("이진 탐색 트리 중위 순회 결과\n");
    inorder(root);
    
    while(1){
        printf("\n\n* operation 선택: Insert(I) / Delete(D) / Exit(X): ");
        scanf(" %c",&ch);
        switch(ch){
            case 'I': case 'i':
                printf("Insert할 값은? ");
                scanf("%d",&n);
                insert_node(root, n);
                inorder(root);
                break;
            case 'D': case 'd':
                printf("Delete할 값은? ");
                scanf("%d",&n);
                printf("left subtree의 max: %d\n",max_value_node(root)->key);
                printf("right subtree의 min: %d\n",min_value_node(root)->key);
                printf("original value: %d  new value: %d\n",n,delete_node(root, n)->key);
                inorder(root);
                break;
            case 'X': case 'x':
                printf("프로그램 종료\n");
                exit(0);
            default:
                printf("잘못된 입력입니다.\n");
                break;
        }
    }
    return 0;
}

