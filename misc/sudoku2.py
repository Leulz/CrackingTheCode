# Problem: https://app.codesignal.com/interview-practice/task/SKZ45AF99NpbnvgTn

def mark_row(grid, row, num):
    grid[row][int(num)] += 'r'

def mark_col(grid, col, num):
    grid[int(num)][col] += 'c'

def get_square(row, col):
    return "sq{}".format((row // 3) * 3  + (col // 3) + 1)

def mark_square(grid, num, sq):
    grid[int(num)][int(num)] += sq

def already_exists_in_row(grid, row, num):
    return 'r' in grid[row][int(num)]

def already_exists_in_col(grid, col, num):
    return 'c' in grid[int(num)][col]

def already_exists_in_square(grid, num, sq):
    return sq in grid[int(num)][int(num)]

def sudoku2(grid):
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            el = grid[i][j]
            if '.' not in el:
                num = int(el[0]) - 1
                current_square = get_square(i, j)
                if already_exists_in_row(grid, i, num) or already_exists_in_col(grid, j, num) or already_exists_in_square(grid, num, current_square):
                    return False
                mark_row(grid, i, num)
                mark_col(grid, j, num)
                mark_square(grid, num, current_square)
    return True
