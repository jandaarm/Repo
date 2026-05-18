import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(UnweightedGraph<T> graph, T source) {
        super(graph, source);

        Vertex<T> start = graph.getVertex(source);

        bfs(start);
    }

    private void bfs(Vertex<T> current) {

        marked.add(current);

        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {

            Vertex<T> v = queue.remove();

            for (Vertex<T> neighbor :
                    v.getAdjacentVertices().keySet()) {

                if (!marked.contains(neighbor)) {

                    marked.add(neighbor);

                    edgeTo.put(neighbor, v);

                    queue.add(neighbor);
                }
            }
        }
    }
}