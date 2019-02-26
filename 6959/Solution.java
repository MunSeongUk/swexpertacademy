import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringBuilder sb = new StringBuilder(br.readLine());
			int a, b;
			int step = 1;
			
			while (sb.length() != 1) {
				a = sb.charAt(0) - '0';
				sb.delete(0, 1);
				b = sb.charAt(0) - '0';
				sb.delete(0, 1);
				sb.append(a + b);
				step++;
			}
			
			if ((step & 1) == 1) {
				System.out.println("#" + test_case + " B");
			} else {
				System.out.println("#" + test_case + " A");
			}
			
		}
		
		br.close();
	}
}

