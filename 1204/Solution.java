import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br 	= new BufferedReader(new FileReader("input.txt"));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = Integer.valueOf(br.readLine());
			String[] token = br.readLine().split(" ");
			int[] rank = new int[101];
			
			for (int i = 0; i < token.length; ++i) {
				rank[Integer.valueOf(token[i])]++;
			}
			
			int max = 1, maxIdx = 0;
			
			for (int i = 0; i < 101; ++i) {
				if (max < rank[i]) {
					max = rank[i];
					maxIdx = i;
				}
			}
			
			int[] arr = new int[101];
			int sizeOfArr = 0;
			
			for (int i = 0; i < 101; ++i) {
				if (rank[i] == rank[maxIdx]) {
					arr[sizeOfArr++] = i;					
				}
			}
			
			max = 1;
			
			for (int i = 0; i < sizeOfArr; ++i) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			
			System.out.println("#" + N + " " + max);
		}
		
		br.close();
	}
}