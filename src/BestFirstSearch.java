import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;

public class BestFirstSearch {
    /**
     *
     * @author BlackCat
     *
     */
    public static void run() {
        /**
         * GRAPH:
         * https://media.geeksforgeeks.org/wp-content/uploads/BFS2.png
         */
        Graph graph = new Graph();
        graph.addVertex("S");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");
        graph.addVertex("L");
        graph.addVertex("M");
        graph.addEdge("S","A",3);
        graph.addEdge("S","B",6);
        graph.addEdge("S","C",5);
        graph.addEdge("A","D",9);
        graph.addEdge("A","E",8);
        graph.addEdge("B","F",12);
        graph.addEdge("B","G",14);
        graph.addEdge("C","H",7);
        graph.addEdge("H","I",5);
        graph.addEdge("H","J",6);
        graph.addEdge("I","K",1);
        graph.addEdge("I","L",10);
        graph.addEdge("I","M",2);

        new BestFirstSearch("S","I",graph);
    }

    public BestFirstSearch(String source,String target, Graph graph) {
        Set<String> visited = new HashSet<>();
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(new Vertex(0,source));
        visited.add(source);
        while (!vertexQueue.isEmpty()) {
            Vertex vertex = vertexQueue.poll();
            String label = vertex.label;
            Integer preCost = vertex.withCost;
            if (label == target) return;
            for (Vertex v: graph.getAdjVertices(label)) {
                if (!visited.contains(v.label)) {
                    v.setWithCost(v.withCost + preCost);
                    visited.add(v.label);
                    vertexQueue.add(v);

                }
            }
            System.out.println(vertexQueue.peek() != null ? vertexQueue.peek().label + " ": "");
        }
    }
}
