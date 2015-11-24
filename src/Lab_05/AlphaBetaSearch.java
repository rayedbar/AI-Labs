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
class AlphaBetaSearch {

    private int count;
    
    AlphaBetaSearch(State root) {
        alpha_beta_search(root);
    }

    private void alpha_beta_search(State root) {
        int v = max_value(root);
        System.out.println("MiniMax Value: " + v);
        System.out.println("Number of Comparisons: " + (count));
    }
    
    private int max_value(State node) {
        if (node.getChildren().isEmpty())
            return node.getData();
        int v = Integer.MIN_VALUE;
        for (int i = 0; i < node.getChildren().size(); ++i){
            v = Math.max(v, min_value(node.getChildren().get(i)));
            //count++;
        }
        return v;
    }

    private int min_value(State node) {
        if (node.getChildren().isEmpty())
            return node.getData();
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < node.getChildren().size(); ++i){
            v = Math.min(v, max_value(node.getChildren().get(i)));
            count++;
        }
        return v;
    }
    
}
