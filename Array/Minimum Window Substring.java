//76. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return new String();
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (right < s.length()) {
            if(map[chS[right]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                if (map[chS[left]] == 0) {
                    count++;
                }
                map[chS[left]]++;
                left++;
                
            }
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? new String() : s.substring(start, start + minLength);
    }
}