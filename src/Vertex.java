import java.util.LinkedList;

class Vertex {

    private Integer vertexLabel;
    private LinkedList<Vertex> neighbors = new LinkedList<>();

    Vertex(int label) {
        vertexLabel = label;
    }

    public Integer getVertexLabel() {
        return vertexLabel;
    }

    public void addNeighbor(Vertex n) {
        neighbors.add(n);
    }

    public LinkedList<Vertex> getNeighbors() {
        return neighbors;
    }

    public int degree() {
        return neighbors.size();
    }

}
