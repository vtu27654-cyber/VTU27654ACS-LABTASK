import java.util.*;

public class Task13MuseumTreasureRoutePlanner {
    static class Cell {
        int r, c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] museum = new char[r][c];
        Cell start = null;
        Cell treasure = null;

        System.out.println("Grid: S=start, T=treasure, #=wall, .=path");
        for (int i = 0; i < r; i++) {
            String row = sc.next();
            museum[i] = row.toCharArray();

            for (int j = 0; j < c; j++) {
                if (museum[i][j] == 'S') start = new Cell(i, j);
                if (museum[i][j] == 'T') treasure = new Cell(i, j);
            }
        }

        int[][] dist = new int[r][c];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(start);
        dist[start.r][start.c] = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();

            for (int[] d : dirs) {
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c
                        && museum[nr][nc] != '#'
                        && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur.r][cur.c] + 1;
                    queue.offer(new Cell(nr, nc));
                }
            }
        }

        if (treasure == null || dist[treasure.r][treasure.c] == -1)
            System.out.println("Treasure is unreachable.");
        else
            System.out.println("Shortest route length: "
                    + dist[treasure.r][treasure.c]);
    }
}
