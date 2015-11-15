/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayed Bin Wahed
 */
public class Main {

    /**
     * dimension of puzzle board
     */
    public static final int DIMENSION = 3;
    private static final Comparator<State> stateComparator = (State s1, State s2) -> {
        if(s1.f > s2.f)
            return 1;
        if(s1.f < s2.f)
            return -1;
        return 0;
    };
    
    private final int [][] initialState;
    private final PriorityQueue<State> stateQueue;
    
    private final int [][] finalState = {
        {1, 2, 3},
        {8, 0, 4},
        {7, 6, 5}
    };
    
    public Main(){
        initialState = new int [DIMENSION][DIMENSION];
        stateQueue = new PriorityQueue<>(stateComparator);
    }
    
    public static void main(String[] args) { 
        new Main().go();
    }

    private void go() {
        createInitialState();
        solve();
    }

    private void solve() {
        State startState = new State();
        startState.createState(initialState);
        startState.f = 3;
        stateQueue.add(startState);
        while(!stateQueue.isEmpty()){
            State currentState = stateQueue.remove();
            printState(currentState.state);
            if(checkSolution(currentState.state)) {
                break;
            }
            for(int i = 0; i < 3; ++i){
                for (int j = 0; j < 3; ++j){
                    if(currentState.state[i][j] == 0){
                        if(isAccessible(i, j - 1)){
                            State state = new State();
                            state.createState(currentState.state);
                            state.state[i][j] = currentState.state[i][j - 1];
                            state.state[i][j - 1] = 0;
                            state.f = calculateF(state.state);
                            stateQueue.add(state);
                        }
                        if(isAccessible(i, j + 1)){
                            State state = new State();
                            state.createState(currentState.state);
                            state.state[i][j] = currentState.state[i][j + 1];
                            state.state[i][j + 1] = 0;
                            state.f = calculateF(state.state);
                            stateQueue.add(state);
                        }
                        if(isAccessible(i - 1, j)){
                            State state = new State();
                            state.createState(currentState.state);
                            state.state[i][j] = currentState.state[i - 1][j];
                            state.state[i - 1][j] = 0;
                            state.f = calculateF(state.state);
                            stateQueue.add(state);
                        }
                        if(isAccessible(i + 1, j)){
                            State state = new State();
                            state.createState(currentState.state);
                            state.state[i][j] = currentState.state[i + 1][j];
                            state.state[i + 1][j] = 0;
                            state.f = calculateF(state.state);
                            stateQueue.add(state);
                        }
                    }
                }
            }
        }    
    }
    
    private void createInitialState() {
        File file = new File("C:\\Users\\moham\\Documents\\NetBeansProjects\\AI Labs\\src\\Lab_03\\input.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for(int i = 0; i < 3; ++i){
                String [] line = br.readLine().split(" ");
                for(int j = 0; j < 3; ++j){
                    initialState[i][j] = Integer.parseInt(line[j].trim());
                }
            }
            br.close();
        } catch (FileNotFoundException | NumberFormatException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int calculateF(int[][] state) {
        int count = 0;
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; j++){
                if (finalState[i][j] != state[i][j])
                    count++;
            }
        }
        return count;
    }
    
    private boolean checkSolution(int[][] state) {
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(state[i][j] != finalState[i][j])
                    return false;
            }
        }
        return true;
    }

    private boolean isAccessible(int i, int j) {
        return (i >= 0 && i < 3) && (j >= 0 && j < 3);
    }

    private void printState(int [][] grid) {
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
