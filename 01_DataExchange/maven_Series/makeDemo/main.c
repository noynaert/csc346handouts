//main.c

#include <stdio.h>
#include <silly.h>
// Demonstrates make
//

int main(int argc, char *argv[]){
	int n = argc;
	printf("There are %d arguments\n", n);

	for (int i=0; i<n; i++){
		printf("%2d. %s\n", i, argv[i]);
	}
}
