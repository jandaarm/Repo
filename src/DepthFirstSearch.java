public class DepthFirstSearch<T> extends Search<T> {

    public DepthFirstSearch(UnweightedGraph<T> graph, T source) {
        super(graph, source);

        Vertex<T> start = graph.getVertex(source);

        dfs(start);
    }

    private void dfs(Vertex<T> current) {

        marked.add(current);

        for (Vertex<T> neighbor :
                current.getAdjacentVertices().keySet()) {

            if (!marked.contains(neighbor)) {

                edgeTo.put(neighbor, current);

                dfs(neighbor);
            }
        }
    }
}