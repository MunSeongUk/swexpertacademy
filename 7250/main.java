import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int moveDir[][] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static Tile map[][];
	public static Move move;
	
	public static Villain villain;
	public static Scott scott;
	public static Exit exit;

	public static int lapse;
	public static int answer;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("sample_input.txt"));
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			move = null;
			scott = null;
			villain = null;
			exit = null;
			answer = 0;
			lapse = 0;
			
			int height = sc.nextInt(); 
			int width = sc.nextInt(); 
			int duration = sc.nextInt();
			sc.nextLine();
			String line;
			
			map = new Tile[height + 2][width + 2];
			
			for (int i = 0; i < width + 2; ++i) {
				map[0][i] = new Tile(-1, 'X');
				map[height + 1][i] = new Tile(-1, 'X');
			}
			
			for (int i = 0; i < height + 2; ++i) {
				map[i][0] = new Tile(-1, 'X');
				map[i][width + 1] = new Tile(-1, 'X');
			}
			
			char cInput;
			Queue<Move> queue = new LinkedList<>();
			
			for (int i = 1; i <= height; ++i) {
				line = sc.nextLine();
				for (int j = 1; j <= width; ++j) {
					cInput = line.charAt(j - 1);
					if (cInput == 'S') {
						map[i][j] = new Tile(0, 'A');
						scott = new Scott(i, j, 0, duration);
					} else if (cInput == 'F') {
						queue.add(new Move(i, j));
						map[i][j] = new Tile(0, 'F');
					} else if (cInput == 'V') {
						map[i][j] = new Tile(0, 'A');
						villain = new Villain(i, j, 0);
					} else if (cInput == 'E') {
						map[i][j] = new Tile(0, 'A');
						exit = new Exit(i, j);
					} else if (cInput == 'W') {
						map[i][j] = new Tile(-1, 'W');
					} else if (cInput == 'A'){
						map[i][j] = new Tile(Integer.MAX_VALUE - 1, 'A');
					} else {
						map[i][j] = new Tile(-1, 'X');
					}
				}
			}
			
			int nextY, nextX;
			boolean isVisited[][] = new boolean[height + 2][width + 2];
			
			// 불을 번지게 함
			while (!queue.isEmpty()) {
				move = queue.poll();
				
				for (int i = 0; i < 4; ++i) {
					nextY = move.y + moveDir[i][0];
					nextX = move.x + moveDir[i][1];
					
					if (!isVisited[nextY][nextX] && map[nextY][nextX].type == 'A') {
						isVisited[nextY][nextX] = true;
						map[nextY][nextX].lapseOfFire = map[move.y][move.x].lapseOfFire + 1;
						queue.add(new Move(nextY, nextX));
					}
				}
			}

			// 악당을 움직임	
			isVisited = new boolean[height + 2][width + 2];
			
			if (villain != null) {
				isVisited = new boolean[height + 2][width + 2];
				Queue<Villain> vQueue = new LinkedList<>();
				vQueue.add(villain);
				isVisited[villain.y][villain.x] = true;
				
				while (!vQueue.isEmpty()) {
					villain = vQueue.poll();
					
					if (villain.y == exit.y && villain.x == exit.x) {
						break;
					}
					
					for (int i = 0; i < 4; ++i) {
						nextY = villain.y + moveDir[i][0];
						nextX = villain.x + moveDir[i][1];
						
						if (!isVisited[nextY][nextX] && (map[nextY][nextX].type == 'A' || map[nextY][nextX].type == 'F')) {
							Villain temp = new Villain(nextY, nextX, villain.step + 1);
							isVisited[nextY][nextX] = true;
							vQueue.add(temp);
						}
					}
				}
			}

			//스캇을 움직임
			boolean isVisitedByScott[][][] = new boolean[height + 2][width + 2][duration + 2];
			Queue<Scott> sQueue = new LinkedList<>();
			sQueue.add(scott);
			scott.duration++;
			isVisited[scott.y][scott.x] = true;
			
			while (!sQueue.isEmpty()) {
				scott = sQueue.poll();
			
				for (int i = 0; i < 4; ++i) {
					nextY = scott.y + moveDir[i][0];
					nextX = scott.x + moveDir[i][1];
					
					if (!isVisitedByScott[nextY][nextX][scott.duration] && map[nextY][nextX].type != 'X') {
						if (nextY == exit.y && nextX == exit.x) {
							scott.step++;
							sQueue.clear();
							break;
						} else if (map[nextY][nextX].type == 'A' && scott.step < map[nextY][nextX].lapseOfFire) {
							Scott temp = new Scott(nextY, nextX, scott.step + 1, duration + 1);
							isVisitedByScott[nextY][nextX][scott.duration] = true;
							sQueue.add(temp);
						} else if (map[nextY][nextX].type == 'W' && scott.duration >= 1) {
							Scott temp = new Scott(nextY, nextX, scott.step + 1, scott.duration - 1);
							isVisitedByScott[nextY][nextX][scott.duration] = true;
							sQueue.add(temp);
						} 
					}
				}
			}
			
			if (villain != null) {
				if (villain.step <= scott.step) {
					System.out.println("#" + test_case + " " + -1);
				} else {
					System.out.println("#" + test_case + " " + scott.step);
				}
			}
			else {
				System.out.println("#" + test_case + " " + scott.step);
			}
		}
		
		
		sc.close();
	}
}

class Tile {
	public int lapseOfFire;
	public char type;
	
	public Tile(int lapseOfFire, char type) {
		this.lapseOfFire = lapseOfFire;
		this.type = type;
	}

	@Override
	public String toString() {
		return "" + type;
	}
}

class Move {
	public int y;
	public int x;
	
	public Move(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class Exit {
	public int y, x;

	public Exit(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class Scott {
	public int y, x;
	public int step;
	public int duration;

	public Scott(int y, int x, int step, int duration) {
		this.y = y;
		this.x = x;
		this.step = step;
		this.duration = duration;
	}
}

class Villain {
	public int y, x;
	public int step;

	public Villain(int y, int x, int step) {
		this.y = y;
		this.x = x;
		this.step = step;
	}
}