import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
	public static int T;
	public static int N;
	public static int M;
	public static String[] token;
	
	public static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		T = Integer.valueOf(br.readLine().trim());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.valueOf(br.readLine().trim());
			M = Integer.valueOf(br.readLine().trim());
			
			map = new boolean[N + 1][N + 1];
			
			for (int i = 0; i < M; ++i) {
				token = br.readLine().trim().split(" ");
				map[Integer.valueOf(token[0])][Integer.valueOf(token[1])] = true;
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; ++i) {
				int step = 0;
				boolean[] isVisited = new boolean[N + 1];
				
//				for (int j = 1; j <= N; ++j) {
//					if (i == j) { continue; }
//					
//					if(map[i][j]) {
//						step++;
//						isVisited[j] = true;
//					}
//				}


				Stack<Integer> stack = new Stack<>();
				stack.push(i);
				isVisited[i] = true;
				
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					step++;
					
					for (int j = 1; j <= N; ++j) {
						if(!isVisited[j] && map[cur][j]) {
							isVisited[j] = true;
							stack.push(j);
						}
					}
				}
				
				stack.push(i);
				step--;
				
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					step++;
					
					for (int j = 1; j <= N; ++j) {
						if(!isVisited[j] && map[j][cur]) {
							isVisited[j] = true;
							stack.push(j);
						}
					}
				}
				
				if (N - step == 0) {
					answer++;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		br.close();
	}
}