package Level3;

public class InsertAdvertising {
    public String solution(String play_time, String adv_time, String[] logs) {
        // play_time과 adv_time을 문자열 형식에서 초로 변환합니다.
        int play_time_sec = convertTimetoInt(play_time);
        int adv_time_sec = convertTimetoInt(adv_time);

        // 각 초마다 재생 횟수를 저장할 배열을 초기화합니다.
        long[] play_count = new long[play_time_sec + 1];

        // 각 로그 항목을 처리합니다.
        for (String log : logs) {
            // 로그를 시작 시간과 종료 시간으로 분리합니다.
            String[] times = log.split("-");

            // 시작 시간에 재생 횟수를 증가시킵니다.
            play_count[convertTimetoInt(times[0])]++;

            // 종료 시간에 재생 횟수를 감소시킵니다.
            play_count[convertTimetoInt(times[1])]--;
        }

        // 각 초마다 누적 재생 횟수를 계산합니다.
        for (int i = 1; i <= play_time_sec; i++) {
            play_count[i] += play_count[i - 1];
        }

        // 각 초마다 누적 재생 시간을 계산합니다.
        for (int i = 1; i <= play_time_sec; i++) {
            play_count[i] += play_count[i - 1];
        }

        // 광고 시간 동안의 최대 재생 시간을 찾습니다.
        long max = play_count[adv_time_sec - 1];
        System.out.println(adv_time_sec - 1);
        int index = 0;
        for (int i = 0; i + adv_time_sec <= play_time_sec; i++) {
            // 현재 창에서의 재생 시간을 계산합니다.
            long time = play_count[i + adv_time_sec] - play_count[i];

            // 최대 재생 시간과 해당하는 인덱스를 업데이트합니다.
            if (max < time) {
                index = i + 1;
                max = time;
            }
        }

        // 인덱스를 포맷된 시간 문자열로 변환합니다.
        return convertInttoTime(index);
    }

    // 시간 문자열(HH:MM:SS)을 초로 변환하는 도우미 메서드입니다.
    public int convertTimetoInt(String str) {
        String[] hms = str.split(":");
        return Integer.valueOf(hms[0]) * 3600 + Integer.valueOf(hms[1]) * 60 + Integer.valueOf(hms[2]);
    }

    // 초를 포맷된 시간 문자열로 변환하는 도우미 메서드입니다.
    public String convertInttoTime(int time) {
        int h = time / 3600;
        time = time % 3600;
        int m = time / 60;
        time = time % 60;
        return String.format("%02d:%02d:%02d", h, m, time);
    }
}
