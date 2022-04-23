n = list(input().split('-'))
formula = []
for i in n:
    plus = list(map(int, i.split('+')))
    formula.append(sum(plus))
answer = formula[0]
for i in range(1,len(formula)):
    answer -= formula[i]
print(answer)