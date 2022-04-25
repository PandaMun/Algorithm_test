stack = []
for i in range(int(input())):
    k = int(input())
    if k == 0:
        stack.pop()
    else:
        stack.append(k)
print(sum(stack))