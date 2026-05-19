import java.util.*;

public class DijkstraSearch<T> extends Search<T> {

    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distances;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {

        super(graph, source);

        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();

        dijkstra();
    }

    private void dijkstra() {

        distances.put(source, 0.0);

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {

            Vertex<T> current =
                    getVertexWithMinimumWeight(unsettledNodes);

            unsettledNodes.remove(current);

            marked.add(current);

            for (Map.Entry<Vertex<T>, Double> entry :
                    current.getAdjacentVertices().entrySet()) {

                Vertex<T> neighbor = entry.getKey();

                double weight = entry.getValue();

                double newDistance =
                        getShortestDistance(current) + weight;

                if (newDistance < getShortestDistance(neighbor)) {

                    distances.put(neighbor, newDistance);

                    edgeTo.put(neighbor, current);

                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private Vertex<T> getVertexWithMinimumWeight(
            Set<Vertex<T>> vertices) {

        Vertex<T> minimum = null;

        for (Vertex<T> vertex : vertices) {

            if (minimum == null) {
                minimum = vertex;
                continue;
            }

            if (getShortestDistance(vertex)
                    < getShortestDistance(minimum)) {

                minimum = vertex;
            }
        }

        return minimum;
    }

    private double getShortestDistance(Vertex<T> vertex) {

        Double distance = distances.get(vertex);

        return distance == null
                ? Double.MAX_VALUE
                : distance;
    }
}