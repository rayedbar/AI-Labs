/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_05;

/**
 *
 * @author moham
 */
class AlphaBetaPruning {

    private final State root;
    private int count;
    
    AlphaBetaPruning(State root) {
        this.root = root;
        this.count = 0;
        alpha_beta_pruning(root);
    }

    private void alpha_beta_pruning(State root) {
        int v = max_value(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("MiniMax Value: " + v);
        System.out.println("Number of Comparisons: " + (9 - count));
    }

    private int max_value(State node, int alpha, int beta) {
        if (node.getChildren().isEmpty())
            return node.getData();
        int v = Integer.MIN_VALUE;
        for (int i = 0; i < node.getChildren().size(); ++i){
            int min = min_value(node.getChildren().get(i), alpha, beta);
            v = Math.max(v, min);
            //v = Math.max(v, min_value(node.getChildren().get(i), alpha, beta)); 
            //System.out.println("min = " + min);
            if (v >= beta){
                count++;
                System.out.println("Pruned Here: " + v);
                return v;
            }
            alpha = Math.max(alpha, v);
            System.out.println(alpha);
        }
        return v;
    }

    private int min_value(State node, int alpha, int beta) {
        if (node.getChildren().isEmpty())
            return node.getData();
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < node.getChildren().size(); ++i){
            int max = max_value(node.getChildren().get(i), alpha, beta);
            v = Math.min(v, max);
            System.out.println("max = " + max);
            //v = Math.min(v, max_value(node.getChildren().get(i), alpha, beta)); 
            if (v <= alpha){
                System.out.println("alpha: " + alpha + "; beta:" + beta);
                count++;
                //System.out.println("Value of v: " + v + ". Alpha value: " + alpha + ". Pruned Here!");
                return v;
            }
            System.out.println(beta);
            beta = Math.min(beta, v);
            
        }
        return v;
    }

    
    
}
