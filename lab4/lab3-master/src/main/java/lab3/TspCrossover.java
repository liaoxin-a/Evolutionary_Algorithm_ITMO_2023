package lab3;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TspCrossover extends AbstractCrossover<TspSolution> {
    protected TspCrossover() {
        super(1);
    }

    protected List<TspSolution> mate(TspSolution p1, TspSolution p2, int i, Random random) {
        ArrayList<TspSolution> children = new ArrayList<TspSolution>();
        // your implementation:
        List<Integer> route1 = new ArrayList<Integer>();
        List<Integer> route2 = new ArrayList<Integer>();
        int rout_len = p1.getsize();

        int crossoverfromIndex = random.nextInt(rout_len);
        int crossovertoIndex = crossoverfromIndex;
        while (crossoverfromIndex == crossovertoIndex) {
            crossovertoIndex = random.nextInt(rout_len);
        }
        if (crossoverfromIndex > crossovertoIndex) {
            int tmp = crossoverfromIndex;
            crossoverfromIndex = crossovertoIndex;
            crossovertoIndex = tmp;
        }
        List<Integer> sub_p1 = p1.getroure().subList(crossoverfromIndex, crossovertoIndex);
        List<Integer> sub_p2 = p2.getroure().subList(crossoverfromIndex, crossovertoIndex);

        int p2_index=0;
        int subp1_index = 0;

        int p1_index=0;
        int subp2_index = 0;

        for (int index = 0; index < rout_len; index++) {
            int offspring_city1;
            int offspring_city2;
            if (index < crossoverfromIndex | index >= crossovertoIndex) {
                //1
                offspring_city1 = p2.get(p2_index);
                while (sub_p1.contains(offspring_city1)) {
                    p2_index += 1;
                    offspring_city1 = p2.get(p2_index);
                }
                p2_index += 1;
                //2
                offspring_city2 = p1.get(p1_index);
                while (sub_p2.contains(offspring_city2)) {
                    p1_index += 1;
                    offspring_city2 = p1.get(p1_index);
                }
                p1_index += 1;
            }
            else {
                //1
                offspring_city1 = sub_p1.get(subp1_index);
                subp1_index += 1;
                //2
                offspring_city2 = sub_p2.get(subp2_index);
                subp2_index += 1;
            }
            route1.add(offspring_city1);
            route2.add(offspring_city2);
            
        }

        TspSolution offspring1 = new TspSolution(route1);
        TspSolution offspring2 = new TspSolution(route2);
        children.add(offspring1);
        children.add(offspring2);
        return children;
    }
}
