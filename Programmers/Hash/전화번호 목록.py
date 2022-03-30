# def solution(phone_book):
#     for i in phone_book:
#         for j in phone_book:
#             if i in j[0:len(i)]:
#                 if i != j:
#                     return False
#     return True

def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False

    return True