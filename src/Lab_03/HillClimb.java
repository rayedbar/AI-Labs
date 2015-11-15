package Lab_03;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Rayed Bin Wahed 12201114 CSE422
 */
public class HillClimb {

    public static final int DIMENSION = 3;

    private final int[][] solution;
    private final int[][] problem;

    public HillClimb() {
        this.solution = new int[][]{
            {1, 2, 3,},
            {8, 0, 4},
            {7, 6, 5}
        };
        this.problem = new int[][]{
            {1, 2, 3,},
            {7, 0, 4},
            {6, 8, 5}
        };
    }

    public void start() {
        System.out.println("Initial State:");
        printState(problem);
        State start = hillclimbing(problem);
        while (true) {
            if (start.f == 0) {
                printState(start.state);
                break;
            } else {
                start = generateRandom(start.state);
                start = hillclimbing(start.state);
            }
        }
    }

    private State hillclimbing(int[][] problem) {
        State current, next;
        current = new State();
        current.createState(problem);
        current.f = calculateF(current.state);
        //printState(current.state);
        do {
//            if (current.f == 0) {
//                System.out.println("solution found");
//                printState(current.state);
//                return current;
//            }
            next = bestNeighbor(current);
            if (next.f < current.f) {
                //System.out.println("Better solution");
                printState(next.state);
                current = next;
            } else {
                System.out.println("Local Maxima: Shuffle");
                printState(current.state);
                return current;
            }
        } while (true);
    }

    private int calculateF(int[][] state) {
        int count = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; j++) {
                if (solution[i][j] != state[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void printState(int[][] grid) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private State bestNeighbor(State current) {
        PriorityQueue<State> pq = new PriorityQueue<>(new StateComparator());
        for (int i = 0; i < DIMENSION; ++i) {
            for (int j = 0; j < DIMENSION; ++j) {
                if (current.state[i][j] == 0) {
                    if (isAccessible(i, j - 1)) {
                        State state = new State();
                        state.createState(current.state);
                        state.state[i][j] = current.state[i][j - 1];
                        state.state[i][j - 1] = 0;
                        state.f = calculateF(state.state);
                        pq.add(state);
                    }
                    if (isAccessible(i, j + 1)) {
                        State state = new State();
                        state.createState(current.state);
                        state.state[i][j] = current.state[i][j + 1];
                        state.state[i][j + 1] = 0;
                        state.f = calculateF(state.state);
                        pq.add(state);
                    }
                    if (isAccessible(i - 1, j)) {
                        State state = new State();
                        state.createState(current.state);
                        state.state[i][j] = current.state[i - 1][j];
                        state.state[i - 1][j] = 0;
                        state.f = calculateF(state.state);
                        pq.add(state);
                    }
                    if (isAccessible(i + 1, j)) {
                        State state = new State();
                        state.createState(current.state);
                        state.state[i][j] = current.state[i + 1][j];
                        state.state[i + 1][j] = 0;
                        state.f = calculateF(state.state);
                        pq.add(state);
                    }
                }
            }
        }
        return pq.remove();
    }

    private boolean isAccessible(int i, int j) {
        return (i >= 0 && i < 3) && (j >= 0 && j < 3);
    }

    private State generateRandom(int[][] state) {
        boolean[] temp;
        temp = new boolean[9];
        int[][] grid = new int[DIMENSION][DIMENSION];
        int random;
        for (int i = 0; i < DIMENSION; ++i) {
            for (int j = 0; j < DIMENSION; ++j) {
                random = (int) (Math.random() * 9);
                while (temp[random]) {
                    random = (int) (Math.random() * 9);
                }
                temp[random] = true;
                grid[i][j] = random;
            }
        }
        State s = new State();
        s.createState(grid);
        return s;
    }

    private static class StateComparator implements Comparator<State> {

        public StateComparator() {
        }

        @Override
        public int compare(State o1, State o2) {
            if (o1.f > o2.f) {
                return 1;
            }
            if (o1.f < o2.f) {
                return -1;
            }
            return 0;
        }

    }

}
