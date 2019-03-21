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

public class Solution {
	public static int N;
	public static int worker[];
	public static double works[][];
	public static double max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.valueOf(br.readLine());
			max = Double.MIN_VALUE;
			works = new double[N][N];
			worker = new int[N];
			String[] token;
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				worker[i] = i;
				for (int j = 0; j < N; ++j) {
					works[i][j] = Double.valueOf(token[j]) * 0.01;
				}
			}
			
			permutation(0, 0, worker.length - 1, 100);
			
			System.out.printf("#%d %.6f\n", test_case, max);
		}
		
		br.close();
	}
	
	public static void permutation(int idx, int l, int r, double probability) {
		if (probability <= max) {
            return;
		}

		
		if (l == r) {
			probability *= works[idx][worker[l]];
			
			if (probability > max) {
				max = probability;
			}
			
			return;
		}
		
		for (int i = l; i <= r; ++i) {
			int tmp = worker[l];
			worker[l] = worker[i];
			worker[i] = tmp;
			
			permutation(idx + 1, l + 1, r, probability * works[idx][worker[l]]);
			
			tmp = worker[l];
			worker[l] = worker[i];
			worker[i] = tmp;
		}
	}
	
	public static void dfs(double arr[], int idx, double possibility) {
		if (idx == N) {
			if (max < possibility) {
				max = possibility;
			}
			
			return;
		}
		
		if (possibility == 0) {
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			if (i != idx) {
				dfs(arr, idx + 1, possibility * works[idx][i]);
			}
		}
	}
}