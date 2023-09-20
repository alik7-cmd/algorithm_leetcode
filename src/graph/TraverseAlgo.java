package graph;

import java.util.*;

public class TraverseAlgo {

    static class Graph {

        int v; // number of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }


        public void bfs(int s) {
            boolean[] visited = new boolean[v];
            Queue<Integer> queue = new LinkedList<>();
            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()) {

                int n = queue.poll();
                System.out.print(n + " -> ");

                Iterator<Integer> iterator = adj[n].iterator();

                while (iterator.hasNext()) {
                    int i = iterator.next();

                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }

            }

        }

        public void bfsAgain(int s){
            boolean [] visited = new boolean[v];
            Queue<Integer> queue = new LinkedList();
            queue.add(s);
            visited[s] = true;

            while (!queue.isEmpty()){
                int node = queue.poll();
                System.out.println(" --> "+node);
                Iterator<Integer> iterator = adj[node].iterator();
                while (iterator.hasNext()){
                    int adjNode = iterator.next();
                    if(!visited[adjNode]){
                        visited[adjNode] = true;
                        queue.add(adjNode);
                    }
                }

            }
        }

        public void dfs(int s) {
            boolean[] visited = new boolean[v];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            visited[s] = true;
            stack.push(s);
            while (!stack.isEmpty()) {
                int n = stack.pop();
                System.out.print(n + " -> ");

                Iterator<Integer> iterator = adj[n].iterator();
                while (iterator.hasNext()) {
                    int i = iterator.next();

                    if (!visited[i]) {
                        visited[i] = true;
                        stack.push(i);
                    }
                }

            }


        }
    }

    public static void main(String[] args) {
        // Total 5 vertices in graph
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is the Depth First Traversal");
        graph.bfs(0);
        /*System.out.println("");
        g.dfs(0);*/
    }
}
