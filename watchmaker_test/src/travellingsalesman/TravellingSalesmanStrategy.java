package travellingsalesman;

import java.util.Collection;
import java.util.List;

/**
 * Defines methods that must be implemented by classes that provide
 * solutions to the Travelling Salesman problem.
 * @author Daniel Dyer
 */
public interface TravellingSalesmanStrategy
{
    /**
     * @return A description of the strategy.
     */
    String getDescription();

    /**
     * Calculates the shortest round trip distance that visits each
     * of the specified cities once and returns to the starting point.
     * @param cities The destination that must each be visited for the route
     * to be valid.
     * @param progressListener A call-back for keeping track of the route-finding
     * algorithm's progress.
     * @return The shortest route found for the given list of destinations.
     */
    List<String> calculateShortestRoute(Collection<String> cities,
                                        ProgressListener progressListener);
}
