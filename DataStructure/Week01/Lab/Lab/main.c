#include <stdio.h>
int main(void){
    int Array[100];
    int n, largest;
    
    printf("input n:");
    scanf("%d", &n);
    for (int i=0; i<n; i++)
        scanf("%d", &Array[i]);
    largest = find_max_score(Array, n);
    printf("largest: %d\n", largest);
    return 0;
}
int find_max_score(int Array[], int n){
    int largest = Array[0];
    for (int i=1; i<n; i++){
        if (Array[i]>largest){
            largest = Array[n];
        }
    }
    return largest;
}
