import itertools
count , m = map(int, input().split())
card = list(map(int,input().split()))
answer = []

for i in itertools.combinations(card , 3): 
    #순열 조합 라이브러리 card에서 3개의 요소로된 조합을 만들어 리스트로 반환
    if sum(i) <= m:
        answer.append(sum(i))
print(max(answer))