import java.util.*;

public class Search<T> {

    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;

    protected final Vertex<T> source;

    protected final UnweightedGraph<T> graph;

    public Search(UnweightedGraph<T> graph, T source) {

        this.graph = graph;

        this.source = graph.getVertex(source);

        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(T data) {

        Vertex<T> v = graph.getVertex(data);

        return marked.contains(v);
    }

    public Iterable<T> pathTo(T data) {

        Vertex<T> v = graph.getVertex(data);

        if (!hasPathTo(data))
            return null;

        LinkedList<T> path = new LinkedList<>();

        for (Vertex<T> i = v;
             !i.equals(source);
             i = edgeTo.get(i)) {

            path.push(i.getData());
        }

        path.push(source.getData());

        return path;
    }
}