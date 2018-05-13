//Is Graph Bipartite?

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int[] set = new int[graph.length];
        
        for (int n = 0; n < graph.length; n++) {
            if (set[n] == 0) {
                Deque<Integer> queue = new ArrayDeque<>();
                queue.offerLast(n);
                set[n] = -1;
                int group = -1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    group = -group;
                    for (int i = 0; i < size; i++) {
                        int cur = queue.pollFirst();
                            for (int neighbor : graph[cur]) {
                                if (set[neighbor] == 0) {
                                    set[neighbor] = group;
                                    queue.offerLast(neighbor);
                                } else if (set[neighbor] == group) {
                                     continue;
                                } else {
                                    return false;
                                }
                            }
                    }
                }
            }
        }
        return true;
    }
}