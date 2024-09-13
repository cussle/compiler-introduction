#include <stdio.h>

int main() {
    int a;
    int b;

    a = 5;
    b = 55;
    b += a;
    b -= a;
    b -= 55;
    printf("%d", b);

    return 0;
}
