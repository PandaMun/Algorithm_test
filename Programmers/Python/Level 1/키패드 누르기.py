
def solution(numbers, hand):
    result = ""
    left = [1,4,7,10]
    right = [3,6,9,10]
    mid = [2,5,8,0]
    L_hands = 10
    R_hands = 10
    for i in numbers:
        if i in left:
            result += "L"
            L_hands = i
        elif i in right:
            result += "R"
            R_hands = i
        else:
            if L_hands in mid:
                L_distance = abs(mid.index(i) - mid.index(L_hands))
            else:
                L_distance = abs(mid.index(i) - left.index(L_hands)) + 1

            if R_hands in mid:
                R_distance = abs(mid.index(i) - mid.index(R_hands))
            else:
                R_distance = abs(mid.index(i) - right.index(R_hands)) + 1

            if(L_distance < R_distance):
                result += "L"
                L_hands = i

            elif(L_distance > R_distance):
                result += "R"
                R_hands = i  

            else:
                if hand == "right":
                    result += "R"
                    R_hands = i  
                else:
                    result += "L"
                    L_hands = i      
    return result
    
# Test_case 1
numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
print(solution(numbers,hand))