package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonalInfoCollectPeriod {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, String> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], term[1]);
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacies = privacies[i].split(" ");
            if (!checkPeriod(today, splitPrivacies[0], map.get(splitPrivacies[1]))) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static Boolean checkPeriod(String today, String term, String count) {
        String[] date = term.split("[.]");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]) - 1;
        month += Integer.parseInt(count);
        if (month > 12) {
            year += month / 12;
            month = month % 12;
        }
        if (day == 0) {
            month -= 1;
            day = 28;
        }
        if (month == 0) {
            year -= 1;
            month = 12;
        }
        int[] terms = new int[] { year, month, day };
        String[] now = today.split("[.]");
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(now[i]) < terms[i]) {
                return true;
            } else if (Integer.parseInt(now[i]) > terms[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(solution("2022.05.19", new String[] { "A 6", "B 12", "C 3" },
                new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" }));
    }
}
