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
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			
			int N = Integer.valueOf(token[0]);
			long M = Integer.valueOf(token[1]);
			long spend[] = new long[N];

			for (int i = 0; i < N; ++i) {
				spend[i] = Integer.valueOf(br.readLine());
			}
			
			Arrays.sort(spend);
			
			long minTime = 0;
			long maxTime = spend[spend.length - 1] * M;
			long answer = Long.MAX_VALUE;
			
			while (minTime <= maxTime) {
				long midTime = (minTime + maxTime) / 2;
				long count = 0;
				
				for (int i = 0; i < N; ++i) {
					count += (midTime / spend[i]);
				}
				
				if (count < M) {
					minTime = midTime + 1;
				} else {
					if (answer > midTime) {
						answer = midTime;
					}
					
					maxTime = midTime - 1;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		br.close();
	}
}