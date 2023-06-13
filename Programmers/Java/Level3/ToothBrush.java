package Level3;

import java.util.HashMap;

// 센터를 제외한 나머지 인원이 각자 얼마씩 먹는지
// 무조건 부모는 존재 (센터)

class Person {
    String name; // 사람의 이름
    Person parent; // 부모 객체
    int profit; // 이익

    public Person(String name, Person parent, int profit) {
        this.name = name;
        this.parent = parent;
        this.profit = profit;
    }

    public void CalcProfit(int profit) {
        int profitToParent = profit / 10; // 부모에게 전달할 이익 10퍼
        this.profit += profit - profitToParent; // 자기꺼 90퍼
        if (this.parent != null && profitToParent >= 1) {
            this.parent.CalcProfit(profitToParent); // 부모에게 전달할 이익이 1 이상일 경우, 부모의 이익 계산 메서드 호출
        }
    }
}

class ToothBrush {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // 초기화

        HashMap<String, Person> personMap = new HashMap<>(); // 사람의 이름과 객체를 매핑하는 해시맵 생성
        for (String name : enroll) {
            personMap.put(name, new Person(name, null, 0)); // enroll 배열의 각 이름을 키로 하여 Person 객체 생성 후 해시맵에 추가
        }

        // 부모 세팅
        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                continue; // referral 배열이 "-"인 경우, 부모가 없으므로 다음 반복으로 건너뜀
            }
            personMap.get(enroll[i]).parent = personMap.get(referral[i]); // enroll[i] 이름의 사람의 부모를 referral[i] 이름의 사람으로
                                                                          // 설정
        }

        for (int i = 0; i < seller.length; i++) {
            personMap.get(seller[i]).CalcProfit(amount[i] * 100);// 이익 계산 메서드 호출!!
        }

        int[] result = new int[enroll.length]; // 결과 배열

        for (int i = 0; i < result.length; i++) {
            result[i] = personMap.get(enroll[i]).profit; // enroll 배열의 이름을 키로 하여 이익을 결과 배열에 저장
        }

        return result; // 결과 배열 반환
    }
}