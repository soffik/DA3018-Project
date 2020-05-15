import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadGraphFile {

    public static Graph read(String fileName) {
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



}
