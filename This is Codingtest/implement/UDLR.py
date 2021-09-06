def UDLR(N, Plan):
    def_x = [-1,1,0,0]
    def_y = [0,0,-1,1]
    move = ['U','D','L','R']
    x = 1
    y = 1
    nx = 0
    ny = 0
    for i in Plan:
        for j in range(len(move)):
            if i == move[j]:
                nx = x + def_x[j]
                ny = y + def_y[j]
            if nx > N or nx < 1 or ny > N or ny < 1:
                continue
            x = nx
            y = ny

    print(x,y)

N = int(input())
Plan = input().split()
UDLR(N,Plan)

