// replace spaces with %20

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE_OF_STR 100

// my solution if I hadn't read the solution in the book
char* replaceSpaces(char* str) {
	char* ret = malloc(300); // 3 * maxLength(str)
	char* startOfRet = ret;
	while (*str) {
		if (*str == ' ') {
			*ret++ = '%';
			*ret++ = '2';
			*ret++ = '0';
		} else {
			*ret++ = *str;
		}
		str++;
	}
	return startOfRet;
}

// the better solution, in-place
void replaceSpacesInPlace(char* str) {
	char* startOfStr = str;
	int numberOfSpaces = 0;
	while (*str) {
		if (*str++ == ' ') {
			numberOfSpaces++;
		}
	}
	str = startOfStr;
	int lengthOfStr = strlen(str);
	int spacesOffset = numberOfSpaces * 2;
	if (lengthOfStr + spacesOffset >= SIZE_OF_STR) {
		printf("The returned str would be bigger than the allocated size.");
		exit(1);
	}

	str = startOfStr;
	char* end = str + lengthOfStr - 1;
	char* retEnd = str + lengthOfStr + spacesOffset - 1;
	while (end >= str) {
		if (*end == ' ') {
			*retEnd-- = '0';
			*retEnd-- = '2';
			*retEnd-- = '%';
		} else {
			*retEnd-- = *end;
		}
		end--;
	}
}

int main() {
	char* str = malloc(SIZE_OF_STR);
	fgets(str, SIZE_OF_STR, stdin);
	strtok(str, "\n");
	char* replacedStr = replaceSpaces(str);
	printf("str after calling replaceSpaces: %s\n", str);
	printf("Replaced via my method: %s\n", replacedStr);
	replaceSpacesInPlace(str);
	printf("str after calling replaceSpacesInPlace: %s\n", str);
	free(str);
	free(replacedStr);
}
