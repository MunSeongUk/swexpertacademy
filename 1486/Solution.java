import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int B;
	public static int[] staff;
	public static int[] answer;
	public static int sizeOfAnswer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			N = Integer.valueOf(token[0]);
			B = Integer.valueOf(token[1]);
			
			staff = new int[N];
			answer = new int[1 << N];
			sizeOfAnswer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; st.hasMoreTokens(); ++i) {
				staff[i] = Integer.valueOf(st.nextToken());
			}
			
			dfs(0, 0);
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < sizeOfAnswer; ++i) {
				if (answer[i] < min) {
					min = answer[i];
				}
			}

			System.out.println("#" + test_case + " " + min);
		}
		
		br.close();
	}
	
	public static void dfs(int idx, int tall) {
		if (idx == N) {
			if (tall >= B) {
				answer[sizeOfAnswer++] = tall - B;
			}
			
			return;
		}
		
		dfs(idx + 1, tall + staff[idx]);
		dfs(idx + 1, tall);
	}
}