import sys
input = sys.stdin.readline
answer = []
def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    return True
for i in range(int(input())):
    phone_book = []
    result = ''
    for i in range(int(input())):
        phone = input().rstrip()
        phone_book.append(phone)
    phone_book.sort()
    if solution(phone_book):
        answer.append('YES')
    else:      
        answer.append('NO')
for i in answer:
    print(i)
