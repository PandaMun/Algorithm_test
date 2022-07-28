import java.util.Arrays;

class NumberK {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int [] i : commands){
            int [] arr = new int [100];
            int idx = 0;
            for(int j = i[0]-1; j<i[1]; j++){
                arr[idx++] = array[j];
            }
            Arrays.sort(arr);
            answer[index++] = arr[i[2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array,commands));
    }
}