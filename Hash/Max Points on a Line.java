//Max Points on a Line

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int maxPoints = 0, overlap = 0, vertical = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x) {
                    if (points[j].y == points[i].y) {
                        overlap++;
                        continue;
                    } else {
                        vertical++;
                        continue;
                    } 
                }
                int dy = points[j].y - points[i].y;
                int dx = points[j].x - points[i].x;
                int temp = gcd(dy, dx);
                dy /= temp;
                dx /= temp;
                String k = dy + "/" + dx;
                if (!map.containsKey(k)) {
                    map.put(k, 0);
                } 
                map.put(k, map.get(k) + 1);
                maxPoints = Math.max(maxPoints, map.get(k));
                
            }
            maxPoints = Math.max(maxPoints, vertical);
            ans = Math.max(ans, maxPoints + overlap + 1);
        }
        return ans;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}