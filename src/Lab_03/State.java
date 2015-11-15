/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_03;

/**
 *
 * @author moham
 */
class State {

    public int [][] state;
    public int f;

    public State(){
        this.state = new int [HillClimb.DIMENSION][HillClimb.DIMENSION];
    }

    public void createState(int[][] state) {
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                this.state[i][j] = state[i][j];
    }
    
    
}
