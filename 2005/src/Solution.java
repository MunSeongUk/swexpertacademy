import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int pascal[][] = new int[12][12];
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();

		
		System.out.println("#" + T);
		
		for (int k = 0; k < T; ++k) {
			int N = scanner.nextInt();
			
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= i; ++j) {
					if (j == i) {
						pascal[i][j] = 1;
						System.out.println("1");
					} else if (j == 1) {
						pascal[i][j] = 1;
						System.out.print("1 ");
					} else {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
						System.out.print(pascal[i][j] + " ");
					}
				}
					
			}
		}
		
	}

}
