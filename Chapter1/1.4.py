# Define if two strings are anagrams

def are_anagrams(str1, str2):
    hashmap = {}
    for c in str1:
        if c in hashmap:
            hashmap[c] += 1
        else:
            hashmap[c] = 1
    for c in str2:
        if not c in hashmap:
            return False
        else:
            if hashmap[c] == 1:
                del hashmap[c]
            else:
                hashmap[c] -= 1
    if len(hashmap) == 0:
        return True
    else:
        return False

if __name__ == '__main__':
    str1, str2 = input().split()
    print(are_anagrams(str1, str2))

# The algorithm has time complexity of O(n), but it requires a hashmap.
# to use less storage in detriment of time complexity, we could sort both
# strings and then just see if they are equal. That would have O(n * log(n))
# time complexity as long as we use something like quicksort.
