N = int(input())       
Cycle = 0
Clone_N = N
while 1:
    remain = Clone_N % 10 
    Share = Clone_N // 10
    value = (remain + Share) % 10
    value = remain * 10 + value
    Cycle += 1
    Clone_N = value
    if(Clone_N == N):
        break
print(Cycle)
  