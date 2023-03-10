package bits;
import java.util.List;
import org.uncommons.maths.binary.BitString;
import org.uncommons.watchmaker.framework.FitnessEvaluator;

public class BitStringEvaluator implements FitnessEvaluator<BitString>
{
    /**
     * Calculates a fitness score for the candidate bit string.
     * @param candidate The evolved bit string to evaluate.
     * @param population {@inheritDoc}
     * @return How many bits in the string are set to 1.
     */
    public double getFitness(BitString candidate,
                             List<? extends BitString> population)
    {
        return candidate.countSetBits();
    }


    /**
     * Always returns true.  A higher score indicates a fitter individual.
     * @return True.
     */
    public boolean isNatural()
    {
        return true;
    }
}
