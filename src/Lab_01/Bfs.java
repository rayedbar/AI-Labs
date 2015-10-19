/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_01;

import GraphBuilder.Graph;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author moham
 */
public class Bfs {

    private final Graph graph;
    private final int[][] color;
    private Point point;

    public Bfs(Graph graph) {
        this.graph = graph;
        color = new int[graph.dimenX][graph.dimenY];
    }

    public void start() {
        run();
        printPath();
    }

    private void run() {
        Point start = new Point(graph.startX, graph.startY, null);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (color[p.x][p.y] != 1) {
                System.out.println("robot at: " + "(" + p.x + "," + p.y + ")");
                if ((p.x == graph.homeX) && (p.y == graph.homeY)) {
                    System.out.println("Destination Reached!");
                    point = p;
                    break;
                }
                if (isAccessible(p.x - 1, p.y)) {
                    Point np = new Point(p.x - 1, p.y, p);
                    np.move = "Moved Up";
                    queue.add(np);
                }
                if (isAccessible(p.x + 1, p.y)) {
                    Point np = new Point(p.x + 1, p.y, p);
                    np.move = "Moved Down";
                    queue.add(np);
                }
                if (isAccessible(p.x, p.y - 1)) {
                    Point np = new Point(p.x, p.y - 1, p);
                    np.move = "Moved Left";
                    queue.add(np);
                }
                if (isAccessible(p.x, p.y + 1)) {
                    Point np = new Point(p.x, p.y + 1, p);
                    np.move = "Moved Right";
                    queue.add(np);
                }
                color[p.x][p.y] = 1;
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

    public void printTraversal() {
        for (int i = 0; i < color.length; ++i) {
            for (int j = 0; j < color[0].length; ++j) {
                System.out.print(color[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
