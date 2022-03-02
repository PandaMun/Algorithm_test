import java.util.*;

public class rulesofbignumber{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // 입력 객체 선언

        int n = sc.nextInt(); // 입력 객체 생성 및 공백을 구분하여 입력받기
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr =  new int[n]; //n의 크기만큼 배열 할당
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 입력받은 수 정렬
        int first = arr[n-1];
        int second = arr[n-2];
        
        // 가장 큰  수가 더해지는 횟수 계산
        int cnt = 
        
    }
}