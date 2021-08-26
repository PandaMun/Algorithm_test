test_count = int(input())

test_score = list(map(int, input().split()))
high_score = test_score[0]
for i in test_score:
    if i >= high_score:
        high_score = i
average_score = 0
for i in test_score:
    fake_score = (i/high_score) * 100
    average_score += fake_score

print(average_score/test_count)
