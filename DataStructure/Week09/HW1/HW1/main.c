#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode { //트리 노드 구조
    int data;
    struct TreeNode *left, *right;
} TreeNode;

int get_node_count(TreeNode *exp){ //노드 개수 반환 함수
    if (exp == NULL) return 0;
    else return get_node_count(exp->left)+get_node_count(exp->right)+1;
    //왼쪽 subtree의 노드 개수 + 오른쪽 subtree의 노드 개수 + root 1개
}

int get_leaf_count(TreeNode *exp){ //단말 노드 개수 반환 함수
    if (exp == NULL) return 0;
    else{
        if (exp->left == NULL && exp->right == NULL) return 1; //leaf 노드인 경우
        else return get_leaf_count(exp->left) + get_leaf_count(exp->right); //child가 있는 경우
    }
}

int get_height(TreeNode *exp){ //높이 반환 함수
    if (exp == NULL) return 0;
    else{
        int l_height = get_height(exp->left); //왼쪽 subtree 높이
        int r_height = get_height(exp->right); //오른쪽 subtree 높이
        if (l_height >= r_height) return l_height + 1;
        else return r_height + 1;
        //더 큰 높이 + 1 (root) 해서 return
    }
}

void inorder(TreeNode *exp){ //중위순회 출력 함수
    if(exp) {
        inorder(exp->left); //왼쪽 subtree를 인자로 재귀
        printf(" [%d]",exp->data);
        inorder(exp->right); //오른쪽 subtree를 인자로 재귀
    }
}

void search(TreeNode *exp, int n){ //n보다 큰 숫자만 출력하는 함수
    if(exp) {
        search(exp->left, n); //왼쪽 subtree를 인자로 재귀
        if(exp->data > n) printf(" %d",exp->data); //n보다 data가 크면 출력
        search(exp->right, n); //오른쪽 subtree를 인자로 재귀
    }
}

void balance(TreeNode *exp){ //이진트리의 subtree의 높이 차이가 최대 1 이하인 경우 검사
    int h1, h2;
    h1=get_height(exp->left); //왼쪽 subtree 높이
    h2=get_height(exp->right); //오른쪽 subtree 높이
    if ((h1-h2)>1 || (h1-h2)<-1) printf("No\n"); //차이가 2 이상이면 balanced tree 아님
    else printf("Yes\n"); //차이가 1 이하이면 balanced tree
}

void myName(void){
    printf("=================\n");
    printf("학과:사이버보안전공\n");
    printf("학번:1971083\n");
    printf("성명:이해린\n");
    printf("=================\n\n");
}

TreeNode n1 = { 1, NULL, NULL};
TreeNode n2 = { 4, NULL, NULL};
TreeNode n3 = { 15, &n1, &n2};
TreeNode n4 = { 16, NULL, NULL};
TreeNode n5 = { 25, NULL, NULL};
TreeNode n6 = { 7, &n4, &n5};
TreeNode n7 = { 30, &n3, &n6};
TreeNode *exp = &n7;

int main(void) {
    int n=0;
    myName();
    inorder(exp);
    printf("\n");
    printf("Number of nodes in tree: %d\n",get_node_count(exp));
    printf("Height of the tree: %d\n",get_height(exp));
    printf("Number of leafs in tree: %d\n",get_leaf_count(exp));
    printf("Balanced tree? ");
    balance(exp);
    printf("Input a number to check: ");
    scanf("%d",&n);
    printf("numbers greater than %d: ",n);
    search(exp, n);
    printf("\n");
    return 0;
}
