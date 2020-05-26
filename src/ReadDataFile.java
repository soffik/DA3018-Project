import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadDataFile {


    public static Graph readFile(String fileName) {
        Graph graph = new Graph();
        Scanner scanner = null;

        HashMap<String, Integer> map = new HashMap<>();

        try{

            File file = new File(fileName);
            scanner = new Scanner(file);

            int num = 0;

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] split = line.split(" ");

                map.putIfAbsent(split[0], num);
                num += 1;
                map.putIfAbsent(split[1], num);
                num += 1;

                // method addVertex only add vertex if it is not in graph
                graph.addVertex(new Vertex(map.get(split[0])));
                graph.addVertex(new Vertex(map.get(split[1])));

                graph.addEdge(map.get(split[0]), map.get(split[1]));

            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found.");
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        } finally {

            if (scanner != null) {
                scanner.close();
            }
        }

        return graph;
    }


}
