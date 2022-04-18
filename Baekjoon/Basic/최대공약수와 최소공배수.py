import sys
# 유클리드 호제법
# 숫자 a,b가 존재할때 a를 b로 나눈
# 나머지 r과 b의 최대 공약수는 a와 b의 최대공약수와 같다

def GCD(n,m):
    while (m > 0):
        n,m = m, n%m
    return n

# 최소 공배수는 서로 다른 수 a,b의 배수중
# 공통되는 배수중 가장 작은 값으로 최소 공배수는 a,b의 곱을 
# a,b의 최대 공약수로 나누면 나오게 됩니다.
def LCM(n,m):
    return int((n*m) / GCD(n,m))

input = sys.stdin.readline
n,m = map(int, input().split())

print(GCD(n,m))
print(LCM(n,m))
