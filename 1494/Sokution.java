import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static StringBuilder sb = new StringBuilder();
	public static int T;
	public static int N;
	public static int[][] worms;
	public static boolean isSelected[];

	public static String[] token;
	public static long scores[];
	public static int sizeOfScores = 0;
	public static long min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			sb.append("#").append(test_case).append(" ");

			N = Integer.parseInt(br.readLine());
			worms = new int[N][2];
			scores = new long[100000000];
			sizeOfScores = 0;
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				worms[i][0] = Integer.valueOf(token[0]);
				worms[i][1] = Integer.valueOf(token[1]);
			}

			isSelected = new boolean[worms.length];
			combinationUtil(worms.length, worms.length / 2, 0, 0);
			
			min = Long.MAX_VALUE;
			for (int i = 0; i < sizeOfScores; ++i) {
				if (scores[i] < min) {
					min = scores[i];
				}
			}
			sb.append(min).append('\n');
		}

		System.out.println(sb);
	}

	static void combinationUtil(int n, int r, int index, int i) {
		if (index == r) {
			long x = 0, y = 0;
			for (int j = 0; j < worms.length; ++j) {
				if (isSelected[j]) {
					x += worms[j][0];
					y += worms[j][1];
				} else {
					x -= worms[j][0];
					y -= worms[j][1];
				}
			}
			scores[sizeOfScores++] = x * x + y * y;
			
			return; 
		} 

		if (i >= n) { return; }

		isSelected[i] = true;
		combinationUtil(n, r, index+1, i + 1); 
		isSelected[i] = false;
		combinationUtil(n, r, index, i + 1); 
	} 
}