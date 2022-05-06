book = []
find = {}
answer = []
for i in range(int(input())):
    selling = input()
    book.append(selling)
    find[selling] = 0
for i in book:
    find[i] += 1
name = list(find.keys())
cnt = list(find.values())
for i in range(len(name)):
    answer.append([name[i],cnt[i]])
answer.sort(key=lambda x : (-x[1],x[0]))    

print(answer[0][0])
    