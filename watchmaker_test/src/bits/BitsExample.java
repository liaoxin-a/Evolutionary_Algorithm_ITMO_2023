// package org.uncommons.watchmaker.examples.bits;
package bits;
import java.util.ArrayList;
import java.util.List;
import org.uncommons.maths.binary.BitString;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.factories.BitStringFactory;
import org.uncommons.watchmaker.framework.operators.BitStringCrossover;
import org.uncommons.watchmaker.framework.operators.BitStringMutation;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.TargetFitness;
import examples.EvolutionLogger;


public class BitsExample
{
    private static final int BITS = 100;

    public static void main(String[] args)
    {
        evolveBits(BITS);
    }


    public static BitString evolveBits(int length)
    {
        List<EvolutionaryOperator<BitString>> operators = new ArrayList<EvolutionaryOperator<BitString>>(2);
        operators.add(new BitStringCrossover(1, new Probability(0.7d)));
        operators.add(new BitStringMutation(new Probability(0.01d)));
        EvolutionaryOperator<BitString> pipeline = new EvolutionPipeline<BitString>(operators);
        GenerationalEvolutionEngine<BitString> engine = new GenerationalEvolutionEngine<BitString>(new BitStringFactory(length),
                                                                                                   pipeline,
                                                                                                   new BitStringEvaluator(),
                                                                                                   new RouletteWheelSelection(),
                                                                                                   new MersenneTwisterRNG());
        engine.setSingleThreaded(true); // Performs better for very trivial fitness evaluations.
        engine.addEvolutionObserver(new EvolutionLogger<BitString>());
        return engine.evolve(100, // 100 individuals in each generation.
                             0, // Don't use elitism.
                             new TargetFitness(length, true)); // Continue until a perfect match is found.        
    }
}
