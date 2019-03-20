import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

interface Dir {
	public static int RIGHT = 0;
	public static int LEFT = 1;
	public static int UP = 2;
	public static int DOWN = 3;
}

public class Solution {
	public static int T;
	public static int R, C;
	
	public static int dir[][] = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
	public static Job curJob;
	
	public static char map[][];
	public static boolean isVisited[][][][];
	public static boolean isFinished;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			
			R = Integer.valueOf(token[0]);
			C = Integer.valueOf(token[1]);
			map = new char[R][C];
			isFinished = false;
			
			String line;
			
			for (int i = 0; i < R; ++i) {
				line = br.readLine();
				
				if (line.contains("@")) {
					isFinished = true;
				}
				map[i] = line.toCharArray();
			}
			
			if (!isFinished) {
				System.out.println("#" + test_case + " NO");
				continue;
			}
			
			Stack<Job> moves = new Stack<>();
			isVisited = new boolean[R][C][4][16];
			moves.add(new Job(0, 0, Dir.RIGHT, 0));
			
			int y, x, nextDir, nextMemory, nextY, nextX;
			isFinished = false;
			
			StackLoop: while(!moves.isEmpty()) {
				curJob = moves.pop();
				y = curJob.y;
				x = curJob.x;
				nextDir = curJob.dir;
				nextMemory = curJob.memory;
				
				if (isVisited[y][x][nextDir][nextMemory]) { continue; }
				isVisited[y][x][nextDir][nextMemory] = true;

				switch (map[y][x]) {
				case '@':
					isFinished = true;
					break StackLoop;
					
				case '<':
					nextDir = Dir.LEFT;
					break;
					
				case '>':
					nextDir = Dir.RIGHT;
					break;
					
				case '^':
					nextDir =  Dir.UP;
					break;
					
				case 'v':
					nextDir =  Dir.DOWN;
					break;	
					
				case '_':
					nextDir = nextMemory == 0 ? Dir.RIGHT : Dir.LEFT;
					break;
					
				case '|':
					nextDir = nextMemory == 0 ? Dir.DOWN : Dir.UP;
					break;
					
				case '+':
					nextMemory = nextMemory == 15 ? 0 : nextMemory + 1;
					break;
					
				case '-':
					nextMemory = nextMemory == 0 ? 15 : nextMemory - 1;
					break;
					
				case '.':
				case '?':
					break;
					
				default:
					nextMemory = map[y][x] - '0';
					break;
				}
				
				if (map[y][x] == '?') {
					for (int i = 0; i < 4; ++i) {
						nextY = y + dir[i][0];
						nextX = x + dir[i][1];
						nextY = nextY == R ? 0 : (nextY == -1 ? R - 1 : nextY);
						nextX = nextX == C ? 0 : (nextX == -1 ? C - 1 : nextX);
						
						Job nextJob = new Job(nextY, nextX, i, nextMemory);
						moves.push(nextJob);
					}
				} else {
					nextY = y + dir[nextDir][0];
					nextX = x + dir[nextDir][1];
					nextY = nextY == R ? 0 : (nextY == -1 ? R - 1 : nextY);
					nextX = nextX == C ? 0 : (nextX == -1 ? C - 1 : nextX);
					Job job = new Job(nextY, nextX, nextDir, nextMemory);
					moves.push(job);
				}
			}
			System.out.println("#" + test_case + " " + (isFinished ? "YES" : "NO"));
		}
		
		br.close();
	}
}

class Job {
	public int y, x, memory, dir;

	public Job(int y, int x, int dir, int memory) {
		this.y = y;
		this.x = x;
		this.memory = memory;
		this.dir = dir;
	}
}