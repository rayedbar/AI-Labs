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
class Bds {

    private final Graph graph;
    private final int[][] colorS, colorH;
    private Point pointS, pointH;

    Bds(Graph graph) {
        this.graph = graph;
        colorS = new int[graph.dimenX][graph.dimenY];
        colorH = new int[graph.dimenX][graph.dimenY];
        pointH = null;
        pointS = null;
    }

    void start() {
        run();
        printPath();
    }

    private void run() {
        Point start = new Point(graph.startX, graph.startY, null);
        Point home = new Point(graph.homeX, graph.homeY, null);
        Queue<Point> queueS = new LinkedList<>();
        queueS.add(start);
        Queue<Point> queueH = new LinkedList<>();
        queueH.add(home);
        while (!queueS.isEmpty() && !queueH.isEmpty()) {
            if (!queueS.isEmpty()) {
                Point p1 = queueS.remove();
                if (colorS[p1.x][p1.y] != 1) {
                    System.out.println("robotS at: " + "(" + p1.x + "," + p1.y + ")");
                    if ((p1 == home) || queueH.contains(p1)) {
                        pointS = p1;
                        while(true){
                            Point p = queueH.remove();
                            if (p.equals(p1)){
                                pointH = p;
                                break;
                            }
                        }
                        break;
                    }
                    if (isAccessibleS(p1.x - 1, p1.y)) {
                        Point np = new Point(p1.x - 1, p1.y, p1);
                        np.move = "Moved Up";
                        queueS.add(np);
                    }
                    if (isAccessibleS(p1.x + 1, p1.y)) {
                        Point np = new Point(p1.x + 1, p1.y, p1);
                        np.move = "Moved Down";
                        queueS.add(np);
                    }
                    if (isAccessibleS(p1.x, p1.y - 1)) {
                        Point np = new Point(p1.x, p1.y - 1, p1);
                        np.move = "Moved Left";
                        queueS.add(np);
                    }
                    if (isAccessibleS(p1.x, p1.y + 1)) {
                        Point np = new Point(p1.x, p1.y + 1, p1);
                        np.move = "Moved Right";
                        queueS.add(np);
                    }
                }
                colorS[p1.x][p1.y] = 1;
            }
            if (!queueH.isEmpty()) {
                Point p2 = queueH.remove();
                if (colorH[p2.x][p2.y] != 1) {
                    System.out.println("robotH at: " + "(" + p2.x + "," + p2.y + ")");
                    if ((p2 == start) || queueS.contains(p2)) {
                        pointH = p2;
                        while(true){
                            Point p = queueS.remove();
                            if (p.equals(p2)){
                                pointS = p;
                                break;
                            }
                        }
                        break;
                    }
                    if (isAccessibleH(p2.x - 1, p2.y)) {
                        Point np = new Point(p2.x - 1, p2.y, p2);
                        np.move = "Moved Down";
                        queueH.add(np);
                    }
                    if (isAccessibleH(p2.x + 1, p2.y)) {
                        Point np = new Point(p2.x + 1, p2.y, p2);
                        np.move = "Moved Up";
                        queueH.add(np);
                    }
                    if (isAccessibleH(p2.x, p2.y - 1)) {
                        Point np = new Point(p2.x, p2.y - 1, p2);
                        np.move = "Moved Right";
                        queueH.add(np);
                    }
                    if (isAccessibleH(p2.x, p2.y + 1)) {
                        Point np = new Point(p2.x, p2.y + 1, p2);
                        np.move = "Moved Left";
                        queueH.add(np);
                    }
                }
                colorH[p2.x][p2.y] = 1;
            }
        }
    }

    private boolean isAccessibleS(int x, int y) {
        return (x >= 0 && x < graph.dimenX) && (y >= 0 && y < graph.dimenY) && (colorS[x][y] != 1) && (graph.grid[x][y] == 1);
    }

    private boolean isAccessibleH(int x, int y) {
        return (x >= 0 && x < graph.dimenX) && (y >= 0 && y < graph.dimenY) && (colorH[x][y] != 1) && (graph.grid[x][y] == 1);
    }

    private void printPath() {
        if (pointS != null || pointH != null) {
            while (pointH.parent != null) {
                System.out.println(pointH.move);
                pointH = pointH.parent;
            }
            while (pointS.parent != null) {
                System.out.println(pointS.move);
                pointS = pointS.parent;
            }

        }
    }

}
