/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_02;

/**
 *
 * @author moham
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().go();
    }

    private void go() {
        GraphBuilder.Graph graph = new GraphBuilder.Graph();
        graph.build("C:\\Users\\moham\\Documents\\NetBeansProjects\\AI Labs\\src\\Lab_02\\input.txt");
        AStar astar = new AStar(graph);
        astar.start();
    }
}
