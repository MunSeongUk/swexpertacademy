import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {

    public static int[] dirY = { -1, 1, 0, 0 };
    public static int[] dirX = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

	
    public static class Location {
        public int y;
        public int x;
 
        public Location(int y, int x) {
        	super();
            this.y = y;
            this.x = x;
        }
    }
    
	public static Queue<Location> queue = new LinkedList<>();
	
    static class qComparator implements Comparator<Location> {
        @Override
        public int compare(Location o1, Location o2) {
            return o1.x * o1.y == o2.x * o2.y ? o1.y - o2.y : o1.x*o1.y-o2.x*o2.y;
        }
    }
    
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        
        int T = Integer.parseInt(br.readLine());
        int N;
        StringBuilder sb = new StringBuilder();
 
        for (int testCase = 1; testCase <= T; ++testCase) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 2][N + 2];
            visited = new boolean[N + 2][N + 2];
            
            for (int i = 1; i < N + 1; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < N + 1; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            ArrayList<Location> list = new ArrayList<>();
            int cnt = 0;
            
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (!visited[i][j] && map[i][j]!=0) {
                        visited[i][j]=true;
                        Location loc = bfs(i, j);
                        list.add(new Location(loc.y - i + 1, loc.x - j + 1));
                        cnt++;
                    }
                }
            }
            
            // al을 행렬의 크기(행*렬) 순으로 정렬, 같다면 행 기준으로 정렬
            Collections.sort(list, new qComparator());
            
            sb.append("#").append(testCase).append(' ').append(cnt).append(' ');
            
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).y).append(' ').append(list.get(i).x).append(' ');
            }
            
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
    
    private static Location bfs(int y, int x) {
    	queue.clear();
        int posX, posY;
        
    	queue.add(new Location(y, x));
    	Location loc = null;

        
        while(!queue.isEmpty()) {
        	loc = queue.poll();

            for (int i = 0; i < 4; i++) {
            	posY = loc.y + dirY[i];
            	posX = loc.x + dirX[i];
                if(!visited[posY][posX] && map[posY][posX] != 0) {
                    visited[posY][posX] = true;
                    queue.add(new Location(posY, posX));
                }
            }
        }
        
        return loc;
    }
     
} // end of class