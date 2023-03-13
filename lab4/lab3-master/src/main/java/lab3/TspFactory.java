package lab3;

import org.uncommons.watchmaker.framework.FitnessEvaluator;
import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;


import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TspFactory extends AbstractCandidateFactory<TspSolution> {
    private int city_size;
    private TspFitnessFunction fitnessFunction;
    private List<Integer> start_citys;

    public TspFactory(FitnessEvaluator<TspSolution> evaluator) {
        this.city_size = ((TspFitnessFunction) evaluator).get_dimention();
        this.fitnessFunction = (TspFitnessFunction) evaluator;
        this.start_citys = new ArrayList<Integer>();
    }
    
    public TspSolution generateRandomCandidate(Random random) {
        
        //your implementation nearest neighbor
        List<Integer> route_list = new ArrayList<Integer>();

        
        //start city
        int city0 = 0;
        while (city0 == 0 || start_citys.contains(city0)) {
            city0 = 1 + random.nextInt(city_size);
        }
        start_citys.add(city0);
        route_list.add(city0);
        
        for (int i = 0; i < city_size-1; i++) {//i =route index
            int nearest_neighbor = 0;
            double dis;
            Map<Integer, Double> map = find_nearest_neighbor(route_list.get(i), route_list);
            for (Integer s : map.keySet()) {
                nearest_neighbor = s;
                dis = map.get(s);
            }
            route_list.add(nearest_neighbor);

        }

        TspSolution solution = new TspSolution(route_list);

        return solution;

    }

    public Map<Integer, Double> find_nearest_neighbor(int city_namei, List<Integer> route_list) {
        // nearest but not in solution
        Map<Integer, Double> map = new HashMap<Integer, Double>();

        double nearest_result = Double.MAX_VALUE;
        int nearest_index = 0;

        double[] next_dis_array = fitnessFunction.get_array()[city_namei - 1].clone();
        //current aviabel cityes; 
        for (int i = 0; i < city_size; i++) {
            if ((!route_list.contains(i + 1)) && next_dis_array[i] <= nearest_result) {
                nearest_index = i + 1;
                nearest_result = (double) next_dis_array[i];

            }
        }
        map.put(nearest_index, nearest_result);

        return map;
    }
    

}

