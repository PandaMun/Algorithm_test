package Level4;

import java.util.ArrayDeque;
import java.util.LinkedList;

class MatricAndOperation {
    int rowCount, colCount; // 행과 열의 개수를 나타내는 변수
    ArrayDeque<Integer> col1, col2; // 왼쪽 열(col1)과 오른쪽 열(col2)을 나타내는 Deque
    LinkedList<ArrayDeque<Integer>> rows; // 중간 행들을 나타내는 LinkedList

    // 초기화 메서드
    private void initialize(int[][] rc) {
        rowCount = rc.length; // 행 개수 설정
        colCount = rc[0].length; // 열 개수 설정

        col1 = new ArrayDeque<>(); // col1 초기화
        col2 = new ArrayDeque<>(); // col2 초기화
        for (int i = 0; i < rowCount; i++) {
            col1.add(rc[i][0]); // col1에 왼쪽 열 값들을 추가
            col2.add(rc[i][colCount - 1]); // col2에 오른쪽 열 값들을 추가
        }

        rows = new LinkedList<>(); // 중간 행들을 담을 LinkedList 초기화
        for (int i = 0; i < rowCount; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>(); // 각 행의 값을 담을 임시 Deque
            for (int j = 1; j < colCount - 1; j++) {
                tmp.add(rc[i][j]); // 중간 열 값들을 임시 Deque에 추가
            }
            rows.add(tmp); // 임시 Deque를 rows에 추가
        }
    }

    // 결과 배열 반환 메서드
    private int[][] getAnswer() {
        int[][] answer = new int[rowCount][colCount]; // 결과 배열
        for (int i = 0; i < rowCount; i++) {
            answer[i][0] = col1.pollFirst(); // 첫 열 값들을 answer에 할당
            answer[i][colCount - 1] = col2.pollFirst(); // 마지막 열 값들을 answer에 할당
        }
        int i = 0;
        for (ArrayDeque<Integer> row : rows) {
            for (int j = 1; j < colCount - 1; j++) {
                answer[i][j] = row.pollFirst(); // 중간 열 값들을 answer에 할당
            }
            i++;
        }
        return answer; // 최종 결과 반환
    }

    // 회전 메서드
    private void rotate() {
        if (colCount == 2) {
            col2.addFirst(col1.pollFirst()); // col1의 첫 값은 col2의 첫 위치로 이동
            col1.addLast(col2.pollLast()); // col2의 마지막 값은 col1의 마지막 위치로 이동
            return;
        }
        rows.peekFirst().addFirst(col1.pollFirst()); // 첫 행의 첫 열 값은 col1의 첫 값으로 이동
        col2.addFirst(rows.peekFirst().pollLast()); // 첫 행의 마지막 열 값은 col2의 첫 위치로 이동
        rows.peekLast().addLast(col2.pollLast()); // 마지막 행의 마지막 열 값은 col2의 마지막 위치로 이동
        col1.addLast(rows.peekLast().pollFirst()); // 마지막 행의 첫 열 값은 col1의 마지막 위치로 이동
    }

    // 행 이동 메서드
    private void shiftRow() {
        rows.addFirst(rows.pollLast()); // 마지막 행을 첫 행 위치로 이동
        col1.addFirst(col1.pollLast()); // col1의 마지막 값은 첫 위치로 이동
        col2.addFirst(col2.pollLast()); // col2의 마지막 값은 첫 위치로 이동
    }

    // 문제 해결 메서드
    public int[][] solution(int[][] rc, String[] operations) {
        initialize(rc); // 초기화
        for (String operation : operations) {
            switch (operation.charAt(0)) {
                case 'R':
                    rotate(); // 회전
                    break;
                case 'S':
                    shiftRow(); // 행 이동
                    break;
            }
        }
        return getAnswer(); // 최종 결과 반환
    }
}