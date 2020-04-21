letters = [0] * 26

ascii_offset = 97 # ord('a') == 97

def is_all_unique_characters(word):
    for c in word:
        c_pos = ord(c) - ascii_offset
        if letters[c_pos] != 0:
            return False
        else:
            letters[c_pos] += 1
    return True

print(is_all_unique_characters("abcdefg"))
print(is_all_unique_characters("abcdefghb"))

# if there can be any Unicode characters in the string, I'd use a hashmap

# without using a data structure, the naive solution would be to just search for each character
# time complexity is O(n^2)
def naive(word):
    for i in range(len(word)):
        for for j in range(i, len(word)):
            if word[i] == word[j]:
                return False
    return True

# from the book: the better solution without data structures would be to sort the string
