def set_rows_cols_to_none(m, rows_len, cols_len, row, col):
    for i in range(cols_len):
        m[row][i] = None

    for i in range(rows_len):
        m[i][col] = None

def zero_rows_cols(m):
    rows_len = len(m)
    cols_len = len(m[0])

    for row in range(rows_len):
        for col in range(cols_len):
            if m[row][col] == 0:
                set_rows_cols_to_none(m, rows_len, cols_len, row, col)

    for row in range(rows_len):
        for col in range(cols_len):
            if m[row][col] == None:
                m[row][col] = 0
    return m

def print_matrix(m):
    N = len(m)
    for i in range(N):
        print(m[i])

m = [[n for n in range(m+1,m+11)] for m in range(0,100, 10)]

m[5][5] = 0

print_matrix(zero_rows_cols(m))

# However, if the matrix could have None as a value for its elements
# that would make this solution not work. An alternative solution would
# be to create a mirror matrix and return it.
# The optimal solution offered by the book would be to just keep track
# of which columns/rows are zeroed, and at the end of the iteration turn
# the rows/cols to zeroes.
