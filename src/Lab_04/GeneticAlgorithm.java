/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_04;

/**
 *
 * @author moham
 */
public class GeneticAlgorithm {

    private static final int N = 6;

    public void run() {
        String[] population = generate_population();
        genetic_algorithm(population);
    }

    private void genetic_algorithm(String[] population) {
        for (int i = 0; i < 1000; ++i) {
            int[] fitness = calculate_fitness(population);
            if (check_sat(fitness)) {
                print_answer(population, fitness);
                break;
            }
            String[] new_population = new String[N];
            int n = 0;
            while (n < N) {
                String child1 = random_select(population, fitness);
                String child2 = random_select(population, fitness);
                if (Math.random() <= 0.7) {
                    String[] children = crossover(child1, child2);
                    new_population[n + 0] = children[0];
                    new_population[n + 1] = children[1];
                } else {
                    new_population[n + 0] = child1;
                    new_population[n + 1] = child2;
                }
                if (Math.random() <= 0.6) {
                    mutate(new_population, n);
                }
                n += 2;
//                for (int k = 0; k < n; ++k){
//                    System.out.println(new_population[k]);
//                }
            }
            for (int j = 0; j < N; ++j) {
                population[j] = new_population[j];
            }
        }
    }

    private String[] crossover(String c1, String c2) {
        int bPoint = (int) (Math.random() * 4);
        String[] children = new String[2];
        StringBuilder sb = new StringBuilder();
        sb.append(c1.substring(0, bPoint));
        sb.append(c2.substring(bPoint, 4));
        children[0] = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c2.substring(0, bPoint));
        sb2.append(c1.substring(bPoint, 4));
        children[1] = sb2.toString();
        return children;
    }

    private String random_select(String[] population, int[] fitness) {
        return population[(int)(Math.random() * N)];
    }

    private int[] calculate_fitness(String[] population) {
        int[] fitness = new int[N];
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(population[i], 2);
            fitness[i] = (int) (15 * x - Math.pow(x, 2));
        }
        return fitness;
    }

    private void mutate(String[] new_population, int n) {
        int r = (int) (Math.random() + 0.5);
        String x = new_population[n + r];
        int rnd = (int) (Math.random() * 4);
        char[] child = x.toCharArray();
        if (child[rnd] == '1') {
            child[rnd] = '0';
        } else {
            child[rnd] = '1';
        }
        new_population[n + r] = String.copyValueOf(child);
    }

    private boolean check_sat(int[] fitness) {
        int count = 0;
        for(int i = 0; i < N; ++i){
            if (fitness[i] > 54)
                count++;
        }
        return count > 2;
    }

    private String[] generate_population() {
        String[] pop = new String[N];
        pop[0] = "1100";
        pop[1] = "0100";
        pop[2] = "0001";
        pop[3] = "1110";
        pop[4] = "0111";
        pop[5] = "1001";
        return pop;
    }

    private void print_answer(String[] population, int[] fitness) {
        System.out.println("Answer Found:");
        int max = 0;
        int index = 0;
        for (int i = 0; i < N; ++i){
            if (fitness[i] > max){
                max = fitness[i];
                index = i;
            }
        }
        System.out.println(population[index] + " - " + Integer.parseInt(population[index], 2));
    }

}
