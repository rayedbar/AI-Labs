/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_05;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moham
 */
public class State {
    
    private int data;
    private List<State> children;
    
    public State(){
        children = new ArrayList<>();
    }
    
    public State(int data){
        this(); 
        this.data = data;
    }
    
    
    public void addChild(State n) {
        getChildren().add(n);
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the children
     */
    public List<State> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<State> children) {
        this.children = children;
    }
    
}
