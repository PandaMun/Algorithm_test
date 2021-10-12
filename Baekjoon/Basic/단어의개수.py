a = list(input().split(' '))
if a[0] == '':
    a.remove('')
if a[len(a)-1] == '':
    a.remove('')
print(len(a))