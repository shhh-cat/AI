import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String,List<Vertex>> adjacentVertices;

    public Graph() {
        this.adjacentVertices = new HashMap<>();
    }

    public void addVertex(String label) {
        this.adjacentVertices.putIfAbsent(label, new ArrayList<>());
    }

//    public void removeVertex(String label) {
//        Vertex v = new Vertex(label);
//        adjVertices.values().forEach(e -> e.remove(v));
//        adjVertices.remove(new Vertex(label));
//    }

    public void addEdge(String label1, String label2, Integer weight) {
        Vertex v1 = new Vertex(weight,label1);
        Vertex v2 = new Vertex(weight,label2);
        adjacentVertices.get(label1).add(v2);
        adjacentVertices.get(label2).add(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjacentVertices.get(label);
    }

}
