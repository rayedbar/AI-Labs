 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_02;

import GraphBuilder.Graph;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author moham
 */
public class AStar {

    private final Graph graph;
    private final PriorityQueue<Point> open;
    private Point point;

    AStar(Graph graph) {
        this.graph = graph;
        open = new PriorityQueue<>(pointComparator);
    }

    void start() {
        run();
        printPath();
    }

    private void run() {
        Point start = new Point(graph.startX, graph.startY, null);
        open.add(start);
        while (!open.isEmpty()) {
            Point p = open.remove();
            System.out.println("robot at: " + "(" + p.x + "," + p.y + ")");
            if ((p.x == graph.homeX) && (p.y == graph.homeY)) {
                System.out.println("Destination Reached!");
                point = p;
                break;
            }
            if (isAccessible(p.x + 1, p.y)) {
                Point np = new Point(p.x + 1, p.y, p);
                np.move = "Moved Down";
                np.g = p.g + 1;
                np.h = calculateH(np);
                np.f = np.g + np.h;
                open.add(np);
            }
            if (isAccessible(p.x - 1, p.y)) {
                Point np = new Point(p.x - 1, p.y, p);
                np.move = "Moved Up";
                np.g = p.g + 1;
                np.h = calculateH(np);
                np.f = np.g + np.h;
                open.add(np);
            }
            if (isAccessible(p.x, p.y + 1)) {
                Point np = new Point(p.x, p.y + 1, p);
                np.move = "Moved Right";
                np.g = p.g + 1;
                np.h = calculateH(np);
                np.f = np.g + np.h;
                open.add(np);
            }
            if (isAccessible(p.x, p.y - 1)) {
                Point np = new Point(p.x, p.y - 1, p);
                np.move = "Moved Left";
                np.g = p.g + 1;
                np.h = calculateH(np);
                np.f = np.g + np.h;
                open.add(np);
            }
        }
    }

    private boolean isAccessible(int x, int y) {
        return (x >= 0 && x < graph.dimenX) && (y >= 0 && y < graph.dimenY) && (graph.grid[x][y] == 1);
    }

    private int calculateH(Point np) {
        int dx = Math.abs(np.x - graph.homeX);
        int dy = Math.abs(np.y - graph.homeY);
        return dx + dy;
    }

    private void printPath() {
        while (point.parent != null && point != null) {
            System.out.println(point.move);
            point = point.parent;
        }
        System.out.println("Caution: Read path bottom up");
    }

    private static final Comparator<Point> pointComparator = (Point p1, Point p2) -> {
        if (p1.f > p2.f) {
            return 1;
        }
        if (p1.f < p2.f) {
            return -1;
        }
        return 0;
    };
    
}
