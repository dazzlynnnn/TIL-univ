#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct TreeNode{
    int key;
    struct TreeNode *left, *right;
}TreeNode;

int max_key(TreeNode* exp){ //최대 key값 찾는 함수
    int max = INT_MIN; //max의 초기값은 최대한 작게 설정
    if (exp==NULL) return max; //노드가 비었으면 max 반환
    else{
        if (max_key(exp->left) < max_key(exp->right)) //왼쪽 subtree의 max값보다 오른쪽 subtree의 max값이 크면
            max = max_key(exp->right); //max값을 오른쪽 subtree의 max값으로 바꿈
        else //그게 아닐 경우
            max = max_key(exp->left); //max값을 왼쪽 subtree의 max값으로 바꿈
        if (max < exp->key) return exp->key; //바뀐 max값보다 노드의 key값이 크면 노드의 key값 반환
        else return max; //그게 아닐 경우 max값 반환
    }
}

int min_key(TreeNode* exp){ //최소 key값 찾는 함수
    int min = INT_MAX; //min의 초기값은 최대한 크게 설정
    if (exp==NULL) return min; //노드가 비었으면 min 반환
    else{
        if (min_key(exp->left) < min_key(exp->right)) //왼쪽 subtree의 min값보다 오른쪽 subtree의 min값이 크면
            min = min_key(exp->left); //min값을 왼쪽 subtree의 min값으로 바꿈
        else //그게 아닐 경우
            min = min_key(exp->right); //min값을 오른쪽 subtree의 min값으로 바꿈
        if (min < exp->key) return min; //바뀐 min값보다 노드의 key값이 크면 min값 반환
        else return exp->key; //그게 아닐 경우 노드의 key값 반환
    }

}
int sum_key(TreeNode* exp){ //key값의 합계 구하는 함수
    if (exp==NULL) return 0; //노드가 비었으면 0 반환
    else return (sum_key(exp->left) + sum_key(exp->right) + exp->key); //왼쪽 subtree와 오른쪽 subtree를 재귀적으로 계산
}
int one_child_node(TreeNode* exp){ //child를 한 개 갖는 노드의 수 구하는 함수
    if (exp==NULL) return 0; //노드가 비었으면 0 반환
    else{
        if ((exp->left==NULL&&exp->right!=NULL)||(exp->left!=NULL&&exp->right==NULL)) //child를 한 개 갖는 노드일 때
            return (one_child_node(exp->left)+one_child_node(exp->right)+1); //왼쪽 subtree와 오른쪽 subtree에서 계속 해당 노드를 찾으면서 +1
        else return (one_child_node(exp->left)+one_child_node(exp->right)); //child를 한 개 갖는 노드가 아닐 때, 왼쪽 subtree와 오른쪽 subtree에서 계속 해당 노드를 찾음
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
    
    TreeNode n0 = { 11, NULL, NULL };
    TreeNode n1 = { 2, &n0, NULL };
    TreeNode n2 = { 5, &n1, NULL };
    TreeNode n3 = { 13, &n2, NULL };
    TreeNode n4 = { 25, &n3, NULL };
    TreeNode n5 = { 8, NULL, NULL };
    TreeNode n6 = { 3, NULL, &n5 };
    TreeNode n7 = { 21, &n4, &n6 };
    TreeNode* exp = &n7;
    
    printf("Sum of keys in binary tree: %d\n", sum_key(exp));
    printf("Num of one child nodes: %d\n", one_child_node(exp));
    printf("Max value: %d\n", max_key(exp));
    printf("Min value: %d\n", min_key(exp));

    return 0;
}
