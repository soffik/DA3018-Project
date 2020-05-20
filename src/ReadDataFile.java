import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadDataFile {


    public static Graph readFile(String fileName) {
        Graph graph = new Graph();

        try{

            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int num = 0;

            ArrayList<String> nodes = new ArrayList<>();

            while (scanner.hasNextLine()) {

                int node1;
                int node2;

                String line = scanner.nextLine();
                String[] split = line.split(" ");

                if (!nodes.contains(split[0])) {
                    nodes.add(split[0]);
                    node1 = num;
                    num += 1;
                } else {
                    node1 = nodes.indexOf(split[0]);
                }

                if (!nodes.contains(split[1])) {
                    nodes.add(split[1]);
                    node2 = num;
                    num += 1;
                } else {
                    node2 = nodes.indexOf(split[1]);
                }

                // method addVertex only add vertex if it is not in graph
                graph.addVertex(new Vertex(node1));
                graph.addVertex(new Vertex(node2));

                graph.addEdge(node1, node2);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found.");
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }

        return graph;
    }


}
