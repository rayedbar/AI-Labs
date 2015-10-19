/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_01;

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
        graph.build("C:\\Users\\moham\\Documents\\NetBeansProjects\\AI Labs\\src\\Lab_01\\input.txt");
//        Bfs bfs = new Bfs(graph);
//        bfs.start();
//        System.out.println("");
//        System.out.println("********************************");
//        System.out.println("");
        Dfs dfs = new Dfs(graph);
        dfs.start();
        System.out.println("");
        System.out.println("********************************");
        System.out.println("");
        Dls dls = new Dls(graph);
        dls.start();
//        System.out.println("");
//        System.out.println("********************************");
//        System.out.println("");
//        Ids ids = new Ids(graph);
//        ids.start();
//        System.out.println("");
//        System.out.println("********************************");
//        System.out.println("");
//        Bds bds = new Bds(graph);
//        bds.start();
    }
   
}
