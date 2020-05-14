import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TestNodeDistribution {


    private static Graph read(String fileName) {
        Graph graph = new Graph();

        try{

            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");

                graph.addVertex(new Vertex(Integer.parseInt(split[0])));
                graph.addVertex(new Vertex(Integer.parseInt(split[1])));

                graph.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found.");
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }

        return graph;
    }


    public static void main(String[] args) {

        Graph connectedGraph = TestNodeDistribution.read("testConnectedGraph");
        HashMap<Integer, Integer> degreeMap = connectedGraph.degreeDistribution();

        degreeMap.forEach((k,v) -> System.out.println(k + ": " + v));

        System.out.println(" ");

        Graph disConnectedGraph = TestNodeDistribution.read("testDisconnectedGraph");
        HashMap<Integer, Integer> degreeMapD = disConnectedGraph.degreeDistribution();

        degreeMapD.forEach((k,v) -> System.out.println(k + ": " + v));

    }


}
