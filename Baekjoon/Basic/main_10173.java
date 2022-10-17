import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10173 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("EOI")) {
                break;
            }
            if (line.toLowerCase().matches(".*(nemo).*")) {
                System.out.println("Found");
            } else {
                System.out.println("Missing");
            }
        }
    }
}
