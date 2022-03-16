def solution(nums):
    answer = 0
    count = len(nums)/2
    nums = list(set(nums))
    if len(nums) > count:
        return count
    else:
        return len(nums)