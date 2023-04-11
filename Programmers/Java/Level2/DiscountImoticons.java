package Level2;

public class DiscountImoticons {

    private static final int[] RATE = { 10, 20, 30, 40 };
    private static int EMOTICON_PLUS = 0; // 이모티콘 플러스 가입자수
    private static int TOTAL_SALES = 0; // 이모티콘 매출액

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(emoticons, users, 0, new int[emoticons.length]);
        return new int[] { EMOTICON_PLUS, TOTAL_SALES };
    }

    private void dfs(int[] emoticons, int[][] users, int cur, int[] rates) {
        if (cur == emoticons.length) {
            updateAnswer(emoticons, users, rates);
            return;
        }

        for (int i = 0; i < 4; i++) {
            rates[cur] = RATE[i];
            dfs(emoticons, users, cur + 1, rates);
        }
    }

    private void updateAnswer(int[] emoticons, int[][] users, int[] rates) {

        int ePlus = 0;
        int totalExpense = 0;

        for (int i = 0; i < users.length; i++) {
            int expense = 0;
            int rate = users[i][0];
            int price = users[i][1];
            for (int j = 0; j < rates.length; j++) {
                if (rates[j] >= rate) { // 사용자가 원하는 할인율보다 높을떄
                    expense += emoticons[j] - (emoticons[j] * rates[j] / 100); // 구매한 가격
                }
                if (expense >= price) { // 구매한 가격이 사용자 마지노선보다 클때
                    ePlus += 1; // plus 가입
                    expense = 0; // 초기화
                    break;
                }
            }
            totalExpense += expense;
        }

        if (ePlus > EMOTICON_PLUS) { // 플러스 요금제 가입자수가 많다면
            EMOTICON_PLUS = ePlus;
            TOTAL_SALES = totalExpense;
        } else if (ePlus == EMOTICON_PLUS) { // 플러스 요금제 가입자수 변화 없다면
            TOTAL_SALES = Math.max(totalExpense, TOTAL_SALES); // 총 판매 가격 비교해서 최고가로
        }
    }

    public static void main(String[] args) {

    }
}
