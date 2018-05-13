//Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequest : prerequisites) {
            graph.get(prerequest[1]).add(prerequest[0]);
            degree[prerequest[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            
            for (int i = 0; i < graph.get(cur).size(); i++) {
                degree[graph.get(cur).get(i)]--;
                if (degree[graph.get(cur).get(i)] == 0) {
                    queue.offer(graph.get(cur).get(i));
                }
            }
        }
        return count == numCourses;
        
    }
}