package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList<double[]> children = new ArrayList<double[]>();

        // your implementation:
        double[] offspring1 = p1.clone();
        double[] offspring2 = p2.clone();
        for (int j = 0; j < i; j++)
        {
            // Cross-over index is always greater than zero and less than
            // the length of the parent so that we always pick a point that
            // will result in a meaningful cross-over.
            int crossoverIndex = (1 + random.nextInt(p1.length - 1));
            for(int index=0;index<crossoverIndex;index++)
            {
                int from_p1 = (int) p1[index];
                offspring1[crossoverIndex] = offspring2[crossoverIndex];
                offspring2[crossoverIndex] = from_p1;
            }

        }


        children.add(offspring1);
        children.add(offspring2);
        return children;
    }
}
