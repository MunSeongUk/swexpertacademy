import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			int N = Integer.valueOf(token[0]);
			int MAX_CALORIE = Integer.valueOf(token[1]);
			
			//0: 맛에 대한 점수, 1: 칼로리
			int[][] hamburger = new int[N][2];
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				hamburger[i][0] = Integer.valueOf(token[0]);
				hamburger[i][1] = Integer.valueOf(token[1]);
			}
			
			int powersetSize = 1 << N;
	        int[][] combi = new int[powersetSize][2];
	        int sizeOfCombi = 0;
			
	        //햄버거 조합의 모든 경우의 수를 검색
			for (int i = 0; i < N; ++i) {
				int curSize = sizeOfCombi;
				for (int j = 0; j < curSize; ++j) {
					//만약 칼로리가 MAX를 넘을 경우 고려하지 않음
					if (combi[j][1] + hamburger[i][1] <= MAX_CALORIE) {
						combi[sizeOfCombi][0] += combi[j][0] + hamburger[i][0];
						combi[sizeOfCombi++][1] += combi[j][1] + hamburger[i][1];
					}
				}
				combi[sizeOfCombi][0] = hamburger[i][0];
				combi[sizeOfCombi++][1] = hamburger[i][1];
			}
			
			int max = 1;
			for (int i = 0; i < sizeOfCombi; ++i) {
				if (max < combi[i][0]) {
					max = combi[i][0];
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
		
		br.close();
	}
}