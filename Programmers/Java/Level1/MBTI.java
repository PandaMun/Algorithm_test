package Level1;

import java.util.HashMap;

public class MBTI {
	static int [] scores1 = {0,1,2,3};
	static int [] scores2 = {3,2,1};
	static char [][] mbti = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
	static HashMap<Character,Integer> map = new HashMap<>();
    
	public static String solution(String[] survey, int[] choices) {
		char [] answer = new char[4];
        for(int i = 0; i<4; i++) {
        	map.put(mbti[i][0], 0);
        	map.put(mbti[i][1], 0);
        }
        for(int i = 0; i< choices.length; i++) {
        	int score = choices[i] - 1;
        	if(score > 3) {
        		map.put(survey[i].charAt(1), (map.get(survey[i].charAt(1)) + scores1[(score - 3)]));
        	}
        	else if(score < 3) {
        		map.put(survey[i].charAt(0), (map.get(survey[i].charAt(0)) + scores2[(score)]));
        	}
        }
        for(int i = 0; i<4; i++) {
        	if(map.get(mbti[i][0]) >= map.get(mbti[i][1])){
        		answer[i] = (mbti[i][0]);
        	}
        	else {
        		answer[i] = mbti[i][1];
        	}
        }
        return String.valueOf(answer);
    }
    public static void main(String[] args){
        String [] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int [] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }
}