/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_04;

import java.util.ArrayList;

/**
 *
 * @author moham
 */
public class GeneticAlgorithm {

    private static final int N = 6;

    
public void start() {
        ArrayList<String> population = generatePopulation();
        ArrayList<Integer> fitness = InitialFitness(population);
        geneticAlgorithm(population, fitness);
    }

    private void geneticAlgorithm(ArrayList<String> population, ArrayList<Integer> fitness) {
        for (int i = 0; i < 100; ++i) {
            boolean flag = false;
            for (int j = 0; j < N; ++j){
                if (fitness.get(i) == 56){
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            ArrayList<String> newPopulation = new ArrayList<>();
            while (newPopulation.size() != population.size()) {
                String x = randomSelect(population, fitness);
                String y = randomSelect(population, fitness);
                String [] offSprings = reproduce(x, y);
                newPopulation.add(offSprings[0]);
                newPopulation.add(offSprings[1]);
            }
            population.clear();
            population.addAll(newPopulation);
            fitness = calculateFitness(population);
        }
        printSolution(population, fitness);
    }

    private String [] reproduce(String x, String y) {
        String [] offSprings = new String [2];
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int random = (int) (Math.random() * 4);
        sb.append(x.substring(0, random));
        sb.append(y.substring(random, 4));
        offSprings[0] = sb.toString();
        sb1.append(y.substring(0, random));
        sb1.append(x.substring(random, 4));
        offSprings[1] = sb1.toString();
        System.out.print(x + " " + y + ": " + "(" + random + ")");
        System.out.println(offSprings[0] + " :: " + offSprings[1]);
        return offSprings;
    }
    
    private ArrayList<Integer> calculateFitness(ArrayList<String> population) {
        ArrayList<Integer> fitness = new ArrayList<>(N);
        for (int i = 0; i < N; ++i) {
            int a = Integer.parseInt(population.get(i), 2);
            int b = (int) (15 * a - Math.pow(a, 2));
            fitness.add(b);
            System.out.println(fitness.get(i));
        }
        return fitness;
    }

    private String randomSelect(ArrayList<String> population, ArrayList<Integer> fitness) {
        String s = "";
        int random = 0;
        while(true){
            random = (int) (Math.random() * N); 
            if (fitness.get(random) > 0.5){
                s = population.get(random);
                break;
            }
        }
//        population.remove(random);
//        fitness.remove(random);
        return s; 
    }

    private ArrayList<String> generatePopulation() {
        ArrayList<String> population = new ArrayList<>(N);
        population.add("1100");
        population.add("0100");
        population.add("0001");
        population.add("1110");
        population.add("0111");
        population.add("1001");
        return population;
    }

    private void printSolution(ArrayList<String> population, ArrayList<Integer> fitness) {
        double max = 0; 
        int index = 0;
        for (int i = 0; i < N; ++i) {
            System.out.println(population.get(i) + " :: " + fitness.get(i));
            if (fitness.get(i) > max) {
                max = fitness.get(i);
                index = i;
            }
        }
        System.out.println(Integer.parseInt(population.get(index), 2));
    }

    private ArrayList<Integer> InitialFitness(ArrayList<String> population) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; ++i){
           list.add(36);
           list.add(44);
           list.add(14);
           list.add(14);
           list.add(56);
           list.add(54);
        }
        return  list;
    }
    
}

