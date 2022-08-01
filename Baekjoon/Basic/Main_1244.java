package com.ssafy.algorithm.OnOffSwitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_문태호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int [] status = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			status[i] = Integer.parseInt(st.nextToken());
		}
		int studentCount = Integer.parseInt(br.readLine());
		for(int i = 0; i< studentCount; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int button = Integer.parseInt(st.nextToken());
			if (gender == 1) { //남성일때
				for(int j = 1; j <= N; j++) {
					if(j % button == 0) {
						if (status[j-1] == 1) {
							status[j-1] = 0;
						}else{
							status[j-1] = 1;
						}
					}
				}
			}else { // 여성일때
				if (status[button-1] == 1) {
					status[button-1] = 0;
				}else{
					status[button-1] = 1;
				}
				for(int j = 1; j<Integer.min(N-button+1,button); j++) {
					if (status[button-j-1] == status[button + j-1]) {
						if(status[button-j-1] == 1) {
							status[button-j-1] = 0;
							status[button+j-1] = 0;
						}else {
							status[button-j-1] = 1;
							status[button+j-1] = 1;
						}
					}else {
						break;
					}
				}
			}
		}
		for(int i = 0; i < status.length + 1; i++) {
			if(i % 20 == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(status[i] + " ");
		}
		
	}
}
