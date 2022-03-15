def solution(sizes):
    width = []
    length = []
    for i in range(len(sizes)):
        width.append(max(sizes[i]))
        length.append(min(sizes[i]))

    return (max(width) * max(length))