import java.util.*;

public class Graph {

    // only used in this class to keep track of vertices by their label
    private Map<Integer, Vertex> vertexMap = new HashMap<>();  // key: vertex label, value: vertex (object)

    Graph() {
    }


    public void addVertex(Vertex vertex) {
        if (!vertexMap.containsKey(vertex.getVertexLabel())) {  // check that node does not exist in graph

            vertexMap.put(vertex.getVertexLabel(), vertex);
        }
    }

    public void addEdge(int label1, int label2) throws NullPointerException {
        if (label1 == label2)  // will not add edge to itself
            return;
        if (!vertexMap.containsKey(label1))
            throw new NullPointerException(label1 + " not a vertex in the graph");
        else if(!vertexMap.containsKey(label2))
            throw new NullPointerException(label1 + " not a vertex in the graph");

        Vertex v1 = vertexMap.get(label1);
        Vertex v2 = vertexMap.get(label2);

        // check that the edge hasn't already been added
        if (!v1.getNeighbors().contains(v2) && !v2.getNeighbors().contains(v1)) {
            v1.addNeighbor(v2);
            v2.addNeighbor(v1);
        }
    }

    public HashMap<Integer, Integer> degreeDistribution() {

        HashMap<Integer, Integer> map = new HashMap<>(); // key: degree, value: # nodes that has that degree

        vertexMap.forEach((key, value) ->
        {if (!map.containsKey(value.degree()))
            map.put(value.degree(), 1);
        else {
            Integer oldValue = map.get(value.degree());
            map.put(value.degree(), oldValue+1);
        }
        });

        return map;
    }


    public HashMap<Integer, Integer> componentDistribution() {
        HashMap<Integer, Integer> toReturn = new HashMap<>();

        vertexMap.forEach((key, value) -> value.setVisited(false));  // set all vertices to not visited

        for (Vertex vertex: vertexMap.values()) {

            int compSize = 0;  // size of each component

            LinkedList<Vertex> queue = new LinkedList<>();
            if (vertex.notVisited()) {
                queue.add(vertex);
                vertex.setVisited(true);
                compSize += 1;
            }

            while(!queue.isEmpty()) {
                Vertex v = queue.poll(); // return and remove first element
                for (Vertex u: v.getNeighbors()) {
                    if (u.notVisited()) {
                        queue.add(u);
                        u.setVisited(true);
                        compSize += 1;
                    }
                }
            }

            if (compSize > 0) { // only add if we have found a new component
                if (!toReturn.containsKey(compSize))
                    toReturn.put(compSize, 1);
                else {
                    Integer oldValue = toReturn.get(compSize);
                    toReturn.put(compSize, oldValue+1);
                }
            }

        }

        return toReturn;
    }



}
