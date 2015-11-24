package Lab_05;


/**
 * @author Md. Rayed Bin Wahed
 */
public class Main {

    public static void main(String[] args) {

        State root = new State(-1);

        State n1 = new State(0);
        State n2 = new State(0);
        State n3 = new State(0);

        n1.addChild(new State(3));
        n1.addChild(new State(12));
        n1.addChild(new State(8));

        n2.addChild(new State(2));
        n2.addChild(new State(4));
        n2.addChild(new State(6));

        n3.addChild(new State(14));
        n3.addChild(new State(5));
        n3.addChild(new State(2));

        root.addChild(n1);
        root.addChild(n2);
        root.addChild(n3);

        System.out.println("Alpha Beta Search: ");
        AlphaBetaSearch search = new AlphaBetaSearch(root);
        
        System.out.println("");
        System.out.println("*************************");
        System.out.println("");
        
        System.out.println("Alpha Beta Pruning: ");
        AlphaBetaPruning prunig = new AlphaBetaPruning(root);
    }

}
