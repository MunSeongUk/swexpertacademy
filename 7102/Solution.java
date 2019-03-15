import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("sample_input.txt"));
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if (N > M) {
				int tmp = N;
				N = M;
				M = tmp;
			}
			
			int answer[] = new int[1 + M - N];
			answer[0] = N + 1;
			
			for (int i = 1; i <= M - N; ++i) {
				answer[i] = answer[i - 1] + 1;
			}
			
			System.out.print("#" + test_case + " ");
			
			for (int i = 0; i < answer.length; ++i) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}