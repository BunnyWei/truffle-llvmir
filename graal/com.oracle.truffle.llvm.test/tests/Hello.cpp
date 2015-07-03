#include <stdio.h>

void hello(int pare1, int pare2, int pare3){
    printf("%d\n",pare1+pare2+pare3);
}
int main() {
    bool h = true;
    /*if (h) {
        printf("this is true!");
    } else {
        printf("this is false!!");
    }*/
    int count = 12;
    while(count--){
        printf("%d\n",count);
    }
    switch (count) {
        case 10:
            hello(10, 1,1);
            break;
        case 11:
            hello(11, 1,1);
            break;
        case 12:
            hello(12, 1,1);
            break;
        case 9:
            hello(9, 1,1);
            break;
        default:
            break;
    }
    hello(1,2,3);
  printf("hello world\n");
  return 0;
}
