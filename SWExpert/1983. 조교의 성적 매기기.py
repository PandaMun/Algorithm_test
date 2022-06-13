answer = []
credit = ['A+','A0','A-','B+','B0','B-','C+','C0','C-','D0']
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,k = map(int,input().split())
    score = []
    for i in range(n):
        mid,final,project = map(int,input().split())
        score.append([i+1 ,((mid * 0.35) + (final * 0.45) + (project * 0.2))])
    score.sort(key=lambda x: x[1], reverse=True)
    for i in range(len(score)):
        if score[i][0] == k:
            answer.append(credit[i//(n//10)])
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))    