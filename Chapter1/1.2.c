#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* revert(char* str) {
	char* begin = str;
	char* c = str;
	while (*c) {
		c = c + sizeof(char);
	}

	// we are now with c == NULL
	c = c - sizeof(char);

	while (str < c) {
		char tmp = *str;
		*str = *c;
		*c = tmp;
		str = str + sizeof(char);
		c = c - sizeof(char);
	}

	return begin;
}

int main() {
	char str[] = "string";
	revert(str);
	printf("%s\n", str);

	return 0;
}
