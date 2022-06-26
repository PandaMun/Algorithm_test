import sys
input = sys.stdin.readline
date = int(input())
cars = list(map(int,input().split()))
print(cars.count(date))