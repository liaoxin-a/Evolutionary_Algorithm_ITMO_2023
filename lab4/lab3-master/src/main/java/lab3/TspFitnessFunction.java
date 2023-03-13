package lab3;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class TspFitnessFunction implements FitnessEvaluator<TspSolution> {
    private Point[] Points;
    private double[][] map_array;
    private int dimention;

    public TspFitnessFunction(String problem) {
        problem = problem.toLowerCase();
        String file_path = "/resourse/"+problem + ".tsp.txt";
        this.Points=get_points(file_path);
        this.map_array=get_maparray(Points);

    }

    public double getFitness(TspSolution solution, List<? extends TspSolution> list) {

        Set <Integer> test = new HashSet<Integer>(solution.getroure());
        if (test.size() != dimention) {
            System.out.println("\t!!!!!!!!!!!!! oslution error= ");
        }
        double totalDistance = 0;
        
        int cityCount = solution.getsize();
        for (int i = 0; i < cityCount; i++) {
            int nextIndex = i < cityCount - 1 ? i + 1 : 0;
            if (i >= cityCount | nextIndex >= cityCount) {
                System.out.println("\t!!!!!!!!!!!!! solution error= ");
            }
            totalDistance += get_distance(solution.get(i),solution.get(nextIndex));
        }
        
        return totalDistance;
        
    }

    public boolean isNatural() {
        return false;
    }
    
    public Point[] get_points(String filepath)
    {
        try {
            File file = new File(filepath);
            Boolean is_file = file.isFile();
            Boolean is_exists = file.exists();

            if (is_file && is_exists) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(read);
                
                String line = br.readLine();
                String[] tokens = null;

                System.out.println("   Start reading file");
                for (int i = 0; i < 1000 && !line.equals("EOF"); i++) {
                    tokens = line.split(":");

                    if (tokens[0].toString().startsWith("NAME")) {
                        String fileName = tokens[1].trim();
                        System.out.println("   Name: " + fileName);
                    } else if (tokens[0].toString().startsWith("DIMENSION")) {
                        dimention = Integer.parseInt(tokens[1].trim());
                        System.out.println("   Dimension: " + dimention);
                    } else if (tokens[0].toString().startsWith("NODE_COORD_SECTION") && dimention > 0) {
                        Points = new Point[dimention];
                    } else if (Points != null){
                        tokens = line.split("\\s+");
                        int city=Integer.parseInt(tokens[0]);
                        int x = Integer.parseInt(tokens[1]);
                        int y = Integer.parseInt(tokens[2]);
                        Points[city-1]= new Point(x, y);
                    }

                    line = br.readLine().trim();
                }
                br.close();

                System.out.println("   Data scaled successfully");
            }
        } catch (IOException ex) {
            System.err.println(">> Load File Error: " + ex.getMessage());
        }
        return Points;
    }
       
    public double calculate_Distance(int pre_city, int next_city) {
        if (pre_city == next_city) {
            return 0;
        }

        Point city1 = Points[pre_city];
        Point city2 = Points[next_city];
        double distance = Math.sqrt(Math.abs((city1.getX() - city2.getX()) * (city1.getX() - city2.getX())
                + (city1.getY() - city2.getY()) * (city1.getY() - city2.getY())));
        return distance;

    }

    public double[][] get_maparray(Point[] points) {
        double[][] array = new double[dimention][dimention];
        for (int i = 0; i < dimention; i++) {
            for (int j = i; j < dimention; j++) {
                double dis = calculate_Distance(i, j);
                array[i][j] = dis;
                array[j][i] = dis;
            }
        }
        return array;

    }
    
    public double[][] get_array() {
        return map_array;
    }

    public int get_dimention() {
        return dimention;
    }

    public double get_distance(int city_name1, int city_name2) {
        return map_array[city_name1 - 1][city_name2 - 1];
    }
}
