import java.util.*;

public class Task11ForestFireSpreadSimulator {
    static class Cell {
        int r, c, time;
        Cell(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] forest = new char[r][c];
        Queue<Cell> queue = new LinkedList<>();

        System.out.println("Enter forest grid:");
        System.out.println("F = fire, T = tree, . = empty");
        for (int i = 0; i < r; i++) {
            String row = sc.next();
            forest[i] = row.toCharArray();
            for (int j = 0; j < c; j++) {
                if (forest[i][j] == 'F') {
                    queue.offer(new Cell(i, j, 0));
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int maxTime = 0;
        int burnedTrees = 0;

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            maxTime = Math.max(maxTime, cur.time);

            for (int[] d : directions) {
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c
                        && forest[nr][nc] == 'T') {
                    forest[nr][nc] = 'F';
                    burnedTrees++;
                    queue.offer(new Cell(nr, nc, cur.time + 1));
                }
            }
        }

        System.out.println("Trees burned: " + burnedTrees);
        System.out.println("Spread time: " + maxTime);
    }
}
