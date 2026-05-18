import java.util.*;

public class UnweightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> map = new HashMap<>();

    public UnweightedGraph() {
        this(true);
    }

    public UnweightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        if (hasVertex(v))
            return;

        map.put(v, new Vertex<>(v));
    }

    public void addEdge(T source, T dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacentVertex(map.get(dest), 1);

        if (undirected)
            map.get(dest).addAdjacentVertex(map.get(source), 1);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).getAdjacentVertices().size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).getAdjacentVertices().containsKey(map.get(dest));
    }

    public Map<Vertex<T>, Double> adjacencyList(T v) {
        if (!hasVertex(v)) return null;

        return map.get(v).getAdjacentVertices();
    }
}

