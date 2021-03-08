#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))

int partition(int list[], int left, int right){
    int pivot = list[left];
    int temp, low, high;
    low = left;
    high = right + 1;
    do{
        do {
            low++;
        } while (list[low] < pivot); //left 다음 요소부터 증가하면서 pivot값 이상인 요소 찾기
        do {
            high--;
        } while (list[high] > pivot); //right부터 줄여 가면서 pivot값 이하인 요소 찾기
        if (low<high) SWAP(list[low], list[high], temp); //두 요소 switch
    } while (low<high); //low, high가 교차할 때까지 반복
    SWAP(list[left], list[high], temp); //pivot을 중앙에 위치시킴
    return high; //pivot 위치 반환
}

void quick_sort(int list[], int left, int right){
    if (left < right) {
        int p = partition(list, left, right); //partition 호출해서 pivot 찾기
        quick_sort(list, left, p-1); //pivot 중심으로 pivot 바로 앞까지 재귀호출
        quick_sort(list, p+1, right); //pivot 중심으로 pivot 다음부터 끝까지 재귀호출
    }
}
