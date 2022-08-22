import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
    
    static int L;
    static int C;
    static String [] alphabet;
    static boolean [] visited;

    static void combination(int consonant, int vowel,int start){
        if(consonant + vowel == L){
            if(vowel >= 1 && consonant >= 2){
            for(int i = 0; i<C; i++){
                if(visited[i]){
                    System.out.print(alphabet[i]);
                }
            }
            System.out.println();
        
            return;
        }
    }
        else{
            for(int i = start; i<C; i++){
                if(!visited[i]){
                    visited[i] = true;
                    if (alphabet[i].equals("a") || alphabet[i].equals("e") || alphabet[i].equals("i") || alphabet[i].equals("o") || alphabet[i].equals("u")){
                                        
                                        combination(consonant, vowel+1,i+1);
                            }
                            else{
                                combination(consonant + 1, vowel, i+1);
                            }
                            visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        alphabet = new String[C];
        visited = new boolean[C];
        for(int i = 0; i<C; i++){
            alphabet[i] = st.nextToken();
            visited[i] = false;
        }
        Arrays.sort(alphabet);
        combination(0, 0,0);

    }
}
