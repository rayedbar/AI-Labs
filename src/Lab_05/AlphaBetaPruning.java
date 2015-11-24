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

    private int count;
    
    AlphaBetaPruning(State root) {
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
            v = Math.max(v, min_value(node.getChildren().get(i), alpha, beta)); 
            if (v >= beta){
                count++;
                System.out.println("Pruned Here: " + v);
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    private int min_value(State node, int alpha, int beta) {
        if (node.getChildren().isEmpty())
            return node.getData();
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < node.getChildren().size(); ++i){
            v = Math.min(v, max_value(node.getChildren().get(i), alpha, beta)); 
            if (v <= alpha){
                count++;
                System.out.println("Pruned Here: " + v);
                return v;
            } 
            beta = Math.min(beta, v);
        }
        return v;
    }

    
    
}
