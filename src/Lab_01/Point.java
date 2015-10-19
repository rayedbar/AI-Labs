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
public class Point {
    
    public int x, y;
    public Point parent;
    public String move;
    
    public Point(int x, int y, Point parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.x;
        hash = 17 * hash + this.y;
        return hash;
    }
    
}
