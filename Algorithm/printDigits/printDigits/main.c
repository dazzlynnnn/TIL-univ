//
//  main.c
//  printDigits
//
//  Created by 이해린 on 2021/03/15.
//

#include <stdio.h>
#include <stdlib.h>

void rPrintDigits(int n){
    if(n<10)
        printf("%d\n", n);
    else{
        rPrintDigits(n/10);
        printf("%d\n", n%10);
    }
}
void printDigits() {
    int n;
    printf("Enter a number : ");
    scanf("%d", &n);
    if (n<0)
        printf("Negative!\n");
    else
        rPrintDigits(n);
}
int main(int argc, const char * argv[]) {
    printDigits();
}
