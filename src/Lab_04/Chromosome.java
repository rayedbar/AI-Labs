/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_04;

import java.util.Objects;

/**
 *
 * @author moham
 */
public class Chromosome {
    
    private String genes;
    private int fitness;
    
    public Chromosome(String genes, int fitness){
        this.genes = genes;
        this.fitness = fitness;
    }

    /**
     * @return the genes
     */
    public String getGenes() {
        return genes;
    }

    /**
     * @param genes the genes to set
     */
    public void setGenes(String genes) {
        this.genes = genes;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * @param fitness the fitness to set
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
    @Override
    public boolean equals(Object o1){
        if (o1 instanceof Chromosome){
            Chromosome c = (Chromosome) o1;
            if (this.genes.equals(c.genes)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.genes);
        return hash;
    }
    
}
