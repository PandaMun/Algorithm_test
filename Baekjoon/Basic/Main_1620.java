import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int monsterCount = Integer.parseInt(st.nextToken());
        int quest = Integer.parseInt(st.nextToken());
        Map<String, String> book = new HashMap<>();
        for (int i = 0; i < monsterCount; i++) {
            st = new StringTokenizer(br.readLine());
            String pocketmon = st.nextToken();
            book.put(pocketmon, Integer.toString(i + 1));
            book.put(Integer.toString(i + 1), pocketmon);
        }
        for (int i = 0; i < quest; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(book.get(st.nextToken()));
        }
    }
}
