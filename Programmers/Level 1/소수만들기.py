def prime_num(i):
    for j in range(2,i):
        if i % j == 0:
            return False
    return True

def solution(nums):
    answer = []
    result = 0
    prime = []
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            for k in range(j+1, len(nums)):
                result = nums[i]+nums[j]+nums[k]
                answer.append(result)
    for i in answer:
        if prime_num(i):
            prime.append(i)
    
                
    
    return len(prime)