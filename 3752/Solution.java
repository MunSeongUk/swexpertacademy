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
import java.util.TreeSet;

public class Solution {
	public static StringBuilder sb = new StringBuilder();
	public static int T;
	public static int N;

	public static String[] token;
	public static int distribution[];
	public static boolean scores[];
	public static int count;
	public static int sum;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			sb.append("#").append(test_case).append(" ");
			
			N = Integer.valueOf(br.readLine());
			distribution = new int[N];
			count = 0;
			sum = 0;
			scores = new boolean[10001];
			token = br.readLine().split(" ");
			
			for (int i = 0; i < N; ++i) {
				distribution[i] = Integer.valueOf(token[i]);
			}
			
			scores[0] = true;
			
			// 구간 합
			for (int i = 0; i < N; ++i) {
				for (int j = sum; j >= 0; --j) {
					if (scores[j] == true) {
						scores[j + distribution[i]] = true;
					}
				}
				
				sum += distribution[i];
			}
			
			for (int i = 0; i < 10001; ++i) {
				if (scores[i] == true) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}
}