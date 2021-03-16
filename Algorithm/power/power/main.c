//
//  main.c
//  power
//
//  Created by 이해린 on 2021/03/15.
//

#include <stdio.h>
#include <stdlib.h>

int iter_power(int x, int n){
    int result = 1;
    
    for (int i=0; i<n; i++){
        result *= x;
    }
    return result;
}

int recur_power(int x, int n){
    if (n==0)
        return 1;
    else if (n%2==0){
        return recur_power(x*x, n/2);
    }
    else{
        return x * recur_power(x*x, (n-1)/2);
    }
}
int main(int argc, const char * argv[]) {
    printf("2 ^ 10 = %d\n", iter_power(2, 10));
    printf("2 ^ 10 = %d\n", recur_power(2, 10));

    return 0;
}
