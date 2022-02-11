import java.util.Scanner;

public class PrimeNumber {
	
	// public static boolean isPrimeNumber(int num) {
	// 		for(int i = 2; i<=(int)Math.sqrt(num); i++){
	// 				if(num % i == 0){
	// 						return false;
	// 					}
	// 			}
	// 		return true;
	// 	}
	// public static void main(String[] args){
	// 	Scanner sc = new Scanner(System.in);
	// 	int num = sc.nextInt();
	// 	if(isPrimeNumber(num)){
	// 			System.out.println(num + " is PrimeNumber");
	// 		}
	// 	else{
	// 			System.out.println(num + " isn't PrimeNumber");
	// 		}
	// }
        
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int range = sc.nextInt();
            int result = 0;
            int [] arr = new int[range+1];
            for(int i = 2; i<=range; i++){
                if(arr[i] == 0){
                    result++;
                }
                for(int j = 2 * i; j <= range; j += i){
                    arr[j] = 1;
                }
            }
        System.out.println("소수의 개수는 " + result);
    }
}
            


        
