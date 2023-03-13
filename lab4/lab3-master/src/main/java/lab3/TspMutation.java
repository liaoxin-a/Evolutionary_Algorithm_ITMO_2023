package lab3;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class TspMutation implements EvolutionaryOperator<TspSolution> {

    public List<TspSolution> apply(List<TspSolution> population, Random random) {
        // your implementation:
        List<TspSolution> mutations = new ArrayList<TspSolution>();
        for (int i = 0; i < population.size(); i++) {

            List<Integer> new_rout=new ArrayList<Integer>(population.get(i).getroure());

            int rout_len = population.get(0).getsize();
            int mutfromIndex = random.nextInt(rout_len);
            int muttoIndex = mutfromIndex;
            while (mutfromIndex == muttoIndex) {
                muttoIndex = random.nextInt(rout_len);
            }
            if (mutfromIndex > muttoIndex) {
                int tmp = mutfromIndex;
                mutfromIndex = muttoIndex;
                muttoIndex = tmp;
            }
            List<Integer> sub_p1 = new_rout.subList(mutfromIndex, muttoIndex);
            Collections.shuffle(sub_p1);
            TspSolution mut_indv = new TspSolution(new_rout);

            mutations.add(mut_indv);
        }
        
        return mutations;
    }
}
