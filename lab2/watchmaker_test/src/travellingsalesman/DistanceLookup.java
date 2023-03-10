package travellingsalesman;


import java.util.List;

/**
 * Strategy interface for providing distances between cities in the
 * Travelling Salesman problem.
 * @author Daniel Dyer
 */
public interface DistanceLookup
{
    /**
     * @return The list of cities that this object knows about.
     */
    List<String> getKnownCities();

    /**
     * Looks-up the distance between two cities.
     * @param startingCity The city to start from.
     * @param destinationCity The city to end in.
     * @return The distance (in kilometres) between the two cities.
     */
    int getDistance(String startingCity, String destinationCity);
}
