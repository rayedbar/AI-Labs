/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
public class Graph {

    public int startX, startY, homeX, homeY, dimenX, dimenY;
    public int[][] grid;

    public void build(String file) {
        String[] input;
        int blocked;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            input = br.readLine().split(" ");
            dimenX = Integer.parseInt(input[0]);
            dimenY = Integer.parseInt(input[1]);
            grid = new int[dimenX][dimenY];
            for (int i = 0; i < dimenX; ++i) {
                for (int j = 0; j < dimenY; ++j) {
                    grid[i][j] = 1; 
                }
            }
            input = br.readLine().split(" ");
            startX = Integer.parseInt(input[0]);
            startY = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            homeX = Integer.parseInt(input[0]);
            homeY = Integer.parseInt(input[1]);
            blocked = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < blocked; ++i) {
                input = br.readLine().split(" ");
                int m = Integer.parseInt(input[0]);
                int n = Integer.parseInt(input[1]);
                grid[m][n] = 0;
            }
            br.close();
        } catch (FileNotFoundException | NumberFormatException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printGraph(){
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
}
