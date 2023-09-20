package graph;

import java.util.*;

public class ShortestPath {

    static class Graph{
        int v; // number of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void dfs(int start){
            boolean [] visited = new boolean[v];
            Deque<Integer> stack = new ArrayDeque<Integer>();
            visited[start] = true;
            stack.push(start);

            while (!stack.isEmpty()){
                int node = stack.pop();
                System.out.print(node+" ");
                Iterator<Integer> it = adj[node].iterator();

                while (it.hasNext()){
                    int adjNode = it.next();
                    if(!visited[adjNode]){
                        visited[adjNode] = true;
                        stack.push(adjNode);
                    }
                }
            }

            //stack.get

        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void printPath(int start, int end){
            int [] pred = new int[v];
            int [] dist = new int[v];

            if(!findShortestPathUsingBfs(start, end, pred, dist)){
                return;
            }

            printArray(dist);
            printArray(pred);

            LinkedList<Integer> path = new LinkedList<>();
            int crawl = end;
            path.add(crawl);
            while (pred[crawl] != -1) {
                path.add(pred[crawl]);
                crawl = pred[crawl];
            }

            // Print distance
            System.out.println("Shortest path length is: " + dist[end]);

            // Print path
            System.out.print("Path is --> ");
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i) + " ");
            }
        }

        boolean findShortestPathUsingBfs(int start, int end, int [] pred, int [] dist){
            Queue<Integer> queue = new LinkedList<>();
            boolean [] visited = new boolean[v];

            for (int i = 0; i < v; i++) {
                visited[i] = false;
                dist[i] = Integer.MAX_VALUE;
                pred[i] = -1;
            }

            visited[start] = true;
            queue.add(start);
            dist[start] = 0;


            while (!queue.isEmpty()){
                int node = queue.poll();

                Iterator<Integer> it = adj[node].iterator();
                while (it.hasNext()){
                    int adjNode = it.next();
                    if(!visited[adjNode]){
                        visited[adjNode] = true;

                        dist[adjNode] = dist[node]+1;
                        pred[adjNode] = node;
                        queue.add(adjNode);
                        if(adjNode == end){
                            return true;
                        }
                    }
                }
            }


            return false;
        }

        void printArray(int [] arr){
            for(int i = 0; i< arr.length; i++){
                System.out.print("("+i+","+arr[i]+")"+"  ");
            }

        }
    }

    public static void main(String [] args){
        int v = 8;

        Graph g = new Graph(v);

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        g.addEdge( 0, 1);
        g.addEdge(0, 3);
        g.addEdge( 1, 2);
        g.addEdge( 3, 4);
        g.addEdge( 3, 7);
        g.addEdge( 4, 5);
        g.addEdge( 4, 6);
        g.addEdge( 4, 7);
        g.addEdge( 5, 6);
        g.addEdge( 6, 7);
        int source = 0, dest = 7;
        g.printPath(0, 7);

    }
}
