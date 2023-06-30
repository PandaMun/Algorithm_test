package Level3;

import java.util.Stack;

public class EditTable {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove_order = new Stack<Integer>(); // 삭제된 행의 인덱스를 저장하는 스택
        int table_size = n; // 테이블의 초기 크기는 n으로 설정됩니다.

        for (int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0); // 명령어의 첫 번째 문자를 가져옵니다.

            if (c == 'D') {
                // k만큼 아래로 이동
                k += Integer.parseInt(cmd[i].substring(2));
            } else if (c == 'U') {
                // k만큼 위로 이동
                k -= Integer.parseInt(cmd[i].substring(2));
            } else if (c == 'C') {
                // 현재 행 (인덱스 k)을 삭제
                remove_order.push(k); // 삭제된 행의 인덱스를 스택에 추가합니다.
                table_size--; // 테이블 크기 감소
                if (k == table_size)
                    k--; // 현재 위치가 마지막 행이었을 경우 위치를 조정합니다.
            } else if (c == 'Z') {
                // 마지막 삭제 작업을 되돌립니다.
                if (remove_order.pop() <= k)
                    k++; // 삭제된 인덱스가 현재 위치보다 작거나 같은 경우 한 칸 아래로 이동합니다.
                table_size++; // 테이블 크기 증가
            }
        }

        StringBuilder builder = new StringBuilder();
        // 'O'로 존재하는 행, 'X'로 삭제된 행을 가지고 최종 테이블 문자열을 구성합니다.
        for (int i = 0; i < table_size; i++)
            builder.append("O");

        while (!remove_order.isEmpty())
            builder.insert(remove_order.pop().intValue(), "X");

        String answer = builder.toString();
        return answer;
    }
}