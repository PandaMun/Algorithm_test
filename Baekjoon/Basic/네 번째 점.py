w= []
h =[]
for i in range(3):
    a ,b = map(int, input().split())
    if a in w:
        w.remove(a)
    else:
        w.append(a)
    if b in h:
        h.remove(b)
    else:
        h.append(b)
print(str(w[0]) + ' ' + str(h[0]))