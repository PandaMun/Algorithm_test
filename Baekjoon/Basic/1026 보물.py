cnt = int(input())
A = list(map(int,input().split()))
B = list(map(int,input().split()))
answer = 0
A.sort()
B.sort(reverse=True)
for i in range(len(A)):
    answer += A[i] * B[i]
print(answer)