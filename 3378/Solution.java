import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public static int lineOfMaster;
	public static int lineOfMe;
	public static char[][] codeOfMaster;
	public static char[][] codeOfMe;
	public static int[] brackets;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		
		int T = Integer.valueOf(br.readLine());
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			lineOfMaster = Integer.valueOf(token[0]);
			lineOfMe = Integer.valueOf(token[1]);
			
			codeOfMaster = new char[lineOfMaster][];
			codeOfMe = new char[lineOfMe][];
			
			for (int i = 0; i < lineOfMaster; ++i) {
				codeOfMaster[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < lineOfMe; ++i) {
				codeOfMe[i] = br.readLine().toCharArray();
			}

			
			brackets = new int[lineOfMe];
			Arrays.fill(brackets, -9);
			
//			R => ( , ), C => { , } S => [ , ]의  공백 처리 갯수
//			1 ≤ R, C, S ≤ 20을 만족하는 세 정수 R, C, S
//			범위의 모든 R,C,S를 조합해보면서 마스터의 라인코드가 가능한지 체크후 가능하다면 내 라인코드에 인덴트 처리
			for(int r = 1; r <= 20; r++) {
				for(int c = 1; c <= 20; c++) {
					for(int s = 1; s <= 20; s++) {
//						마스터문자열 판단해서 나온 r,c,s값으로 user 문자열 공백 문자열 칸수 구하기
						if(isAvailable(r,c,s)) {
							solve(r,c,s);
						}
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			
			for (int cnt : brackets) {
				System.out.print(cnt + " ");
			}
			
			System.out.println();
		}
		
		br.close();
	}
	
	public static boolean isAvailable(int r, int c, int s) {
		int indent = 0;
		int rCnt = 0, cCnt = 0, sCnt = 0;
		int cnt = 0;
		
		for (int i = 0; i < lineOfMaster; ++i) {
			cnt = 0;
			
			for (char ch : codeOfMaster[i]) {
				if (ch != '.') { break; }
				
				cnt++;
			}
			
			indent = r * rCnt + c * cCnt + s * sCnt;
			
			if (cnt != indent) {
				return false;
			}
			
			for(char ch : codeOfMaster[i]) {
				switch(ch) {
				case '(' :
					rCnt++;
					break;
					
				case ')' :
					rCnt--;
					break;
					
				case '{' :
					cCnt++;
					break;
					
				case '}' :
					cCnt--;
					break;
					
				case '[' :
					sCnt++;
					break;
					
				case ']' :
					sCnt--;
					break;
				}
			}	
		}
		
		return true;
	}
	
	public static void solve(int r, int c, int s) {
		int intent = 0;
		int rCnt = 0, cCnt = 0,sCnt = 0;
		int cnt = 0;
		
		for(int i = 0; i < lineOfMe; i++) {
			if(brackets[i] == -9) {  // 해당 라인 들여쓰기 계산이 처음이면
				brackets[i] = r * rCnt + c * cCnt + s * sCnt;
			}else {
				if(brackets[i] != r * rCnt + c * cCnt + s * sCnt) {
					brackets[i] = -1;
				}
			}
//			사용자의 R,C,S의 문자열 갯수 세기
			for(char ch : codeOfMe[i]) {
				switch(ch) {
				case '(' :
					rCnt++;
					break;
				case ')' :
					rCnt--;
					break;
				case '{' :
					cCnt++;
					break;
				case '}' :
					cCnt--;
					break;
				case '[' :
					sCnt++;
					break;
				case ']' :
					sCnt--;
					break;
				}
			}
		}
	}
}
