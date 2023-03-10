package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    private int mutationCount =5;
    
    

    public MyMutation(int mutationCount)
    {
        this.mutationCount = mutationCount;
    }
    public MyMutation()
    {
    }
        


    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!
        // your implementation:
        double min = -5;
        double max = 5;

        for(int i =0;i<mutationCount;i++)
        {
            int mutaIndiv= random.nextInt(population.size());
            int indiv_length= population.get(mutaIndiv).length;
            int mutaIndex = random.nextInt(indiv_length);
            double new_bit = min +(random.nextDouble()*(max-min));
            double[] selected_indiv=population.get(mutaIndiv);
            selected_indiv[mutaIndex] = new_bit;
        }
       
        //result population
        return population;
    }
    
}
