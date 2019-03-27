import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			token = br.readLine().split(" ");
			int[] tickets = new int[4];
			
			for (int i = 0; i < 4; ++i) {
				tickets[i] = Integer.valueOf(token[i]);
			}
			
			token = br.readLine().split(" ");
			int[] plans = new int[13];
			
			for (int i = 0; i < 12; ++i) {
				plans[i + 1] = Integer.valueOf(token[i]);
			}
			
			int[] price = new int[16];
			
			for (int month = 1; month <= 12; ++month) {
				price[month] = Math.min(plans[month] * tickets[0], tickets[1]);
			}
			
			for (int i = 12; i >= 1; --i) {
				price[i] = Math.min(price[i] + price[i + 1], tickets[2] + price[i + 3]);
			}

			if (price[1] > tickets[3]) {
				price[1] = tickets[3];
			}
			
			System.out.println("#" + test_case + " " + price[1]);
		}
		
		br.close();
	}
}