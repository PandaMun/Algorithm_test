import sys
import math
input = sys.stdin.readline

cnt = int(input())
house = list(map(int,input().split()))

house.sort()
print(house[(cnt//2)-1])