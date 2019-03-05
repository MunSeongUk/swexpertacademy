import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());
		String sValue;
		int size = 'Z' - 'A' + 1;
		int N;
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.valueOf(br.readLine());
			char set[] = new char[size];
			
			for (int i = 0; i < N; ++i) {
				sValue = br.readLine();
				set[sValue.charAt(0) - 'A']++;
			}
			
			int res = 0;
			
			for (int i = 0; i < size; ++i) {
				if (set[i] == 0) {
					break;
				}
				res++;
			}
			
			System.out.println("#" + test_case + " " + res);
		}

		br.close();
	}
}
