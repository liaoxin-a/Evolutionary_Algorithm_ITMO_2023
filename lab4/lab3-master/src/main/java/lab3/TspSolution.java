package lab3;
import java.util.List;
public class TspSolution {
    private List<Integer> route_index;
    // any required fields and methods

    public TspSolution(List<Integer> route_index) {
        set_route(route_index);
    }


    public int getsize()
    {
        return route_index.size();
    }


    public List<Integer> getroure()
    {
        return route_index;
    }


    public int get(int index) {
        return route_index.get(index);
    }

    public void add(int city_index) {
        route_index.add(city_index);
    }


    public void set_route(List<Integer> route) {
        this.route_index = route;
    }


}
