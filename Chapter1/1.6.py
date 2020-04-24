# rotate NxN matrix by 90 degrees

def swap(m, x1, y1, x2, y2):
    m[x1][y1] ^= m[x2][y2]
    m[x2][y2] ^= m[x1][y1]
    m[x1][y1] ^= m[x2][y2]

def transform_coord(x, y, N):
    return y, N - x - 1

def rotate_matrix(matrix):
    N = len(matrix)
    for i in range(N):
        for j in range(i, N - (i + 1)):
            x_dest, y_dest = transform_coord(i, j, N)
            swap(matrix, i, j, x_dest, y_dest)
            x_dest, y_dest = transform_coord(x_dest, y_dest, N)
            swap(matrix, i, j, x_dest, y_dest)
            x_dest, y_dest = transform_coord(x_dest, y_dest, N)
            swap(matrix, i, j, x_dest, y_dest)

def print_matrix(m):
    N = len(m)
    for i in range(N):
        print(m[i])

m = [[n for n in range(m+1,m+11)] for m in range(0,100, 10)]

print_matrix(m)
print("-----")
rotate_matrix(m)
print_matrix(m)

#5x5
#i == 0 => j vai do 0 ao 3
#i == 1 => j vai do 1 ao 2
#i == 2 => j vai do 2 ao 2

#10x10
#i == 0 => j vai do 0 ao 8
#i == 1 => j vai do 1 ao 7
#i == 2 => j vai do 2 ao 6
