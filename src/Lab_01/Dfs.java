/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_01;

import GraphBuilder.Graph;

/**
 *
 * @author moham
 */
public class Dfs {

    private final Graph graph;
    private final int[][] color;
    private Point point;

    Dfs(Graph graph) {
        this.graph = graph;
        color = new int[graph.dimenX][graph.dimenY];
    }

    void start() {
        run();
        printPath();
    }

    private void run() {
        Point start = new Point(graph.startX, graph.startY, null);
        System.out.println("robot at: " + "(" + start.x + "," + start.y + ")");
        color[start.x][start.y] = 1;
        if (isAccessible(start.x - 1, start.y)) {
            Point p = new Point(start.x - 1, start.y, start);
            p.move = "Moved Up";
            dfs(p);
        }
        
        if (isAccessible(start.x, start.y - 1)) {
            Point p = new Point(start.x, start.y - 1, start);
            p.move = "Moved Left";
            dfs(p);
        }
        if (isAccessible(start.x + 1, start.y)) {
            Point p = new Point(start.x + 1, start.y, start);
            p.move = "Moved Down";
            dfs(p);
        }
        if (isAccessible(start.x, start.y + 1)) {
            Point p = new Point(start.x, start.y + 1, start);
            p.move = "Moved Right";
            dfs(p);
        }
    }

    private void dfs(Point p) {
        if ((color[p.x][p.y] != 1)) {
            System.out.println("robot at: " + "(" + p.x + "," + p.y + ")");
            color[p.x][p.y] = 1;
            if ((p.x == graph.homeX) && (p.y == graph.homeY)) {
                System.out.println("Destination Reached!");
                point = p;
            }
            if (isAccessible(p.x - 1, p.y)) {
                Point np = new Point(p.x - 1, p.y, p);
                np.move = "Moved Up";
                dfs(np);
            }
            if (isAccessible(p.x + 1, p.y)) {
                Point np = new Point(p.x + 1, p.y, p);
                np.move = "Moved Down";
                dfs(np);
            }
            if (isAccessible(p.x, p.y - 1)) {
                Point np = new Point(p.x, p.y - 1, p);
                np.move = "Moved Left";
                dfs(np);
            }
            if (isAccessible(p.x, p.y + 1)) {
                Point np = new Point(p.x, p.y + 1, p);
                np.move = "Moved Right";
                dfs(np);
            }
        }
    }

    private boolean isAccessible(int x, int y) {
        return (x >= 0 && x < graph.dimenX) && (y >= 0 && y < graph.dimenY) && (color[x][y] != 1) && (graph.grid[x][y] == 1);
    }

    private void printPath() {
        while (point.parent != null && point != null) {
            System.out.println(point.move);
            point = point.parent;
        }
        System.out.println("Caution: Read path bottom up");

    }

}
