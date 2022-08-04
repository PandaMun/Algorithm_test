import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution_1218{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc < 11; tc++){
        int cnt = Integer.parseInt(br.readLine());
        String a = br.readLine();
        List<Character> bracket = new ArrayList<>();
        boolean result = true;
        for(int i = 0; i < cnt; i++){
            if(a.charAt(i) == '{' || a.charAt(i) == '[' || a.charAt(i) == '('|| a.charAt(i) == '<' ) {
                bracket.add(a.charAt(i));
            }
            else {
                if (bracket.get(bracket.size()-1) == '{' && a.charAt(i) == '}'){
                    bracket.remove(bracket.size()-1);
                }
                else if (bracket.get(bracket.size()-1) == '[' && a.charAt(i) == ']'){
                    bracket.remove(bracket.size()-1);
                }
                else if (bracket.get(bracket.size()-1) == '(' && a.charAt(i) == ')'){
                    bracket.remove(bracket.size()-1);
                }
                else if (bracket.get(bracket.size()-1) == '<' && a.charAt(i) == '>'){
                    bracket.remove(bracket.size()-1);
                }
                else{
                    result = false;
                    break;
                }
            }
            
        }
        for(char j : bracket){
            System.out.println(j);
        }
        if(result){
            System.out.println("#" + String.valueOf(tc) + " " + String.valueOf(1));
        }
        else{
            System.out.println("#" + String.valueOf(tc) + " " + String.valueOf(0));
        }
    }
    
}
}